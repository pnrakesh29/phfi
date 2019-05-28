package com.smh.constants;

import com.smh.util.Properties;


public interface PHFIWebConstant {

	public static final String ERROR = "error";

	public static final String SUCCESS = "success";

	public static final String SUCCESS_CODE = "0000";

	public static final String ERROR_CODE = "9999";
	
	public static final String EXISTING_FEATURE_LIST = "existingFeatureList";
	
	public static final String EXISTING_FEATURES = "existingFeatures";

	public static final String ENTITY_LIST_SESSION_NAME = "ENTITY-LIST";

	public static final String ENTITY_PAGES_SESSION_NAME = "entityPages";
	
	public static final String LOGIN_RESPONSE_DATA = "loginResponse";
	
	public static final String ROLE_REQUEST_LIST_EXPORTDATA="roleRequestListForExport";
	
	public static final String LOCATION_REQUEST_LIST_EXPORTDATA="locationRequestListForExport";

	public static final String MODEL_ATTRIBUTE_ENTITY_LIST_PAGE_NUMBER = "entityListPageNumber";

	public static final String MODEL_ATTRIBUTE_ENTITY_LIST_BEGIN_PAGE_NUM = "beginEntityPage";

	public static final String MODEL_ATTRIBUTE_ENTITY_LIST_END_PAGE_NUM = "endEntityPage";

	public static final Integer MAX_ENTITIES_PAGINATION_DISPLAY_SIZE = 10;

	public static final Integer MAX_ENTITY_DISPLAY_SIZE = 10;

	public static final String MODEL_ATTRIBUTE_PORTAL_LIST_PAGE_NUMBER = "portalListPageNumber";

	public static final String MODEL_ATTRIBUTE_PORTAL_LIST_BEGIN_PAGE_NUM = "beginPortalPage";

	public static final String MODEL_ATTRIBUTE_PORTAL_LIST_END_PAGE_NUM = "endPortalPage";

	public static final String PORTAL_PAGES_SESSION_NAME = "portalPages";

	public static final String MODEL_ATTRIBUTE_PORTAL_TOTAL_RECORDS_PAGE_NUM = "totalRecords";

	public static final Integer MAX_ENTITIES_PORTAL_DISPLAY_SIZE = 10;

	public static final Integer ONE = 1;

	public static final Integer TWO = 2;

	public static final Integer THREE = 3;

	public static final Integer FOUR = 4;

	public static final Integer FIVE = 5;

	public static final Integer SIX = 6;

	public static final Integer SEVEN = 7;

	public static final Integer EIGHT = 8;

	public static final Integer NINE = 9;

	public static final String PDF_FILE_FORMAT = "PDF";

	public static final String XLS_FILE_FORMAT = "XLS";

	public static final String EXPORT_FILE_NAME_DATE_FORMAT = Properties.getProperty("chatak.reportfilename.date.format");

	public static final String EXPORT_HEADER_DATE_FORMAT = Properties.getProperty("chatak.reportdate.format");

	public static final String COUNTRY_LIST = "countryList";

	public static final String STATE_LIST = "stateList";

	public static final String Yes = "yes";

	public static final String Admin = "CHATAK_BEACON_ADMIN";

	public static final String LOING_USER_ID = "loginUserId";

	public static final String No = "no";

	public static final String LOGIN_SESSION_VALIDATE_FLAG = Properties.getProperty("smh.admin.login.session.management");

	public static final String COOKIE_CHATAK_NAME = "CHATAK_ID";

	public static String URL_SPERATOR = "/sp/";

	public static String CHATAK_INVALID_SESSION = "session-invalid";

	public static final String ACTIVE = "Active";

	public static final String SUSPENDED = "Suspended";
	
	public static final String STATUS_CODE_SUCCESS = "CEC_0001";
	
	public static final Boolean ALLOW_RIGHT_CLICK = true;
	
	public static final String USER_ROLE_UPDATE_DATA = "userRoleUpdatData";
	
	public static final String STATUS_ROLE_UPDATE_FAILURE_CODE = "CEC_0003";
	
}
