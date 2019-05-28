/**
 * 
 */
package com.smh.constants;

public interface URLMappingConstants {

	public static final String CHATAK_ADMIN_LOGIN = "login";

	public static final String INVALID_PAGE = "500";

	public static final String CHATAK_ADMIN_AUTHENTICATE = "show-dashboard";

	public static final String CHATAK_ADMIN_LOG_OUT = "logout";

	public static final String CHATAK_REQUEST_PAGE = "badRequestError";

	public static final String CHATAK_ADMIN_HOME = "home";

	public static final String CHATAK_ADMIN_DASHBOARD = "dashboard";

	public static final String INVALID_ACCESS_PAGE = "access-invalid";

	public static final String CHATAK_ADMIN_USER_NAME = "chatakAdmin";

	public static String CHATAK_INVALID_ACCESS = "invalid-access";

	public static String CHATAK_INVALID_SESSION = "session-invalid";

	public static final String BEACON_FORGOT_PASSWORD = "beacon-forgot-password";

	public static final String CHATAK_BEACON_FORGOT_PASSWORD = "beacon-forgot-password";

	public static final String PROCESS_BEACON_FORGOT_PASSWORD = "forgotPassword";

	public static final String BEACON_SECURITY_QUESTION = "securityQuestion";

	public static final String BEACON_CHANGE_PASSWORD = "beacon-change-password";

	public static final String CHATAK_BEACON_CHANGE_PASSWORD = "beacon-change-password";

	public static final String PROCESS_BEACON_CHANGE_PASSWORD = "proccess-change-password";

	public static String CHATAK_ADMIN_USER_PROFILE = "my-profile";

	public static String PROCESS_CHATAK_ADMIN_USER_PROFILE_EDIT = "process-chatak-admin-user-profile-edit";

	public static String CHATAK_ADMIN_USER_PROFILE_CHANGE_PASSWORD = "my-profile-changepassword";

	public static String PROCESS_USER_PROFILE_CHANGE_PASSWORD = "process-user-profile-change-password";

	public static final String CHATAK_ADMIN_GET_STATES_BY_COUNTRY = "getStatesByCountry";

	

	
	/* User Management Starts */
	public static final String SHOW_USER_MANAGEMENT_CREATE = "user-mgmt-create";

	public static final String SHOW_USER_MANAGEMENT_SEARCH = "user-mgmt-search";
	
	public static final String PROCESS_BEACON_USER_MANAGEMENT_CREATE = "process-user-mgmt-create";
	
	public static final String PROCESS_BEACON_USER_MANAGEMENT_SEARCH = "process-user-search";
	
	public static final String SHOW_USER_MANAGEMENT_EDIT = "user-mgmt-edit";
	
	public static final String PROCESS_BEACON_ADMIN_USER_MANAGEMENT_EDIT = "process-user-mgmt-edit";
	
	public static final String FETCH_CHATAK_ADMIN_USER_DETAILS = "doAjaxFetchRoles";
	
	public static final String CHATAK_ADMIN_USER_STATUS_CHANGE = "update-user-status";
	
	public static final String CHATAK_ADMIN_USER_DELETE = "process-admin-user-delete";
	
	public static final String CHATAK_ADMIN_ADMIN_USER_PAGINATION = "admin-user-pagination";
	
	public static final String CHATAK_ADMIN_ADMIN_USER_REPORT = "admin-user-report";
	/* User Management Ends */

	public static final String PROCESS_CHATAK_BEACON_zone_MAP = "process-beacon-zone-map";
	/* Role Management start */
	public static final String SHOW_CHATAK_ADMIN_ROLE_CREATE = "access-role-create-page";

	public static final String PROCCESS_CHATAK_ADMIN_ROLE_CREATE = "proccess-access-role-create";

	public static final String CHATAK_ADMIN_ROLE_CREATE = "access-role-create";

	public static final String SHOW_CHATAK_ADMIN_ROLE_EDIT = "access-role-edit-page";

	public static final String CHATAK_ADMIN_ROLE_EDIT = "access-role-edit";

	public static final String PROCCESS_CHATAK_ADMIN_ROLE_EDIT = "proccess-access-role-edit-page";

	public static final String SHOW_CHATAK_ADMIN_ROLE_SEARCH = "access-role-search-page";
	/*
	 * public static final String SHOW_CHATAK_ADMIN_ROLE_SEARCH =
	 * "chatak-display-roles";
	 */

	public static final String PROCCESS_CHATAK_ADMIN_ROLE_SEARCH = "proccess-access-role-search-page";

	public static final String CHATAK_ADMIN_ROLE_SEARCH = "access-role-search";

	public static final String CHATAK_ADMIN_ROLE_CATEGORY = "getRoleCategory";

	public static final String ROLE_ACTIVATION = "roleActivation";

	public static final String CHATAK_ADMIN_ROLE_DELETE = "process-admin-role-delete";
	
	public static final String CHATAK_ROLE_PAGINATION = "getRolesPages";
	
	public static final String CHATAK_ADMIN_UPDATE_ROLE_DATA = "chatakUpdateRole";
	
	public static final String DELETE_ROLE = "deleteRole";
	
	public static final String DOWNLOAD_ROLE_REPORT = "downloadRoleReport";

	/* Role Management end */

/*Passwords start*/
	
	public static final String ADMIN_FORGOT_PASSWORD = "adminForgotPassword";
	
	public static final String BEACON_ADMIN_FORGOT_PASSWORD = "admin-forgot-password";
	
	public static final String SECURITY_QUESTION = "getSecurityQuestion";
	
	public static final String ADMIN_CHANGE_PASSWORD = "adminChangePassword";
	
	public static final String PROCESS_CHANGE_PASSWORD = "processChangePassword";
	
	public static final String PROCESS_FORGOT_PASSWORD = "processForgotPassword";
	
	public static final String BEACON_ADMIN_CHANGE_PASSWORD = "admin-change-password";
	
	public static final String ADMIN_RESET_PASSWORD = "adminResetPassword";
	
	public static final String BEACON_ADMIN_RESET_PASSWORD = "admin-reset-password";
	
	public static final String PROCESS_RESET_PASSWORD = "processResetPassword";
	
	
	/*Passwords End*/
	
	
	//for registration
	public static final String DEMO_REG = "demoReg";
	
	public static final String SHOW_PHFI_REG = "show-phfi-registration-form";
	
	public static final String PHFI_REG = "phfi-registration-form";
	
	public static final String PROCESS_PHFI_REG ="process-phfi-registration-form";
	
	public static final String SHOW_PHFI_REG_SEARCH = "show-phfi-registration-search";
	
	public static final String PHFI_REG_SEARCH = "phfi-registration-search";
	
	public static final String PROCESS_PHFI_REG_SEARCH = "process-phfi-registration-search";
		
	public static final String SHOW_PHFI_VISI_FORM ="show-phfi-visit-form";
	
	public static final String PHFI_VISI_FORM ="phfiVisitForm";
	
	public static final String PROCESS_PREGNANCY_VISIT = "process-pregnancy-visit";
	
	public static final String SHOW_PHFI_POSTPARTUM_VISI_FORM ="show-phfi-postpartum-visit-form";
	
	public static final String PHFI_POSTPARTUM_VISI_FORM ="phfipostpartumVisitForm";
	
	public static final String PROCESS_POSTPARTUM_VISIT = "process-postpartum-visit-form";
	
	public static final String SHOW_PHFI_DELIVERY_VISI_FORM ="show-phfi-delivery-visit-form";
	
	public static final String PHFI_DELIVERY_VISI_FORM ="phfiDeliveryForm";
	
	public static final String PROCESS_DELIVERY_VISIT = "process-delivery-visit-form";
	
	//for dashboard

	public static final String SHOW_INPUT_FIRST_LAYOUT ="dashboard-sec-page";
	
	public static final String INPUT_FIRST_LAYOUT ="dashboardsec";
	
	public static final String SHOW_REPORT_FIRST_LAYOUT ="dashboard-report-page";
	
	public static final String REPORT_FIRST_LAYOUT ="dashboardReport";
	
	public static final String SHOW_ASHA_NEXT_LAYOUT ="dashboard-Asha-Next-page";
	
	public static final String ASHA_NEXT_LAYOUT ="dashboardAshaNext";
	
	public static final String SHOW_DOCTOR_NEXT_LAYOUT ="dashboard-Doctor-Next-page";
	
	public static final String DOCTOR_NEXT_LAYOUT ="dashboardDoctorNext";
	
	public static final String SHOW_ADD_VISIT_NEXT_LAYOUT ="dashboard-addVisit-Next-page";
	
	public static final String ADD_VISIT_NEXT_LAYOUT ="dashboardAddVisitNext";
	
	//for report
	
	public static final String GET_MASTER_REPORT ="get-master-reports";

	public static final String SHOW_MASTER_REPORT = "phfiMasterReport";
	
	public static final String GET_DOCTOR_RATIFIED_REPORT ="get-doctor-ratified-reports";

	public static final String SHOW_DOCTOR_RATIFIED_REPORT = "phfiDoctorRatifiedReport";
	
	public static final String GET_ASHA_FEEDBACK_REPORT ="get-asha-feedback-reports";

	public static final String SHOW_ASHA_FEEDBACK_REPORT = "phfiAshaFeedbackReport";
	
	public static final String SHOW_MEDICAL_CASE_SHEET ="show-medical-case-sheet";
	
	public static final String MEDICAL_CASE_SHEET ="phfiMedicalCaseSheet";
	
	public static final String SHOW_PHFI_DOCTOR_FORM ="show-doctor-form";
	
	public static final String PHFI_DOCTOR_FORM ="phfiDoctorForm";
	
	public static final String GET_REGISTRATION_MASTER_RAW_DATA="getMasterRawData";
	
	public static final String MASTER_RAW_DATA_DASHBOARD ="phfi-master-raw-data";
	
	public static final String GET_MASTER_RAW_DATA_DASHBOARD = "phfi-raw-data-dashboard";
	
	public static final String GET_POSTPARTUM_MASTER_RAW_DATA ="phfi-postpartum-master-raw-data";
	
	public static final String GET_DELIVERY_MASTER_RAW_DATA ="phfi-delivery-master-raw-data";
	
	public static final String GET_PREGANANCY_MASTER_RAW_DATA ="phfi-pregnancy-master-raw-data";
	
	public static final String PROCESS_DOCTOR_VISIT_FORM = "process-doctor-visit-form";
	
}
