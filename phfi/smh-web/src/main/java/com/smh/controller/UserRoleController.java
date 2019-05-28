package com.smh.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.PHFIWebConstant;
import com.smh.constants.Constant;
import com.smh.constants.FeatureConstants;
import com.smh.constants.URLMappingConstants;
import com.smh.enums.RoleLevel;
import com.smh.exception.SmhAdminException;
import com.smh.model.AddRoleResponse;
import com.smh.model.PHFIFeatureRequest;
import com.smh.model.EditRoleResponse;
import com.smh.model.LoginResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleEntityMapRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;
import com.smh.service.RoleService;
import com.smh.util.PaginationUtil;
import com.smh.util.Properties;
import com.smh.util.RoleListFileExportUtil;
import com.smh.util.StringUtil;


@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserRoleController extends BaseController implements URLMappingConstants{

	private static Logger logger = Logger.getLogger(UserRoleController.class);
	 
	@Autowired
	private RoleService roleService;


		  @RequestMapping(value = SHOW_CHATAK_ADMIN_ROLE_CREATE, method = RequestMethod.GET)
			public ModelAndView showCreateRole(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model, HttpSession session) {
				
				logger.info("Entering:: UserRoleController:: showRole method");
			    ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_ROLE_CREATE);
			    /*String existingFeature = (String) session.getAttribute(BeaconWebConstant.EXISTING_FEATURE_LIST);*/
			   /* 
			    if(!existingFeature.contains(FeatureConstants.CHATAK_ROLE_CREATE_FEATURE_ID)) {
			      session.invalidate();
			      modelAndView.setViewName(INVALID_ACCESS_PAGE);
			      return modelAndView;
			    }*/
			    
			    try {
			    	LoginResponse loginResponse = (LoginResponse) session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);
			    	UserRoleRequest userRoleRequest = new UserRoleRequest();
			    	// get Role Level List Based on login user type
			    	List<RoleLevel> getAllTypeRoleLogin=new ArrayList<RoleLevel>();
			    	List<RoleLevel> rolesList=Arrays.asList(RoleLevel.values());
			    	getAllTypeRoleLogin=getRoleListForRoles(rolesList, session, getAllTypeRoleLogin);
			    	model.put("roleLevelList", getAllTypeRoleLogin);
			    	model.put("userRoleRequest", userRoleRequest);
			    	RoleLevelFeatureRequest roleLevelFeatureRequest = new RoleLevelFeatureRequest();
			    	roleLevelFeatureRequest.setRoleLevel(RoleLevel.valueOf(loginResponse.getUserType()));
			    			
			    	RoleFeatureResponse roleFeatureResponse = roleService.getFeatureOnRoleLevel(roleLevelFeatureRequest);
			    	List<PHFIFeatureRequest> featureList = roleFeatureResponse.getFeatureList();
			    	List<PHFIFeatureRequest> featureTempList = new ArrayList<PHFIFeatureRequest>();
			    	List<Long> featureIdList = new ArrayList<Long>();
			    	String adminRelatedFeatureIds = null;
			    	if(loginResponse.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name())){
			    		adminRelatedFeatureIds = Properties.getProperty("chatak.service.admin.related.feature.id");
			    	}
			    	
			    	StringTokenizer st = new StringTokenizer(adminRelatedFeatureIds, ",");
		    		while(st.hasMoreElements()){
		    			featureIdList.add(Long.valueOf(st.nextElement().toString()));
		    		}	
		    		
		    		if(StringUtil.isListNotNullNEmpty(featureList)){
		    			for(PHFIFeatureRequest feature : featureList){
		    				if(featureIdList.contains(feature.getFeatureId())){
		    					featureTempList.add(feature);
		    				}
		    			}
		    		}
		    		modelAndView.addObject("featureList", featureTempList);
			    } catch(Exception e) {
			    	logger.info("ERROR:: UserRoleController:: showRole method",e);
			    }
			    logger.info("Exiting:: UserRoleController:: showRole method");
			    return modelAndView;
			}
		  

		  private List<RoleLevel>	getRoleListForRoles(List<RoleLevel> roleLevelList, HttpSession session, List<RoleLevel> roleLevels){
			LoginResponse loginResponse=(LoginResponse)session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);
			  
				if(loginResponse.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name())){
					roleLevels = Arrays.asList(RoleLevel.SYSTEM);
				}
				return roleLevels;
			}
		  @RequestMapping(value = PROCCESS_CHATAK_ADMIN_ROLE_CREATE, method = RequestMethod.POST)
			public ModelAndView processCreateRole(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model, HttpSession session,
					UserRoleRequest userRoleRequest) {
				logger.info("Entering:: UserRoleController:: addRole method");
				ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
				AddRoleResponse addRoleResponse = new AddRoleResponse();
				try {
					
					LoginResponse loginResponse = (LoginResponse) session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);

					if (null == loginResponse) {
						addRoleResponse.setStatus(false);
						addRoleResponse.setMessage(Properties.getProperty("prepaid.user.session.expiry.message"));
					}
					userRoleRequest.setCreatedBy(session.getAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME).toString());
					UserRoleEntityMapRequest userRoleEntityMapRequest = new UserRoleEntityMapRequest();
					if(loginResponse.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name())){
						userRoleRequest.setRoleType(RoleLevel.SYSTEM);
					}
					userRoleRequest.setUserRoleEntityMapRequest(userRoleEntityMapRequest);
					String permissionData = request.getParameter("permission");
					userRoleRequest.setFeature(StringUtil.converArray(permissionData));
					
					Response roleServiceResponse = roleService.createOrUpdateRole( userRoleRequest);
					if (roleServiceResponse != null && PhfiErrorCodes.PHFI_SUCCESS.equals(roleServiceResponse.getResponseCode())) {
						addRoleResponse.setStatus(true);
						String sucessMessage = Properties.getProperty("chatak.new.role.success.message");
						model.put(PHFIWebConstant.SUCCESS, sucessMessage);
						modelAndView = showSearchRole(request, response, model, session);
					} else if (roleServiceResponse != null && !PHFIWebConstant.STATUS_CODE_SUCCESS.equals(roleServiceResponse.getResponseCode())) {
						modelAndView = showCreateRole(request, response, model, session);
					//	String errorMessage = Properties.getProperty(roleServiceResponse.getErrorCode());
						model.put(PHFIWebConstant.ERROR, roleServiceResponse.getResponseMessage());
					} else {
						modelAndView = showCreateRole(request, response, model, session);
						modelAndView.addObject(PHFIWebConstant.ERROR, roleServiceResponse.getResponseMessage());
					}
				} catch (Exception e) {
					logger.error("ERROR:: UserRoleController:: addRole method", e);
					addRoleResponse.setStatus(false);
					addRoleResponse.setMessage(Properties.getProperty("prepaid.service.call.role.error.message"));
				}
				logger.info("Exiting:: UserRoleController:: addRole method");
				return modelAndView;
			}
		  @RequestMapping(value = SHOW_CHATAK_ADMIN_ROLE_SEARCH, method = RequestMethod.GET)
			public ModelAndView showSearchRole(HttpServletRequest request, HttpServletResponse response,  Map model, HttpSession session) {
				logger.info("Entering:: UserRoleController:: showSearchRole method");

				ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
			    
				String existingFeature = (String) session.getAttribute(PHFIWebConstant.EXISTING_FEATURES);
				if(!existingFeature.contains(FeatureConstants.CHATAK_ROLE_FEATURE_ID)) {
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
					UserRoleRequest userRoleRequest = new UserRoleRequest();
					session.removeAttribute(PHFIWebConstant.ROLE_REQUEST_LIST_EXPORTDATA);
					model.put("userRoleRequest", userRoleRequest);
					model.put("roleList", PHFIWebConstant.Yes);
				} catch(Exception e) {
					logger.error("ERROR:: UserRoleController:: searchRole method", e);
					model.put(PHFIWebConstant.ERROR, Properties.getProperty("chatak.genral.error"));
				}
				logger.info("Exiting:: UserRoleController:: searchRole method");
				return modelAndView;
			}
		  
		  @RequestMapping(value = PROCCESS_CHATAK_ADMIN_ROLE_SEARCH, method = RequestMethod.POST)
			public ModelAndView processSearchRole(UserRoleRequest userRoleRequest,
			                                     HttpServletRequest request,
			                                     HttpServletResponse response,
			                                     Map<String, Serializable> model,
			                                     HttpSession session) {
				logger.info("Entering:: UserRoleController:: processSearchRole method");
				
				ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
				String existingFeature = (String) session.getAttribute(PHFIWebConstant.EXISTING_FEATURES);
				
				if(!existingFeature.contains(FeatureConstants.CHATAK_ROLE_FEATURE_ID)) {
					session.invalidate();
					modelAndView.setViewName(CHATAK_INVALID_ACCESS);
					return modelAndView;
				}
			    try {
			    	LoginResponse loginResponse = (LoginResponse) session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);
			    	
			    	userRoleRequest.setCreatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
			    	userRoleRequest.setPageIndex(Constant.ONE);
					userRoleRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			    	if(userRoleRequest.getRecordPerPage() != null){
			    		userRoleRequest.setPageSize(userRoleRequest.getRecordPerPage());
					  }
					else {
						userRoleRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
					}
					session.setAttribute(PHFIWebConstant.ROLE_REQUEST_LIST_EXPORTDATA, userRoleRequest);
					model.put("userRoleRequest", userRoleRequest);
					List<UserRoleRequest> roleList=null; 
				  
					if(RoleLevel.SYSTEM.name().equalsIgnoreCase(loginResponse.getUserType())){
						userRoleRequest.setEntityId(loginResponse.getEntityId());
					}
					
					UserRoleResponse userRoleResponse=searchRoleBasedOnRoleCategory(loginResponse,session, modelAndView, userRoleRequest, roleList);
					if(StringUtil.isListNotNullNEmpty(userRoleResponse.getUserRoleRequests())){
						modelAndView=PaginationUtil.getPagenationModel(modelAndView, userRoleResponse.getNoOfRecords());
						modelAndView.addObject("roleList", userRoleResponse.getUserRoleRequests());
						model.put("totalCount",  userRoleResponse.getNoOfRecords());
					}else {
						modelAndView.addObject("roleList",new ArrayList<UserRoleRequest>());
					}
				  List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
			      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
			      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
				  if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					  modelAndView.addObject("roleLevelList", roleLevelsForAllRoles);
				  }
			    }
			    catch(SmhAdminException e) {
			      logger.error("ERROR:: UserRoleController:: processSearchRole method", e);
			      if(e instanceof SmhAdminException) {
			        //return PaginationUtil.showInactivePage(request, session, response);
			      }
			      model.put(PHFIWebConstant.ERROR, e.getMessage());
			    }
			    catch(Exception e) {
			      logger.error("ERROR:: UserRoleController:: processSearchRole method", e);
			      model.put(PHFIWebConstant.ERROR, Properties.getProperty("stylo.genral.error"));
			    }
			    model.put("userRoleRequest", userRoleRequest);
			    model.put("resultflag", true);
			    logger.info("Exiting:: UserRoleController:: processSearchRole method");
			    return modelAndView;
			  }
		  private  UserRoleResponse searchRoleBasedOnRoleCategory(LoginResponse loginResponse,HttpSession session,ModelAndView modelAndView,UserRoleRequest userRoleRequest, List<UserRoleRequest> roleList) throws SmhAdminException{
				UserRoleResponse userRoleResponse=null;
				if (loginResponse.getUserType().toString().equals(RoleLevel.SYSTEM.toString())) {
			  		userRoleRequest.setRoleTypeList((Arrays.asList(RoleLevel.SYSTEM.name())));
			  		if(!StringUtil.isNullAndEmpty(userRoleRequest.getRoleCategory())){
			  			userRoleRequest.setRoleTypeList(Arrays.asList(userRoleRequest.getRoleCategory()));
		            }
			  		//setAuditData(userRoleRequest, session, AuditSection.Roles.name(), AuditEvent.Search.name());
			  		userRoleResponse = roleService.searchRole(userRoleRequest);
				 }
				
				return userRoleResponse;
			}
		 /* @RequestMapping(value = CHATAK_ADMIN_ROLE_CATEGORY, method = RequestMethod.POST)
		  public ModelAndView roleCategoryByType(HttpServletRequest request,HttpServletResponse response,
				  UserRoleRequest userRoleRequest , @FormParam("roleCategory") final String roleCategory,
		          Map model, HttpSession session) {
		    logger.info("Entering:: UserRoleController:: roleCategory method");
		    ModelAndView modelAndView = new ModelAndView(STYLOPAY_ADMIN_ROLE_CREATE);
		   
		    String existingFeature = (String) session.getAttribute(BeaconWebConstant.EXISTING_FEATURES);
		    if(!existingFeature.contains(FeatureConstants.PREPAID_ROLE_CREATE_FEATURE)) {
		      session.invalidate();
		      modelAndView.setViewName(STYLOPAY_INVALID_ACCESS);
		      return modelAndView;
		    }
		    try {
		    	 List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
			      List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
			      roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
				  if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
						model.put("roleLevelList", roleLevelsForAllRoles);
				 }
				model.put("roleCategory", roleCategory);
				 RoleLevelFeatureRequest roleLevelFeatureRequest = new RoleLevelFeatureRequest();
			     roleLevelFeatureRequest.setRoleLevel(RoleLevel.valueOf(RoleLevel.SYSTEM.name()));
			     
			     RoleFeatureResponse roleFeatureResponse = roleService.getFeatureOnRoleLevel(roleLevelFeatureRequest);
			     
				List<StylopayFeatureRequest> featureList = roleFeatureResponse.getFeatureList();
		    	List<StylopayFeatureRequest> featureTempList = new ArrayList<StylopayFeatureRequest>();
		    	List<Long> featureIdList = new ArrayList<Long>();
		    	String adminRelatedFeatureIds = null;
		    	
		    	if(roleCategory.equalsIgnoreCase(RoleLevel.SYSTEM.name())){
		    		adminRelatedFeatureIds = Properties.getProperty("stylopay.service.admin.related.feature.id");
		    	}else if(roleCategory.equalsIgnoreCase(RoleLevel.TOKEN.name())){
		    		adminRelatedFeatureIds = Properties.getProperty("stylopay.service.tokenization.related.feature.id");
		    	}else if (roleCategory.equalsIgnoreCase(RoleLevel.HCE.name())) {
		    		adminRelatedFeatureIds = Properties.getProperty("stylopay.service.hce.related.feature.id");
		    	}else if (roleCategory.equalsIgnoreCase(RoleLevel.SPTSM.name())) {
		    		adminRelatedFeatureIds = Properties.getProperty("stylopay.service.sptsm.related.feature.id");
		    	}
		    	
		    	StringTokenizer st = new StringTokenizer(adminRelatedFeatureIds, ",");
	    		while(st.hasMoreElements()){
	    			featureIdList.add(Long.valueOf(st.nextElement().toString()));
	    		}	
	    		
	    		if(StringUtil.isListNotNullNEmpty(featureList)){
	    			for(StylopayFeatureRequest feature : featureList){
	    				if(featureIdList.contains(feature.getFeatureId())){
	    					featureTempList.add(feature);
	    				}
	    			}
	    		}
	    		modelAndView.addObject("featureList", featureTempList);
		        
		    }
		    catch(Exception e) {
		    	 logger.info("ERROR:: UserRoleController:: roleCategory method",e);
		    }
		    logger.info("Exiting:: UserRoleController:: roleCategory method");
		    return modelAndView;
		  }*/
		  
		  
		  @RequestMapping(value = CHATAK_ADMIN_ROLE_EDIT, method = RequestMethod.POST)
		  public ModelAndView showEditRole(HttpSession session, UserRoleRequest userRoleRequest, BindingResult bindingResult, Map<String, Object> model) {
		    logger.info("Entering:: UserRoleController:: editRole method");
		    ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_EDIT);
		    String existingFeature = (String) session.getAttribute(PHFIWebConstant.EXISTING_FEATURES);
		    if(!existingFeature.contains(FeatureConstants.CHATAK_ROLE_EDIT_FEATURE_ID)) {
		      session.invalidate();
		      modelAndView.setViewName(CHATAK_INVALID_ACCESS);
		      return modelAndView;
		    }
		    try {
		      userRoleRequest.setCreatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
		      EditRoleResponse editRoleResponseData = roleService.getRoleDetails(userRoleRequest);
		      session.setAttribute("editRoleResponseData", editRoleResponseData);
		     
		      List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
			  if(StringUtil.isListNotNullNEmpty(roleLevelList)){
					for (int i = 0; i < roleLevelList.size(); i++) {
	                  if(roleLevelList.get(i).name().toString().equalsIgnoreCase(editRoleResponseData.getRoleRequest().getRoleType().name().toString())){
							model.put("roleLevelList", roleLevelList);
						}
					}	
			  }
		      model.put("roleId", editRoleResponseData.getRoleRequest().getRoleId().toString());
		      userRoleRequest.setRoleName(editRoleResponseData.getRoleRequest().getRoleName());
		      userRoleRequest.setDescription(editRoleResponseData.getRoleRequest().getDescription());
		      userRoleRequest.setMakerChecker(editRoleResponseData.getRoleRequest().getMakerCheckerRequired());
		      userRoleRequest.setRoleCategory(editRoleResponseData.getRoleRequest().getRoleType().getValue());
		      model.put("userRoleRequest", userRoleRequest);
		      session.setAttribute(PHFIWebConstant.USER_ROLE_UPDATE_DATA, editRoleResponseData.getRoleRequest());
		      if(editRoleResponseData != null) {
			        List<PHFIFeatureRequest> featureList = null;
			        try {
			        	  RoleLevelFeatureRequest roleLevelFeatureRequest = new RoleLevelFeatureRequest();
			    	      roleLevelFeatureRequest.setRoleLevel(RoleLevel.valueOf(editRoleResponseData.getRoleRequest().getRoleType().toString()));
			    	      RoleFeatureResponse roleFeatureResponse = roleService.getFeatureOnRoleLevel(roleLevelFeatureRequest);
			    	      featureList = roleFeatureResponse.getFeatureList();
			          if(editRoleResponseData.getRoleRequest().getRoleType().name().toString().equals(RoleLevel.SYSTEM.toString())){
						List<PHFIFeatureRequest> featureTempList = new ArrayList<PHFIFeatureRequest>();
				        String bankRelatedFeatureIds = Properties.getProperty("chatak.service.admin.related.feature.id");
				        List<Long> bankRelatedFeatureIdList = new ArrayList<Long>();
				        StringTokenizer st = new StringTokenizer(bankRelatedFeatureIds, ",");
				        while(st.hasMoreElements()){
				        	bankRelatedFeatureIdList.add(Long.valueOf(st.nextElement().toString()));
				        }	
				        	
				        if(StringUtil.isListNotNullNEmpty(featureList)){
				        	for(PHFIFeatureRequest feature : featureList){
				        	    if(bankRelatedFeatureIdList.contains(feature.getFeatureId())){
				        			featureTempList.add(feature);
				        		}
				        	  }
				        	}
				        modelAndView.addObject("featureList", featureTempList);
					  } else {
						modelAndView.addObject("featureList", featureList); 
					  }
			        }
		        catch(Exception e) {
		            e.printStackTrace();
		        }
		        for(PHFIFeatureRequest feature : featureList) {
		            feature.setRoleFeatureId("|" + feature.getFeatureId().toString() + "|");
		        }
		            model.put("featureList", featureList);
		            String roleExistingFeatures = "";
		        for(Long feature : editRoleResponseData.getExistingFeature()) {
		           roleExistingFeatures += "|" + feature;
		        }
		           roleExistingFeatures += "|"; session.setAttribute("roleExistingFeatures", roleExistingFeatures);

		           /*model.put("editPermissionData", GenerateRoleHtml.generateEditFeatueHtml(editRoleResponseData.getFeatureMap(),
		                                            editRoleResponseData.getExistingFeature()));*/
		           model.put("userRoleRequest", userRoleRequest);

		           session.setAttribute(PHFIWebConstant.EXISTING_FEATURE_LIST, editRoleResponseData.getExistingFeature());
		      }
		    }
		    catch(Exception e) {
		      logger.error("ERROR:: UserRoleController:: editRole method", e);
		      model.put(PHFIWebConstant.ERROR, "Unable to process your request");
		    }
		    logger.info("Exiting:: UserRoleController:: editRole method");
		    return modelAndView;
		  }
		  
		  @RequestMapping(value =CHATAK_ADMIN_UPDATE_ROLE_DATA, method = RequestMethod.POST)
		  public ModelAndView updateRole(HttpServletRequest request, Map<String, Object> model, UserRoleRequest userRoleRequest, BindingResult bindingResult, HttpSession session, HttpServletResponse response) {

		    logger.info("Entering:: UserRoleController:: updateRole method");
		    ModelAndView modelAndView=new ModelAndView( SHOW_CHATAK_ADMIN_ROLE_SEARCH);
		    
		    AddRoleResponse addRoleResponse = new AddRoleResponse();
            Response updateResponse=new Response();
		      try {
		        LoginResponse loginResponse = (LoginResponse) session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);

		        if(null == loginResponse) {
		          addRoleResponse.setStatus(false);
		          addRoleResponse.setMessage(Properties.getProperty("chatak.user.session.expiry.message"));
		        } 
		          String permissionData = request.getParameter("permissions");
		          UserRoleRequest userRoleRequest2=(UserRoleRequest)session.getAttribute(PHFIWebConstant.USER_ROLE_UPDATE_DATA);
		          userRoleRequest.setRoleCategory(userRoleRequest2.getRoleType().name());
		          if(!StringUtil.isNullAndEmpty(userRoleRequest2.getReason())){
		        	  userRoleRequest.setReason(userRoleRequest2.getReason());  
		          }
		          userRoleRequest.setFeature(StringUtil.converArray(permissionData));
		          userRoleRequest.setCreatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
		          userRoleRequest.setUpdatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
		          //modelAndView=createOrUpdateRoleWithEntityId(userRoleRequest,session, modelAndView, loginResponse);
		          userRoleRequest.setUpdateCheckFlage(PHFIWebConstant.Yes);
		          //setAuditData(userRoleRequest, session, AuditSection.Roles.name(), AuditEvent.Update.name());
		          updateResponse= roleService.createOrUpdateRole(userRoleRequest);
			      if (updateResponse!=null && PhfiErrorCodes.PHFI_SUCCESS.equals(updateResponse.getResponseCode())) {
			      addRoleResponse.setStatus(true);
			      String successMessage=Properties.getProperty("chatak.role.update.success.message");
			      model.put(Constant.SUCCESS, successMessage);
			      modelAndView=showSearchRole(request, response, model, session);
				   } else if (updateResponse!=null && PHFIWebConstant.STATUS_ROLE_UPDATE_FAILURE_CODE.equals(updateResponse.getResponseCode())) {
					   modelAndView=showSearchRole(request, response, model, session);
				       //String errorMessage = Properties.getProperty(updateResponse.getErrorCode());
				       model.put(Constant.ERROR, updateResponse.getResponseMessage());
				  } else {
					  modelAndView=showEditRole(session, userRoleRequest2, bindingResult, model);
					  modelAndView.addObject(Constant.ERROR, updateResponse.getResponseMessage());
				  }
		      }
		      catch(Exception e) {
		        	 logger.error("ERROR:: UserRoleController:: updateRole method", e);
		             addRoleResponse.setStatus(false);
		             addRoleResponse.setMessage(Properties.getProperty("chatak.genral.error"));
		        }
		        logger.info("Exiting:: UserRoleController:: updateRole method");
		        return modelAndView;
		      }
		  
		  /*private ModelAndView createOrUpdateRoleWithEntityId(UserRoleRequest userRoleRequest,HttpSession session ,ModelAndView modelAndView,LoginResponse loginResponse) throws ChatakAdminException {
				if(userRoleRequest.getRoleCategory()!=null && userRoleRequest.getRoleCategory().equals(RoleLevel.SYSTEM.toString())){
					userRoleRequest.setRoleType(RoleLevel.SYSTEM);
				}
				if(userRoleRequest.getRoleCategory()!=null &&  userRoleRequest.getRoleCategory().equals(RoleLevel.TOKEN.name())){
					  userRoleRequest.setRoleType(RoleLevel.TOKEN);
					  BankResponse bankResponse = bankService.searchSystemBank(new BankRequest());
					  if(bankResponse!=null){
						  userRoleRequest.setEntityId(bankResponse.getBankRequests().get(0).getBankId());
					  }
				}
				
				if(userRoleRequest.getRoleCategory()!=null && userRoleRequest.getRoleCategory().equals(RoleLevel.HCE.name())){
					userRoleRequest.setRoleType(RoleLevel.HCE);
					if(RoleLevel.CP_SUPER_ADMIN.name().equalsIgnoreCase(loginResponse.getUserType())){
						 ProgramManagerResponse programManagerResponse =programManagerService.searchSystemProgramManager(new ProgramManagerRequest());
						 if(programManagerResponse!=null){
							 if(programManagerResponse.getProgramManagersList().get(0).getProgramManagerName().equals(BeaconWebConstant.SYSTEM_PROGRAM_MANAGER)){
								 userRoleRequest.setEntityId(programManagerResponse.getProgramManagersList().get(0).getId());
							 }
						 }
					}else if(RoleLevel.CP_PROGRAM_MANAGER.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_BANK.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_PARTNER.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_SALESPERSON.name().equalsIgnoreCase(loginResponse.getUserType()) ){
						userRoleRequest.setEntityId(loginResponse.getEntityId());
					}
				}
				if(userRoleRequest.getRoleCategory()!=null && userRoleRequest.getRoleCategory().equalsIgnoreCase(RoleLevel.SPTSM.name())){
					userRoleRequest.setRoleType(RoleLevel.SPTSM);
					if(RoleLevel.CP_SUPER_ADMIN.name().equalsIgnoreCase(loginResponse.getUserType())){
						  PartnerRequest partnerRequest=new PartnerRequest();
						  partnerRequest.setStatusList(Arrays.asList(Status.Active.name()));
						  PartnerResponse partnerResponse=partnerService.getAllPartnersForAdminUser(partnerRequest);
						  if(partnerResponse!=null){
							  if(partnerResponse.getPartnerList().get(0).getPartnerName().equals(BeaconWebConstant.SYSTEM_PARTNER)){
									 userRoleRequest.setEntityId(partnerResponse.getPartnerList().get(0).getPartnerId());
								 }
						}
					}else if(RoleLevel.CP_PROGRAM_MANAGER.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_BANK.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_PARTNER.name().equalsIgnoreCase(loginResponse.getUserType())
							|| RoleLevel.CP_SALESPERSON.name().equalsIgnoreCase(loginResponse.getUserType()) 
							){
						userRoleRequest.setEntityId(loginResponse.getEntityId());
				}
			  }
				if(userRoleRequest.getRoleCategory()!=null && userRoleRequest.getRoleCategory().equalsIgnoreCase(RoleLevel.CP_SALESPERSON.name())){
					  userRoleRequest.setRoleType(RoleLevel.CP_SALESPERSON);
					  if(RoleLevel.CP_SUPER_ADMIN.name().equalsIgnoreCase(loginResponse.getUserType())){
							 SalesAgentDTOResponse salesAgentDTOResponse=manageSalesAgentService.searchSystemSalesAgent(new SalesAgentDTO());
							  if(salesAgentDTOResponse!=null){
								  if(salesAgentDTOResponse.getSalesAgentDTOlist().get(0).getSalesAgentName().equals(BeaconWebConstant.SYSTEM_SALES_PERSON)){
										 userRoleRequest.setEntityId(salesAgentDTOResponse.getSalesAgentDTOlist().get(0).getSalesAgentId());
							 }
						 }
						}else if(RoleLevel.CP_PROGRAM_MANAGER.name().equalsIgnoreCase(loginResponse.getUserType()) 
								|| RoleLevel.CP_BANK.name().equalsIgnoreCase(loginResponse.getUserType()) 
								|| RoleLevel.CP_PARTNER.name().equalsIgnoreCase(loginResponse.getUserType())
								|| RoleLevel.CP_SALESPERSON.name().equalsIgnoreCase(loginResponse.getUserType())
								){
							userRoleRequest.setEntityId(loginResponse.getEntityId());
						}
				}
			   return modelAndView;
			}*/
		  
		  @RequestMapping(value = CHATAK_ROLE_PAGINATION, method = RequestMethod.POST)
		  public ModelAndView getRolePaginationList(final HttpSession session, 
				  @FormParam("pageNumber")final Integer pageNumber,
				  @FormParam("totalRecords") final Integer totalRecords,
				  Map<String, UserRoleRequest> model) {
		    logger.info("Entering:: UserRoleController:: getRolePaginationList method");

		    ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
		    try {
		    	LoginResponse loginResponse = (LoginResponse) session.getAttribute(PHFIWebConstant.LOGIN_RESPONSE_DATA);
		    	List<RoleLevel> roleLevelList = Arrays.asList(RoleLevel.values());
			    List<RoleLevel> roleLevelsForAllRoles=new ArrayList<RoleLevel>();
			    roleLevelsForAllRoles=getRoleListForRoles(roleLevelList,session,roleLevelsForAllRoles);
				if(StringUtil.isListNotNullNEmpty(roleLevelsForAllRoles)){
					modelAndView.addObject("roleLevelList", roleLevelsForAllRoles);
				}
				UserRoleRequest userRoleRequest = new UserRoleRequest();
		    	if (loginResponse.getUserType().toString().equals(RoleLevel.SYSTEM.toString())) {
		    		userRoleRequest.setRoleTypeList((Arrays.asList(RoleLevel.SYSTEM.toString())));
		    	} 
		    	userRoleRequest = (UserRoleRequest) session.getAttribute(PHFIWebConstant.ROLE_REQUEST_LIST_EXPORTDATA);
		    	userRoleRequest.setCreatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
		        userRoleRequest.setPageIndex(pageNumber);
		        userRoleRequest.setNoOfRecords(totalRecords);
		    	UserRoleResponse searchRoleResponse = roleService.searchRole(userRoleRequest);
		        List<UserRoleRequest> roleList =searchRoleResponse.getUserRoleRequests();
		        if (StringUtil.isListNotNullNEmpty(roleList))	{
					modelAndView=PaginationUtil.getPagenationModelSuccessive(modelAndView, pageNumber, totalRecords);
					model.put("userRoleRequest", userRoleRequest);
					modelAndView.addObject("roleList", roleList);
					modelAndView.addObject("totalCount", searchRoleResponse.getNoOfRecords());
				}
			}
		    catch(Exception e) {
		      logger.error("ERROR:: UserRoleController:: getRolePaginationList method", e);
		      modelAndView.addObject(Constant.ERROR, Properties.getProperty("chatak.genral.error"));
		    }
		    logger.info("Exiting:: UserRoleController:: getRolePaginationList method");
		    modelAndView.addObject("resultflag", true);
		    return modelAndView;
		  }
		  
		 /**
			 * Method used to download Role Report
			 * 
			 * @param session
			 * @param request
			 * @param response
			 * @param model
			 * @return
			 */
		  @RequestMapping(value = DOWNLOAD_ROLE_REPORT, method = RequestMethod.POST)
			public ModelAndView downloadRoleReport(HttpSession session, Map model,
					@FormParam("downLoadPageNumber") final Integer downLoadPageNumber,
					@FormParam("downloadType") final String downloadType,
					HttpServletRequest request, HttpServletResponse response) {
				logger.info("Entering:: UserRoleController:: downloadRoleReport method");
				try{
					UserRoleRequest userRoleRequest = new UserRoleRequest();
					userRoleRequest = (UserRoleRequest) session.getAttribute(PHFIWebConstant.ROLE_REQUEST_LIST_EXPORTDATA);
					userRoleRequest.setPageIndex(downLoadPageNumber);
					UserRoleResponse searchRoleResponse = roleService.searchRole(userRoleRequest);
					List<UserRoleRequest> roleList =searchRoleResponse.getUserRoleRequests();
						if (StringUtil.isListNotNullNEmpty(roleList)) 
						{
							if (PHFIWebConstant.PDF_FILE_FORMAT.equalsIgnoreCase(downloadType)) 
							{
								RoleListFileExportUtil.downloadRolePdf(roleList, response);
							} 
							else if (PHFIWebConstant.XLS_FILE_FORMAT.equalsIgnoreCase(downloadType))
							{
								RoleListFileExportUtil.downloadRoleXlS(roleList, response);
							}
						 }
				 } catch (Exception e) {
					logger.error("ERROR:: UserRoleController:: downloadRoleReport method", e);
					ModelAndView modelAndView = new ModelAndView(INVALID_PAGE);
					return modelAndView;
				}
				logger.info("Exiting:: UserRoleController:: downloadRoleReport method");
				return null;
			}
		  
		 /**
		   * Method to Change the Role Status
		   * 
		   * @param session
		   * @param roleActivateId
		   * @param roleStatus
		   * @param model
		   * @return
		   */
		  @RequestMapping(value = ROLE_ACTIVATION, method = RequestMethod.POST)
		  public ModelAndView changeRoleStatus(final HttpSession session, @FormParam("roleActivateId")
		  final Long roleActivateId, @FormParam("roleStatus")
		  final String roleStatus, @FormParam("reason")
		  final String reason, Map<String, Serializable> model, HttpServletRequest request, HttpServletResponse response) {
		    logger.info("Entering:: UserRoleController:: changeRoleStatus method");

		    ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
		    String existingFeature = (String) session.getAttribute(PHFIWebConstant.EXISTING_FEATURES);
			if (roleStatus.equals(Constant.ACTIVE)) {
				if (!existingFeature.contains(FeatureConstants.CHATAK_ROLE_ACTIVATE_FEATURE_ID)) {
					session.invalidate();
					modelAndView.setViewName(CHATAK_REQUEST_PAGE);
					return modelAndView;
	
				} else if (roleStatus.equals(Constant.SUSPEND)) {
					if (!existingFeature.contains(FeatureConstants.CHATAK_ROLE_SUSPEND_FEATURE_ID)) {
						session.invalidate();
						modelAndView.setViewName(CHATAK_REQUEST_PAGE);
						return modelAndView;
	
					}
				}
			}
		    try {
		      UserRoleRequest userRoleRequest = new UserRoleRequest();
		      model.put("userRoleRequest", userRoleRequest);
		      userRoleRequest.setRoleId(roleActivateId.toString());
		      userRoleRequest.setStatus(roleStatus);
		      userRoleRequest.setReason(reason);
		      
		      userRoleRequest.setUpdatedBy(URLMappingConstants.CHATAK_ADMIN_USER_NAME.toString());
		      userRoleRequest.setUpdateCheckFlage(PHFIWebConstant.Yes);
		      Response status = roleService.changeRoleStatus(userRoleRequest);
		      logger.debug("UserRoleController::changeRoleStatus::change Statud Value" + status);
		      if (status!=null && status.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS)) {
		    	  	modelAndView = showSearchRole(request, response, model, session);
					String successData = Properties.getProperty("chatak.role.status.success.message").replace("$$$##", roleStatus.equals(Constant.ACTIVE) ? "Activated" : "Suspended");
					model.put(Constant.SUCCESS, successData);
				} else {
					modelAndView = showSearchRole(request, response, model, session);
					model.put(Constant.ERROR, Properties.getProperty(status.getResponseCode()));
		     
				}
		    }
		    catch(SmhAdminException e) {
		      logger.error("ERROR:: UserRoleController:: changeRoleStatus method", e);
		      model.put(Constant.ERROR, e.getMessage());
		    }
		    catch(Exception e) {
		      logger.error("ERROR:: UserRoleController:: changeRoleStatus method", e);
		      model.put(Constant.ERROR, "Unable to process your request");
		    }
		    logger.info("Exiting:: UserRoleController:: changeRoleStatus method");
		    return modelAndView;
		  }
	
		  
			@RequestMapping(value = DELETE_ROLE, method = RequestMethod.POST)
			public ModelAndView deleteRole(HttpServletRequest request,
														Map model, 
														HttpServletResponse response,HttpSession session,
														@FormParam("roleIdDeleteData") final String roleIdDeleteData) {
				ModelAndView modelAndView = new ModelAndView(SHOW_CHATAK_ADMIN_ROLE_SEARCH);
				modelAndView.addObject(Constant.ERROR, null);
				modelAndView.addObject(Constant.SUCCESS, null);
				logger.info("Entering :: UserRoleController ::deleteRole method ");
				String existingFeature = (String) session.getAttribute(PHFIWebConstant.EXISTING_FEATURES);
				if (!existingFeature.contains(FeatureConstants.CHATAK_ROLE_DELETE_FEATURE_ID)) {
					session.invalidate();
					modelAndView.setViewName(CHATAK_INVALID_ACCESS);
					return modelAndView;
				}
				try {
					Response response2 = roleService.deleteRole(Long.valueOf(roleIdDeleteData));
					modelAndView = showSearchRole(request, response, model, session);
					if (response2 != null && response2.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS))
						modelAndView.addObject(Constant.SUCCESS, Properties.getProperty("chatak.role.delete.success.message"));
					else {
						modelAndView.addObject(Constant.ERROR, Properties.getProperty("chatak.role.delete.failure.message"));
					}
				} catch (Exception e) {
					logger.error("Error :: UserRoleController ::deleteRole method ", e);
					modelAndView.setViewName(INVALID_PAGE);
				}
				logger.info("Exiting :: UserRoleController ::deleteRole method ");
				return modelAndView;
			}
}
