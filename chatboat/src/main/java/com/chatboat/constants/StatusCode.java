package com.chatboat.constants;

public interface StatusCode {

	/**
	 * 
	 * NOTE: Please Define these values in order. Becomes easy to find a status!
	 * 
	 */

	public static final String ERROR_STATUS = "101";
	public static final String MANDATORY_PARAMETER_ERROR_STATUS = "103";
	public static final String USER_LIMIT_STATUS = "104";
	public static final String TOTAL_LIMIT_STATUS = "105";
	public static final String CONVERSION_THIRD_PARTY_FAILURE = "106";
	public static final String UNAUTHORIZED_DEVICE = "110";
	public static final String BLOCKED_USER = "111";
	public static final String INVALID_PARTNER_CODE = "112";
	public static final String MANDATORY_PARAMETER = "113";
	public static final String WALLET_CREATION_FAILURE = "114";
	public static final String OXIGEN_ERROR_STATUS = "115";
	public static final String PAYBACK_ERROR_STATUS = "116";
	public static final String PRODUCT_ORDER_FAILURE_STATUS = "117";
	public static final String NO_MORE_PRODUCT_IN_LIST = "118";
	public static final String PAYTM_NOT_REGISTERED = "119";
	public static final String CATEGORY_LIMIT_STATUS = "120";
	public static final String INVALID_COUPON_TYPE = "121";
	public static final String UNAUTHORIZED_REQUEST = "122";
	public static final String PLZ_UPGRADE = "124";
	public static final String LIVE_SECTION_OFF_TIMING = "125";
	// ADDED FOR MOBIKWIK
	public static final String INVAILD_MOBILE_EMAIL = "127";
	public static final String PROFILE_PARAMETER_MANDATORY = "128";
	public static final String INVALID_FILTER_ID = "130";

	// ADDED For UID Verification
	public static final String UNEXPECTED_BEHAVIOUR = "131";

	// Added for registration
	public static final String NUMBER_ALREADY_IN_USE = "132";
	public static final String RETRY_REGISTRATION = "133";
	public static final String ACCOUNT_ALREADY_LINKED_WITH_ANOTHER_MOBILE = "134";

	public static final String PARTNER_OFF_MESSAGE = "136";

	// ADDED For OTP
	public static final String OTP_COOLOFF_PERIOD = "135";

	// ADDED For AOC
	public static final String AOC_INIT_FAILURE = "150";
	public static final String AOC_INVALID_TXID = "151";
	public static final String AOC_UPDATE_FAILURE = "152";
	public static final String AOC_INVALID_AMOUNT = "153";
	public static final String AOC_INVALID_TRANSACTION = "154";
	public static final String NO_PAYMENT_OPTION_AVAILABLE = "176";
	// Till here for AOC

	// ADDED FOR TRANSERV
	public static final String TRANSERV_NOT_REGISTERED = "155";
	public static final String TRANSERV_MISSING_MOBILE_NUMBER = "156";
	public static final String TRANSERV_THIRD_PARTY_FAILURE = "157";
	public static final String TRANSERV_NO_ERROR_CODE = "158";
	public static final String TRANSERV_COULD_NOT_GENERATE_URL = "159";
	public static final String TRANSERV_ACTIVATION_PENDING = "160";
	public static final String TRANSERV_MINIMUM_BALANCE = "161";
	// Till here for TRANSERV

	public static final String TRANSACTION_HISTORY_FAILURE = "162";
	public static final String PAYBACK_AGE_LIMIT = "163";

	public static final String DEALS_OUT_OF_STOCK_STATUS = "164";

	// ADDED FOR UDIO RECHARGE
	public static final String UDIO_NOT_SUFFICIENT_BALANCE = "165";
	public static final String UDIO_PAYMENT_FAILED = "170";
	public static final String UDIO_RECHARGE_FAILED = "167";
	public static final String UDIO_MAX_TRANSACTIONS = "168";
	public static final String UDIO_INVALID_OPERATOR_PLAN = "169";
	public static final String UDIO_RECHARGE_MAX_TRANSACTION_LIMIT = "175";
	// Till here for UDIO RECHARGE

	public static final String PRODUCT_IS_NOT_AVAILABLE = "166";
	public static final String INVALID_OTP = "171";
	
	//SOCIAL FEEDS ERROR CODES
	public static final String SOCIAL_FEEDS_FAILURE = "177";
	//Till here for SOCIAL FEEDS FAILURE

	
	// NEAR BUY
	public static final String UNAUTORIZE_WITH_PARTNER = "178";
	
	public static final String SUCCESS_STATUS = "200";
	public static final String CONVERSION_SUCCESS = "201";
	public static final String APP_UPGRADE_AVAILABLE = "202";
	public static final String APP_LATEST_VERSION_STATUS = "203";
	public static final String LOGIN_SUCCESS = "204";
	public static final String STUB_UPGRADE_AVAILABLE = "205";
	public static final String NO_NEW_CAMPAIGN = "209";
	public static final String NO_CAMPAIGNS = "210";
	public static final String PRODUCT_ORDER_SUCCESS_STATUS = "216";
	public static final String PRODUCT_ORDER_OUT_OF_STOCK_STATUS = "217";
	public static final String PRODUCT_ORDER_SUCCESS_STATUS_PG = "218";
	public static final String LESS_USED_POINTS_STATUS = "222";
	public static final String RECHARGE_NOT_SUCCESSFUL = "229";
	public static final String ONLINE_CHANNEL_GET_MAIN_CATEGORIES_STATUS = "230";
	public static final String ONLINE_CHANNEL_CAPTURE_USER_CATEGORIES_STATUS = "231";
	public static final String RECHARGE_SUCCESSFUL = "232";
	public static final String RECHARGE_PENDING = "233";
	public static final String SOCIAL_FEEDS_SUCCESS = "234";
	public static final String AOC_UPDATE_SUCCESS = "250";

	// OTP GENERATED
	public static final String WALLET_OTP_GENERATED = "262";
	public static final String APP_FORCE_EXIT = "602";
	public static final String MODULE_UNAVAILABLE = "603";
	
	

}
