package com.zgh.xxg.cache;

public class CacheConstant {

	//通用缓存前缀
	public static final String DICT="dict";//字典
	public static final String ADMIN_AREA="adminArea";	//行政区划
	public static final String COMPANY_TYPE="companyType";	//单位性质
	public static final String INDUSTRY="industry";	//行业
	public static final String ECONOMY="economy";	//经济类型
	//各业务系统缓存前缀
	public static final String USER_CENTER="userCenter";//用户中心
	public static final String RBAC="rbac";//权限管理
	
	public static final String SSO_SERVER="ssoServer";//sso服务端
	public static final String OA="oa";
	
	//数据权限缓存前缀
	public static final String  REDISKEY_DATAPOWER_OF_ORG="dataPowerOfOrg_";
	public static final String  REDISKEY_DATAPOWER_OF_USER="dataPowerOfUser_";

	//签名缓存前缀
    public static final String SIGN_BATCH="singBatch_";
    
    //IM缓存前缀
    public static final String IM="im";
}
