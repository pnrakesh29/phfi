package com.smh.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.Constant;
import com.smh.constants.FeatureConstants;
import com.smh.constants.URLMappingConstants;
import com.smh.enums.RoleLevel;
import com.smh.exception.SmhAdminException;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.LoginResponse;
import com.smh.model.Response;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;
import com.smh.service.RoleService;
import com.smh.service.UserService;
import com.smh.util.JsonUtil;
import com.smh.util.PaginationUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;
import com.smh.util.UserMgmtFileUtil;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserController implements URLMappingConstants {


	private static Logger logger = Logger.getLogger(UserController.class);

	 
	@Autowired
	private  UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * Method used to show the Admin User Create Screen
	 * 
	 * @param request
	 * @param respone
	 * @param model
	 * @return
	 */
	@RequestMapping(value = SHOW_USER_MANAGEMENT_CREATE, method = RequestMethod.GET)
	public ModelAndView showAdminUserCreate(HttpServletRequest request,
			HttpServletResponse respone, Map model, HttpSession session) {
		logger.info("Entering:: AdminUserController:: showAdminUser method");
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_CREATE);
		String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
		if (!existingFeature.contains(FeatureConstants.CHATAK_USER_CREATE_FEATURE_ID)) {
			session.invalidate();
			modelAndView.setViewName(CHATAK_INVALID_ACCESS);
			return modelAndView;	
		}
		try {
			List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
		      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
		      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
			  if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					model.put("roleLevelList", roleLevelsForAllRoles);
			}
			AdminUserRequest adminUserRequest = new AdminUserRequest();
			model.put("adminUserRequest", adminUserRequest);
			   
		} catch (Exception e) {
			logger.error("ERROR:: AdminUserController:: showAdminUser method2", e);
			model.put(Constant.ERROR, Properties.getProperty("prepaid.admin.general.error.message"));
		}
		logger.info("Exit:: AdminUserController:: showAdminUser method");
		return modelAndView;

	}
	
	
	@RequestMapping(value = PROCESS_BEACON_USER_MANAGEMENT_CREATE, method = RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response, AdminUserRequest adminUserRequest, BindingResult bindingResult, HttpSession session, Map model) {
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_CREATE);
		logger.info("Entering :: AdminUserController ::createUser method ");
		Response response2 = null;
		modelAndView.addObject("adminUserData",adminUserRequest);
		GetRolesOnUserTypeResponse getRolesOnUserTypeResponse = null;
		GetRolesOnUserTypeRequest getRolesOnUserTypeRequest = new GetRolesOnUserTypeRequest();
		try {
			adminUserRequest.setCreatedBy("Admin");
			response2 = userService.createOrUpdateUser(adminUserRequest);
			if (response2 != null && response2.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS)) {
				modelAndView = showAdminUserSearch(request, response, model, session);
				modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("user.create.success"));
			}
			else{
				List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
			      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
			      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
				  if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
						model.put("roleLevelList", roleLevelsForAllRoles);
				}
				  getRolesOnUserTypeRequest.setUserType(RoleLevel.valueOf(adminUserRequest.getUserType()));
				  getRolesOnUserTypeResponse = roleService.getRolesOnUserType(getRolesOnUserTypeRequest);
				  model.put("roleList",getRolesOnUserTypeResponse.getRoles());
				  
				  modelAndView.addObject(Constant.ERROR, response2.getResponseMessage());
				  modelAndView.addObject("adminUserRequest",adminUserRequest);
			}
			session.removeAttribute(Constant.ADMIN_USER_DATA);
		} catch (Exception e) {
			logger.error("Error ::AdminUserController:: createUser method");
			modelAndView.addObject(Constant.ERROR, response2.getResponseMessage());
			modelAndView.setViewName(INVALID_PAGE);
		}
	
		logger.error("Exiting ::AdminUserController:: createUser method");
		return modelAndView;

	}

	/**
	 * Method used for show the Admin User Create Screen
	 * 
	 * @param request
	 * @param respone
	 * @param model
	 * @return
	 */
	@RequestMapping(value = SHOW_USER_MANAGEMENT_SEARCH, method = RequestMethod.GET)
	public ModelAndView showAdminUserSearch(HttpServletRequest request, HttpServletResponse respone, Map model, HttpSession session) {
		
		logger.info("Entering:: AdminUserController:: showAdminUserSearch method");
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
		
		String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
		if (!existingFeature.contains(FeatureConstants.CHATAK_USER_FEATURE_ID)) {
			session.invalidate();
			modelAndView.setViewName(CHATAK_INVALID_ACCESS);
			return modelAndView;
		}
		try {
			// To show the search page if existing feature contains view, edit,
			// suspend or activate feature
			List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
		      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
		      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
		      session.removeAttribute(Constant.ADMIN_USER_DATA);
		      if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					model.put("roleLevelList", roleLevelsForAllRoles);
			}
			AdminUserRequest adminUserRequest = new AdminUserRequest();
			model.put("adminUserRequest", adminUserRequest);
			UserRoleRequest roleRequest = new UserRoleRequest();
			roleRequest.setPageIndex(Constant.ONE);
			roleRequest.setPageSize(9999);
			UserRoleResponse roleResponse=   roleService.searchRole(roleRequest);
			List<UserRoleRequest> rolelists = (List<UserRoleRequest>) roleResponse.getResponseList();
			if(rolelists != null){
				model.put("rolelist", rolelists)  ;
			}
			model.put("adminUserRequest", adminUserRequest);
			modelAndView.addObject("resultflag", false);
		}	
		 catch (Exception e) {
			logger.error("ERROR:: AdminUserController:: showAdminUserSearch", e);
		}
		logger.info("Exit:: AdminUserController:: showAdminUserSearch");
		return modelAndView;

	}
	
	@RequestMapping(value = PROCESS_BEACON_USER_MANAGEMENT_SEARCH, method = RequestMethod.POST)
	  public ModelAndView searchAdminUser(HttpServletRequest request,Map model,
	                                            HttpServletResponse response,
	                                            AdminUserRequest adminUserData ,
	                                            BindingResult bindingResult,
	                                            HttpSession session) {
	    logger.info("Entering:: AdminUserController:: searchAdminUser method");
	    ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
	    session.setAttribute(Constant.ADMIN_USER_DATA, adminUserData);
	    String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
		if (!existingFeature.contains(FeatureConstants.CHATAK_USER_FEATURE_ID)) {
			session.invalidate();
			modelAndView.setViewName(CHATAK_INVALID_ACCESS);
			return modelAndView;
		}
	    try {
	    	adminUserData.setPageIndex(Constant.ONE);
	    	adminUserData.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
	    	UserRoleRequest roleRequest = new UserRoleRequest();
	    	LoginResponse loginResponse = (LoginResponse) session.getAttribute(Constant.LOGIN_RESPONSE_DATA);
	    	
	    	
	    	roleRequest.setPageIndex(Constant.ONE);
			roleRequest.setPageSize(9999);
			UserRoleResponse roleResponse=   roleService.getActiveRole(roleRequest);
			List<UserRoleRequest> rolelists = (List<UserRoleRequest>) roleResponse.getUserRoleRequests();
			if(rolelists != null){
				model.put("rolelist", rolelists)  ;
			}
			
			// to search the user based on usertype
			
			if(RoleLevel.SYSTEM.name().equalsIgnoreCase(loginResponse.getUserType())){
				roleRequest.setEntityId(loginResponse.getEntityId());
			
			AdminUserResponse searchResponses=searchUserBasedOnRoleCategory(loginResponse,session, modelAndView, adminUserData, rolelists);
			if(StringUtil.isListNotNullNEmpty(searchResponses.getResponseList())){
				modelAndView=PaginationUtil.getPagenationModel(modelAndView, searchResponses.getNoOfRecords());
				modelAndView.addObject("roleList", searchResponses.getResponseList());
				model.put("totalCount",  searchResponses.getNoOfRecords());
			}else {
				modelAndView.addObject("roleList",rolelists);
			}
			
			 searchResponses = userService.searchAdminUser(adminUserData);	
				
			List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
		      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
		      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
		      if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					model.put("roleLevelList", roleLevelsForAllRoles);
			}
	    	if(searchResponses != null) {
	    		modelAndView = PaginationUtil.getPagenationModel(modelAndView, searchResponses.getNoOfRecords());
	    		List<AdminUserRequest> searchUserList  = searchResponses.getAdminUserList();
	    		modelAndView.addObject("resultflag", true);
	    		model.put("totalCount", searchResponses.getNoOfRecords());
	    		model.put("searchUserList",searchUserList );
	    	} else{
	    		modelAndView=showAdminUserSearch(request, response, model, session);
	    	}
	    }
	 }
	    
	    catch(Exception e) {
	        logger.error("Error:: AdminUserController:: searchAdminUser", e);
	        modelAndView.setViewName(INVALID_PAGE);
	      }
	
	 logger.info("Exiting:: AdminUserController:: searchAdminUser");
	 model.put("adminUserData", adminUserData);
	    return modelAndView;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param adminUserId
	 * @return
	 */
	@RequestMapping(value = SHOW_USER_MANAGEMENT_EDIT, method = RequestMethod.POST)
	public ModelAndView showEditAdminUser(HttpServletRequest request,
											HttpServletResponse response, HttpSession session, Map model,
											@FormParam("adminUserId") final String adminUserId) {
		logger.info("Entering :: AdminUserController ::showEditAdminUser method ");
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_EDIT);
		UserRoleRequest roleRequest = new UserRoleRequest();
		modelAndView.addObject(Constant.ERROR, null);
		modelAndView.addObject(Constant.SUCCESS, null);
		logger.info("Entering :: AdminUserController ::showEditAdminUser method ");
		AdminUserResponse adminUserResponse = null;
		AdminUserRequest adminUserRequest = null;
		EditRoleResponse editRoleResponse = null; 
		
		String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
		LoginResponse loginResponse = (LoginResponse)session.getAttribute(Constant.LOGIN_RESPONSE_DATA);
		if (!existingFeature.contains(FeatureConstants.CHATAK_USER_EDIT_FEATURE_ID)) {
			session.invalidate();
			modelAndView.setViewName(CHATAK_INVALID_ACCESS);
			return modelAndView;
		}
		try {
			adminUserResponse = userService.findByAdminUserId(Long.valueOf(adminUserId));
			roleRequest.setRoleId(adminUserResponse.getAdminUserList().get(0).getUserRoleId().toString());
			editRoleResponse = roleService.getRoleDetails(roleRequest);
			if (adminUserResponse != null) {
				adminUserRequest = adminUserResponse.getAdminUserList().get(0);
				adminUserRequest.setRoleName(editRoleResponse.getRoleRequest().getRoleName());
				modelAndView.addObject("adminUserRequest", adminUserRequest);
			}
			 if(loginResponse.getUserId() != null && editRoleResponse.getRoleRequest() != null){
		    	  if(loginResponse.getUserId().compareTo(Long.valueOf(adminUserResponse.getAdminUserList().get(0).getAdminUserId())) == 0){
		    		  model.put("SAME_ROLE_FLAG", "true");
		    	  } else {
		    		  model.put("SAME_ROLE_FLAG", "false");
		    	  }
		      }
		} catch (Exception e) {
			logger.error("Error :: AdminUserController ::showEditAdminUser method ", e);
			modelAndView.setViewName(INVALID_PAGE);
		}
		modelAndView.addObject("adminUserRequest", adminUserRequest);
		logger.info("Exiting :: AdminUserController ::showEditAdminUser method ");
		return modelAndView;
	}
	
	
	@RequestMapping(value = PROCESS_BEACON_ADMIN_USER_MANAGEMENT_EDIT, method = RequestMethod.POST)
	public ModelAndView updateAdminUser(HttpServletRequest request,
												HttpServletResponse response, AdminUserRequest adminUserRequest,
												BindingResult bindingResult, HttpSession session, Map model) {
		logger.info("Entering :: AdminUserController ::updateAdminUser method ");
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_EDIT);
		modelAndView.addObject(Constant.ERROR, null);
		modelAndView.addObject(Constant.SUCCESS, null);
		Response adminUserResponse = null;
		try {
			adminUserRequest.setCreatedBy("Admin");
			if(adminUserRequest.getStatus().equals(Constant.SUSPENDED)) {
				adminUserRequest.setStatusChangeFlage(Constant.Yes);
				 adminUserResponse = userService.createOrUpdateUser(adminUserRequest);
			} else {
				adminUserRequest.setStatusChangeFlage(Constant.No);
				adminUserResponse = userService.createOrUpdateUser(adminUserRequest);
			}
			if (adminUserResponse != null && adminUserResponse.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS)) {
				modelAndView = showAdminUserSearch(request, response, model, session);
				modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("user.edit.success"));
			} else {
				modelAndView = showEditAdminUser(request, response, session, model, adminUserRequest.getAdminUserId().toString());
				modelAndView.addObject(Constant.ERROR, adminUserResponse.getResponseMessage());
			}
		} catch (Exception e) {
			logger.error("Error :: AdminUserController ::updateAdminUser method ", e);
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.info("Exiting :: AdminUserController ::updateAdminUser method ");
		return modelAndView;
	}
	  
	  
	@RequestMapping(value = CHATAK_ADMIN_ADMIN_USER_PAGINATION, method = RequestMethod.POST)
	public ModelAndView getPage(HttpSession session, @FormParam("pageNumber") final Integer pageNumber, @FormParam("totalRecords") final Integer totalRecords, Map model) {
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
		logger.info("Entering :: AdminUserController ::getPage method ");
		AdminUserRequest adminUserRequest = (AdminUserRequest) session.getAttribute(Constant.ADMIN_USER_DATA);
		UserRoleRequest roleRequest = new UserRoleRequest();
		try {
			
			roleRequest.setPageIndex(Constant.ONE);
			roleRequest.setPageSize(9999);
			UserRoleResponse roleResponse=   roleService.getActiveRole(roleRequest);
			List<UserRoleRequest> rolelists = (List<UserRoleRequest>) roleResponse.getUserRoleRequests();
			if(rolelists != null){
				model.put("rolelist", rolelists)  ;
			}
			List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
		      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
		      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
		      if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					model.put("roleLevelList", roleLevelsForAllRoles);
			}
			
		    adminUserRequest.setPageIndex(pageNumber);
		    adminUserRequest.setNoOfRecords(totalRecords);
		    adminUserRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			AdminUserResponse adminUserResponse = userService.searchAdminUser(adminUserRequest);
			List<AdminUserRequest> adminUserRequests = new ArrayList<AdminUserRequest>();
			if (adminUserResponse != null && !CollectionUtils.isEmpty(adminUserResponse.getAdminUserList())) {
				adminUserRequests = adminUserResponse.getAdminUserList();
				modelAndView = PaginationUtil.getPagenationModelSuccessive(modelAndView, pageNumber, adminUserResponse.getNoOfRecords());
				model.put("totalCount", adminUserResponse.getNoOfRecords());
				model.put("searchUserList", adminUserRequests);
				model.put("adminUserRequest", adminUserRequest);
				modelAndView.addObject("resultflag", true);
				
				modelAndView.addObject("roleList",rolelists);
			}
		} catch (Exception e) {
			logger.error("Errorg :: AdminUserController ::getPage method ", e);
			modelAndView.setViewName(INVALID_PAGE);
		}
		
		logger.info("Exiting :: AdminUserController ::getPage method ");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_ADMIN_ADMIN_USER_REPORT, method = RequestMethod.POST)
	public ModelAndView getReportPage(HttpServletRequest request,
										HttpServletResponse response, 
										Map model, HttpSession session,
										@FormParam("downLoadPageNumber") final Integer downLoadPageNumber,
										@FormParam("downloadType") final String downloadType) {
		ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
		logger.info("Entering :: AdminUserController ::getReportPage method ");
		AdminUserResponse adminUserResponse = null;
		AdminUserRequest userRequest =(AdminUserRequest) session.getAttribute(Constant.ADMIN_USER_DATA);
		try {
			userRequest.setPageIndex(downLoadPageNumber);
			userRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			adminUserResponse = userService.searchAdminUser(userRequest);
			if (adminUserResponse != null && !CollectionUtils.isEmpty(adminUserResponse.getAdminUserList())) {

				if (Constant.PDF_FILE_FORMAT.equalsIgnoreCase(downloadType)) {
					UserMgmtFileUtil.downloadUserPdf(adminUserResponse.getAdminUserList(), response);
				} else if (Constant.XLS_FILE_FORMAT.equalsIgnoreCase(downloadType)) {
					UserMgmtFileUtil.downloadUserXl(adminUserResponse.getAdminUserList(), response);
				}
			}
		} catch (Exception e) {
			logger.error("Error :: AdminUserController ::getReportPage method ", e);
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.info("Exiting :: AdminUserController ::getReportPage method ");
		return modelAndView;
	}
	
	private List<RoleLevel>	getRoleListForRoles(List<RoleLevel> roleLevelList, HttpSession session, List<RoleLevel> roleLevels){
		LoginResponse loginResponse=(LoginResponse)session.getAttribute(Constant.LOGIN_RESPONSE_DATA);
		if(loginResponse.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name())){
			roleLevels = Arrays.asList(RoleLevel.SYSTEM);
		}
		return roleLevels;
	}
		
	 private  AdminUserResponse searchUserBasedOnRoleCategory(LoginResponse loginResponse,HttpSession session,ModelAndView modelAndView,AdminUserRequest adminUserData, List<UserRoleRequest> roleList) throws SmhAdminException{
		 AdminUserResponse searchResponse=null;
			if (loginResponse.getUserType().toString().equals(RoleLevel.SYSTEM.toString())) {
		  		/*setAuditData(userRoleRequest, session, AuditSection.Roles.name(), AuditEvent.Search.name());*/
		  		 searchResponse = userService.searchAdminUser(adminUserData);
		     }
			return searchResponse;
		}
	 
		/* @RequestMapping(value = SMH_ADMIN_UNIQUE_USER, method = RequestMethod.GET)
		  public @ResponseBody String getUniqueUserName(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse,@PathParam("userName")
		  final String userName,@PathParam("adminUserId") final String adminUserId) {
		    logger.info("Entering :: AdminUserController :: getUniqueUserName method ");
		    AdminUserRequest adminUserRequest = new AdminUserRequest();
		    try {
		    	adminUserRequest.setUserName(userName.trim());
		    	AdminUserResponse adminUserResponse = userService.searchAdminUser(adminUserRequest);
		    	List<AdminUserRequest> list = adminUserResponse.getAdminUserList();
				if (CommonUtil.isListNotNullAndEmpty(list) && (StringUtil.isNullAndEmpty(adminUserId) ? true : !(list.get(0).getAdminUserId().equals(adminUserId)))) {
					adminUserResponse.setResponseCode(BeaconErrorCodes.ADMIN_USER_ALREADY_EXIST);
					adminUserResponse.setResponseMessage(Properties.getProperty(adminUserResponse.getResponseCode()));
				} else {
					adminUserResponse.setResponseCode(BeaconErrorCodes.BEACON_SUCCESS);
					adminUserResponse.setResponseMessage(Properties.getProperty(adminUserResponse.getResponseCode()));
				}
				return JsonUtil.convertObjectToJSON(adminUserResponse);
		    }
		    catch(Exception e) {
		      logger.error("ERROR:: AdminUserController:: getUniqueUserName method", e);
		    }
		    logger.info("Exiting:: AdminUserController:: getUniqueUserName method");
		    return null;

		  }
*/	/*	 
		 @RequestMapping(value = SMH_ADMIN_UNIQUE_USER_EMAIL, method = RequestMethod.GET)
		  public @ResponseBody String getUniqueUserEmail(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse,@PathParam("email")
		  final String email,@PathParam("adminUserId") final String adminUserId) {
		    logger.info("Entering :: AdminUserController :: getUniqueUserEmail method ");
		    AdminUserRequest adminUserRequest = new AdminUserRequest();
		    try {
		    	adminUserRequest.setEmail(email.trim());
		    	AdminUserResponse adminUserResponse = userService.searchAdminUser(adminUserRequest);
				List<AdminUserRequest> list = adminUserResponse.getAdminUserList();
				if (CommonUtil.isListNotNullAndEmpty(list) && (StringUtil.isNullAndEmpty(adminUserId) ? true : !(list.get(0).getAdminUserId().equals(Long.valueOf(adminUserId))))) {
					adminUserResponse.setResponseCode(BeaconErrorCodes.USER_EMAIL_ALRAEDY_EXIST);
					adminUserResponse.setResponseMessage(Properties.getProperty(adminUserResponse.getResponseCode()));
				} else {
					adminUserResponse.setResponseCode(BeaconErrorCodes.BEACON_SUCCESS);
					adminUserResponse.setResponseMessage(Properties.getProperty(adminUserResponse.getResponseCode()));
				}
				return JsonUtil.convertObjectToJSON(adminUserResponse);
		    }
		    catch(Exception e) {
		      logger.error("ERROR:: AdminUserController:: getUniqueUserEmail method", e);
		    }
		    logger.info("Exiting:: AdminUserController:: getUniqueUserEmail method");
		    return null;

		  }
*/	 
	 @RequestMapping(value = FETCH_CHATAK_ADMIN_USER_DETAILS, method = RequestMethod.GET)
		public @ResponseBody
		String fetchRoleOnUserType(HttpServletRequest request,
				HttpServletResponse response, Map model, HttpSession session) {
			String userType = request.getParameter("userType");
			String jsonData=null;
			try {
				GetRolesOnUserTypeRequest getRolesOnUserTypeRequest = new GetRolesOnUserTypeRequest();
				getRolesOnUserTypeRequest.setUserType(RoleLevel.valueOf(userType));
				UserRoleRequest roleRequest = new UserRoleRequest();
				roleRequest.setRoleType(RoleLevel.valueOf(userType));
				UserRoleResponse roleResponse=   roleService.getActiveRole(roleRequest);
				jsonData= JsonUtil.convertObjectToJSON(roleResponse);
			}  catch (Exception e) {
				logger.error("ERROR:: AdminUserController:: fetchRoleOnUserType method", e);
			}
			
			logger.info("Exiting  :: AdminUserController:: fetchRoleOnUserType method");
			return jsonData;

		}
	 
	 @RequestMapping(value = CHATAK_ADMIN_USER_STATUS_CHANGE, method = RequestMethod.POST)
		public ModelAndView changeUserStatus(HttpServletRequest request, HttpServletResponse response, @FormParam("statusChangeUserId") final String statusChangeUserId,
				@FormParam("reason") final String reason, @FormParam("statusChange") final String statusChange,AdminUserRequest adminUserRequest, 
				Map model,HttpSession session) {
			ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
			modelAndView.addObject(Constant.ERROR, null);
			modelAndView.addObject(Constant.SUCCESS, null);
			logger.info("Entering :: AdminUserController ::changeUserStatus method ");
			String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
			if(statusChange.equals(Constant.ACTIVE)){
				if (!existingFeature.contains(FeatureConstants.CHATAK_USER_SUSPEND_FEATURE_ID)) {
					session.invalidate();
					modelAndView.setViewName(CHATAK_INVALID_ACCESS);
					return modelAndView;
				}
			}
			else if(statusChange.equals(Constant.SUSPENDED)){
				if (!existingFeature.contains(FeatureConstants.CHATAK_USER_SUSPEND_FEATURE_ID)) {
					session.invalidate();
					modelAndView.setViewName(CHATAK_INVALID_ACCESS);
					return modelAndView;
				}
			}
			try {
				
				Long id = Long.parseLong(statusChangeUserId);
				if(id != null) {
					adminUserRequest.setReason(reason);
					adminUserRequest.setStatus(statusChange);
					adminUserRequest.setStatusChangeFlage(Constant.Yes);
					adminUserRequest.setAdminUserId(id);
					Response adminUserResponse = userService.createOrUpdateUser(adminUserRequest);
					if(adminUserResponse.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS))
					{
						if(adminUserRequest.getStatus().equalsIgnoreCase(Constant.SUSPENDED)){
					modelAndView = showAdminUserSearch(request, response, model, session);
					modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("user.status.success")/*.replace("$$$##", statusChange.equals(Constant.ACTIVE) ? "Activated" : "Suspended")*/);
						}
						else{
							modelAndView = showAdminUserSearch(request, response, model, session);
							modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("user.status.success").replace("Suspended","Activated"));
						}
					}
					else{
						modelAndView = showAdminUserSearch(request, response, model, session);
						modelAndView.addObject(Constant.ERROR, adminUserResponse.getResponseMessage());	
					}
				}
				
			} catch (Exception e) {
				logger.error("Error :: AdminUserController ::changeUserStatus method ", e);
				modelAndView.setViewName(INVALID_PAGE);
			}
			logger.info("Exiting :: AdminUserController ::changeUserStatus method ");
			return modelAndView;
		}
		
	 @RequestMapping(value = CHATAK_ADMIN_USER_DELETE, method = RequestMethod.POST)
		public ModelAndView deleteUser(HttpServletRequest request,
													Map model, 
													HttpServletResponse response,HttpSession session,
													@FormParam("deleteUserId") final String deleteUserId) {
			ModelAndView modelAndView = new ModelAndView(SHOW_USER_MANAGEMENT_SEARCH);
			modelAndView.addObject(Constant.ERROR, null);
			modelAndView.addObject(Constant.SUCCESS, null);
			logger.info("Entering :: UserRoleController ::deleteUser method ");
			String existingFeature = (String) session.getAttribute(Constant.EXISTING_FEATURES);
			if (!existingFeature.contains(FeatureConstants.CHATAK_USER_DELETE_FEATURE_ID)) {
				session.invalidate();
				modelAndView.setViewName(CHATAK_INVALID_ACCESS);
				return modelAndView;
			}
			try {
				Response response2 = userService.deleteUser(Long.valueOf(deleteUserId));
				modelAndView = showAdminUserSearch(request, response, model, session);
				if (response2 != null && response2.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS))
					modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("chatak.user.status.delete.success.message"));
				else {
					modelAndView.addObject(Constant.ERROR, Properties.getProperty(response2.getResponseCode()));
				}
			} catch (Exception e) {
				logger.error("Error :: AdminUserController ::deleteUser method ", e);
				modelAndView.setViewName(INVALID_PAGE);
			}
			logger.info("Exiting :: AdminUserController ::deleteUser method ");
			return modelAndView;
		}
}
