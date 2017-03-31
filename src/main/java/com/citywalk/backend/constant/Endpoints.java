package com.citywalk.backend.constant;

/**
 * This class is implemented for constants which are used as end points
 * @author Guru
 *
 */
public interface Endpoints {
	
	public static final String API_PAYMENT_REQUEST_MAPPING = "/poc/api";
	
	public static final String API_PAYMENT_REGISTER_URL = "/registeruser";
	
	public static final String API_LOGIN_URL = "/login";
	
	public static final String PAYMENT_FILTER_RESTRICTED = "/restricted/*";
	
	public static final String PAYMENT_SECURITY_MATCHURL_PATTERN = "/poc/api";
	
	public static final String PAYMENT_STUB_JSON_PATH = "stub/merchant.json";
	
	public static final String PAYMENT_WEB_CONFIGURATION = "/resources/swagger/**";
	
	public static final String PAYMENT_WEB_RESOURCE_LOCATION = "/resources/swagger/";
	
	public static final String API_SECURITY_CONFIG_URL = "/poc/api";
	
	public static final String API_INCLUDE_PATTERN = "/api/.*";//.includePatterns(".*?");
}
