package com.zgh.usercenter.service;


import com.zgh.xxg.xxg.base.module.*;
import com.zgh.xxg.xxg.exception.BaseException;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserCenterService {
	
	
	//-----------会员，职工，工作人员相关接口开始-----------//
	//批量保存用户接口
	public void saveUsers(List<User> list, Operater operater) throws BaseException;
	public User saveOrUpdateUser(User user, Operater operater)throws BaseException;
	public void updateUserCertification(Long userId, String certificationLevel,
                                        String fullName, String sex,
                                        String idcardType, String idcardCode,
                                        Operater operater) throws BaseException;
	public void deleteUser(Long userId, Operater operater)throws BaseException;
	public void cancelDeleteUser(Long userId, Operater operater)throws BaseException;
	public User getUserForSystem(Long userId)throws BaseException;
	public User getUser(Long userId, Operater operater)throws BaseException;
	public List<User> listUser(User user, Operater operater, PageData pageData)throws BaseException;
	public Integer countUser(User user, Operater operater)throws BaseException;
	public List<User> listUser(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countUser(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<User> showUserPage(Page<User> page, Operater operater)throws BaseException;

	/**
	 * 用户信息验证接口
	 * 登录方式：可以验证密码，也可以不验证密码（通过i厦门验证）
	 * 可以只输入：
	 * 姓名+身份证类型+身份证号，身份证类型详见字典
	 * 手机号
	 * 用户名
	 * osInfo：登录者操作系统信息
	 * 登录来源：PC，APP,微信,手机或平板浏览器
	 * */
	public User loginUser(String loginType, String idcardCode, String mobile, String email, String password, String ip, String osInfo, String source)throws BaseException;

	/**
	 * 重置密码，新密码将以手机短信发给用户
	 */
	public void resetPasswordUser(Long userId, Operater operater)throws BaseException;
	public void resetPasswordUsers(String userIds, Operater operater)throws BaseException;
	public void resetNewPasswordUsers(Map<Long, String> params, String sendType, Operater operater)throws BaseException;

	public void changePasswordUser(Long userId, String oldPwd, String newPwd, Operater operater)throws BaseException;

	public void changeMobile(Long userId, String newMobile, Operater operater)throws BaseException;

	public void changeUserType(Long userId, String userType, Operater operater);
	public void changeMemeberStatus(Long userId, String memberStatus, Operater operater);



	//会员手机号码历史 查询接口
	public List<UserMobileHistory> listUserMobileHistory(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countUserMobileHistory(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<UserMobileHistory> showUserMobileHistoryPage(Page<UserMobileHistory> page, Operater operater)throws BaseException;

	//-----------会员，职工，工作人员相关接口结束-----------//



	//-----------会员与工会相关接口开始-----------//
	//批量为工会增加会员（会员为已经存在的注册用户）
	public void saveUserAndLabourUnions(List<UserAndLabourUnion> list, Operater operater)throws BaseException;
	public UserAndLabourUnion saveOrUpdateUserAndLabourUnion(UserAndLabourUnion userAndLabourUnion, Operater operater)throws BaseException;
	public void deleteUserAndLabourUnion(Long userId, Long labourUnionId, Operater operater)throws BaseException;
	public List<UserAndLabourUnion> listUserAndLabourUnion(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countUserAndLabourUnion(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<UserAndLabourUnion> showUserAndLabourUnionPage(Page<UserAndLabourUnion> page, Operater operater)throws BaseException;
	//-----------会员与工会相关接口结束-----------//



	//-----------组织相关接口开始-----------//
	public Organization saveOrUpdateOrganization(Organization organization, Operater operater) throws BaseException;
	public void deleteOrganization(Long organizationId, Operater operater) throws BaseException;
	public void cancelDeleteOrganization(Long organizationId, Operater operater) throws BaseException;
	public void cutOrganization(Long organizationId, Long parentId, Operater operater) throws BaseException;
	public Organization getOrganizationForSystem(Long organizationId);
	public Organization getOrganization(Long organizationId, Operater operater) throws BaseException;
	public List<Organization> listOrganization(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countOrganization(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<Organization> showOrganizationPage(Page<Organization> page, Operater operater) throws BaseException;
	public List<Organization> treeRootOrganization(Map<String, Object> params, Operater operater);

	public UserAndOrganization saveOrUpdateUserAndOrganization(UserAndOrganization userAndOrganization, Operater operater) throws BaseException;
	public void deleteUserAndOrganization(Long userId, Long organizationId, Operater operater) throws BaseException;
	public List<UserAndOrganization> listUserAndOrganization(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countUserAndOrganization(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<UserAndOrganization> showUserAndOrganizationPage(Page<UserAndOrganization> page, Operater operater) throws BaseException;

	public List<Organization> listOrganizationChild(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countOrganizationChild(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<Organization> showOrganizationChildPage(Page<Organization> page, Operater operater)throws BaseException;
	//-----------组织相关接口结束-----------//



	//-----------OA组织相关接口开始-----------//
	public OaOrganization saveOrUpdateOaOrganization(OaOrganization oAorganization, Operater operater) throws BaseException;
	public void deleteOaOrganization(Long oAorganizationId, Operater operater) throws BaseException;
	public void cancelDeleteOaOrganization(Long oAorganizationId, Operater operater) throws BaseException;
	public void cutOaOrganization(Long oAorganizationId, Long parentId, Operater operater) throws BaseException;
	public OaOrganization getOaOrganizationForSystem(Long oAorganizationId);
	public OaOrganization getOaOrganization(Long oAorganizationId, Operater operater) throws BaseException;
	public List<OaOrganization> listOaOrganization(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countOaOrganization(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<OaOrganization> showOaOrganizationPage(Page<OaOrganization> page, Operater operater) throws BaseException;
	public List<OaOrganization> treeRootOaOrganization(Map<String, Object> params, Operater operater);

	public UserAndOaOrganization saveOrUpdateUserAndOaOrganization(UserAndOaOrganization userAndOaOrganization, Operater operater) throws BaseException;
	public void deleteUserAndOaOrganization(Long userId, Long oaOrganizationId, Operater operater) throws BaseException;
	public List<UserAndOaOrganization> listUserAndOaOrganization(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countUserAndOaOrganization(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<UserAndOaOrganization> showUserAndOaOrganizationPage(Page<UserAndOaOrganization> page, Operater operater) throws BaseException;

	public List<OaOrganization> listOaOrganizationChild(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countOaOrganizationChild(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<OaOrganization> showOaOrganizationChildPage(Page<OaOrganization> page, Operater operater)throws BaseException;
	//-----------OA组织相关接口结束-----------//

	//-----------OA组织关联的业务单位、OA组织的主管、 OA组织的分管领导  开始-----------//
	public List<OaAndOrg> listOaAndOrg(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public List<OaManager> listOaManager(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public List<OaLeader> listOaLeader(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	//-----------OA组织关联的业务单位、OA组织的主管、 OA组织的分管领导  结束-----------//


	//-----------工会法人相关接口开始-----------//
	public LabourUnion saveOrUpdateLabourUnion(LabourUnion labourUnion, Operater operater)throws BaseException;
	//新增是否办理法人资格证书中字段，legalpersonhandle.1为办理中 0无办理. 是否隶属关系调整中，affiliate，1为调整中，0否
	public TusLabourunionVO saveOrUpdateLabourUnionPlus(TusLabourunionVO tusLabourunionVO, Operater operater);
	//注销工会与组织
	public boolean logoutOrgAndLabourunion(Long id, Operater operater);
	public LabourUnion getLabourUnionForSystem(Long labourUnionId);
	public LabourUnion getLabourUnion(Long labourUnionId, Operater operater)throws BaseException;
	public List<LabourUnion> listLabourUnion(LabourUnion labourUnion, Operater operater, PageData pageData)throws BaseException;
	public Integer countLabourUnion(LabourUnion labourUnion, Operater operater)throws BaseException;
	public List<LabourUnion> listLabourUnion(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countLabourUnion(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<LabourUnion> showLabourUnionPage(Page<LabourUnion> page, Operater operater)throws BaseException;

	public List<LabourUnion> listLabourUnionChild(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countLabourUnionChild(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<LabourUnion> showLabourUnionChildPage(Page<LabourUnion> page, Operater operater)throws BaseException;

	public LabourUnion loginLabourUnion(String labourUnionUnifiedCode, String labourUnionName, String password, Operater operater)throws BaseException;
	public void resetPasswordLabourUnion(Long labourUnionId, Operater operater)throws BaseException;
	public void resetPasswordLabourUnions(String labourUnionIds, Operater operater)throws BaseException;
	public void resetNewPasswordLabourUnions(Map<Long, String> params, String sendType, Operater operater)throws BaseException;
	public void changePasswordLabourUnion(Long labourUnionId, String oldPwd, String newPwd, Operater operater)throws BaseException;
	public List<LabourUnion> treeRootLabourUnion(Map<String, Object> params, Operater operater);
	
	//工会与企业的关联
	public List<LabourUnionAndCompany> listLabourUnionAndCompany(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
    //-----------工会法人相关接口结束-----------//
	
	//-----------单位相关接口开始-----------//
	public Company saveOrUpdateCompany(Company company, Operater operater) throws BaseException;
	public void deleteCompany(Long companyId, Operater operater) throws BaseException;
	public Company getCompany(Long companyId, Operater operater) throws BaseException;
	public List<Company> listCompany(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countCompany(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<Company> showCompanyPage(Page<Company> page, Operater operater) throws BaseException;
	
	public UserAndCompany saveOrUpdateUserAndCompany(UserAndCompany userAndCompany, Operater operater) throws BaseException;
	public void deleteUserAndCompany(Long userAndCompanyId, Operater operater) throws BaseException;
	public UserAndCompany getUserAndCompany(Long userAndCompanyId, Operater operater) throws BaseException;
	public List<UserAndCompany> listUserAndCompany(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countUserAndCompany(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<UserAndCompany> showUserAndCompanyPage(Page<UserAndCompany> page, Operater operater) throws BaseException;
	//-----------单位相关接口结束-----------//
	
	
	//-----------工会法人信息变更历史相关接口开始-----------//
	public LabourUnionHistory saveOrUpdateLabourUnionHistory(LabourUnionHistory LabourUnionHistory, Operater operater) throws BaseException;
	public void deleteLabourUnionHistory(Long labourUnionHistoryId, Operater operater) throws BaseException;
	public LabourUnionHistory getLabourUnionHistory(Long labourUnionHistoryId, Operater operater) throws BaseException;
	public List<LabourUnionHistory> listLabourUnionHistory(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countLabourUnionHistory(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<LabourUnionHistory> showLabourUnionHistoryPage(Page<LabourUnionHistory> page, Operater operater) throws BaseException;
	//-----------工会法人信息变更历史相关接口结束-----------//
	
	
	//-----------锁定解锁接口开始-----------//
	/**
	 * 锁定密码，minute为锁定的时长，单位是分钟，-1表示长期锁定
	 * */
	public void lockUser(Long userId, String lockType, Integer minute, Operater operater)throws BaseException;
	public void unlockUser(Long userId, Operater operater)throws BaseException;
	public void unlockUsers(String userIds, Operater operater)throws BaseException;
	public List<UserLock> listUserLock(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countUserLock(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<UserLock> showUserLockPage(Page<UserLock> page, Operater operater) throws BaseException;

	public void lockLabourUnion(Long labourUnionId, Long userId, String lockType, Integer minute, Operater operater)throws BaseException;
	public void unlockLabourUnion(Long labourUnionId, Operater operater)throws BaseException;
	public void unlockLabourUnions(String labourUnionIds, Operater operater)throws BaseException;
	public List<LabourUnionLock> listLabourUnionLock(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countLabourUnionLock(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<LabourUnionLock> showLabourUnionLockPage(Page<LabourUnionLock> page, Operater operater) throws BaseException;
	//-----------锁定解锁接口开始结束-----------//
	
	//忘记密码人工申诉
	public LostPwdPerson saveOrUpdateLostPwdPerson(LostPwdPerson lostPwdPerson, Operater operater) throws BaseException;
	public LostPwdPerson getLostPwdPerson(Long lostPwdPersonId, Operater operater) throws BaseException;
	public List<LostPwdPerson> listLostPwdPerson(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countLostPwdPerson(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<LostPwdPerson> showLostPwdPersonPage(Page<LostPwdPerson> page, Operater operater) throws BaseException;
	//忘记密码邮件找回
	public LostPwdEmail saveOrUpdateLostPwdEmail(LostPwdEmail lostPwdEmail, Operater operater) throws BaseException;
	public LostPwdEmail getLostPwdEmail(Long lostPwdEmailId, Operater operater) throws BaseException;
	public List<LostPwdEmail> listLostPwdEmail(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countLostPwdEmail(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<LostPwdEmail> showLostPwdEmailPage(Page<LostPwdEmail> page, Operater operater) throws BaseException;
	
	
	//OA用户相关接口
	public User getOaUser(Long userId, Operater operater)throws BaseException;
	public List<User> listOaUser(Map<String, Object> params, Operater operater, PageData pageData)throws BaseException;
	public Integer countOaUser(Map<String, Object> params, Operater operater)throws BaseException;
	public Page<User> showOaUserPage(Page<User> page, Operater operater)throws BaseException;
	//删除工作人员,删除用户与任何OA组织的关联，并且设置userType为1
	public void deleteOaUser(Long userId, Operater operater)throws BaseException;
	public void deleteOaUsers(List<Long> userIds, Operater operater)throws BaseException;
	
	public UserOA UpdateUserOA(UserOA userOa, Operater operater)throws BaseException;

	public User UpdateUserForOA(User use, Operater operater)throws BaseException;
	//用户中心参数接口
	public String getSystemProperty(String propertyName);
	
	//缓存清理接口
	public void clearUserCache();
	public void loadUser(List<Long> userIds);
	public void clearLabourUnionCache();
	public void loadLabourUnion(List<Long> labourUnionIds);
	public void clearOaOrganizationCache();
	public void loadOaOrganization(List<Long> oaOrganizationIds);
	public void clearOrganizationCache();
	public void loadOrganization(List<Long> organizationIds);
	
	//调用外部接口更新或获取用户及法人信息
	public void updateUserAttribute(List<Long> userIds);
	public User getUserAttribute(String idcardCode);
	
	public void updateLabourUnionAttribute(List<Long> labourUnionIds);
	public LabourUnion getLabourUnionAttribute(String labourUnionName);
	
	public void updateCompanyAttribute(List<Long> companyIds);
	public Company getCompanyAttribute(String companyName);
	
	
	//查询用户或法人的属性信息
	public List<Attribute> listAttribute(Map<String, Object> params, Operater operater, PageData pageData) throws BaseException;
	public Integer countAttribute(Map<String, Object> params, Operater operater) throws BaseException;
	public Page<Attribute> showAttributePage(Page<Attribute> page, Operater operater) throws BaseException;

	
	
	//查询用户所属的工会,没有工会返回null
	public LabourUnion getUserLabourUnion(Long userId);
	//查询用户所属的单位
	public Company getUserCompany(Long userId);
	//查询用户所属工会，如果没有工会，查询所属单位的工会，如果还没有，将返回居住所在地的街镇工会
	public LabourUnion getUserStreetLabourUnion(Long userId);
	
	//查询单位所属的工会
	public LabourUnion getCompanyLabourUnion(Long companyId);

	//查询工会所属的街镇工会
	public LabourUnion getStreetLabourUnion(Long labourUnionId);
	//查询工会所属的产业或区工会
	public LabourUnion getAreaLabourUnion(Long labourUnionId);
	
	//查询隶属工会
	public List<LabourUnion> getBelongLabourUnion(Long labourUnionId);
	public String getBelongLabourUnionString(Long labourUnionId);

	//查询工会
	public TusLabourunionVO getLabourUnionById(Long id);
	public List<TusLabourunionVO> getLabourUnionByIds(List ids);

	//	工会列表
	public Page listLabourUnionPage(Page page);
	List<HashMap> listLabourUnionCondition(Page page);
		//查询工会的未注销的子工会,传入 labourunionId 即可
	public List<TusLabourunionVO> getLabourUnionSon(Map<String, Object> params);
	public List<TusLabourunionVO> getLabourUnionSonMultiple(Map<String, Object> params);
	public List<TusLabourunionVO> getLabourUnionSonContainLogout(Map<String, String> params);
	//查询工会的未注销的父工会,传入 labourunionId 即可
	public List<TusLabourunionVO> getLabourUnionParent(Map<String, Object> params);
	public TusLabourunionVO getLabourUnionParentOne(Map<String, Object> params);
	//获取该工会的部分基本用户信息,传入 labourunionId 即可
	public List<TusUserbasicVO> getUserBasic(Map<String, Object> params);
	//根据area获取联合工会底下的灵活就业人员小组
	public List<TusLabourunionVO> getFlexibleJobByCombined(Map<String, Object> params);
	//所属区/产业工会：根据组织机构目录树从下往上找到工会类型为地方工会、地方工会的工会。
	public List<TusLabourunionVO> getLocalUnion(@Param("params") Map<String, Object> params);

	//查询未建会单位
	public List<Company> listNoLabourUnionCompany(Map<String, Object> params, Operater operater, PageData pageData);
	public List<Company> listNoLabourUnionCompanyByUserCount(Map<String, Object> params, Operater operater, PageData pageData);
	public List<Company> listNoLabourUnionCompanyBylabourunionid(Map<String, Object> params, Operater operater, PageData pageData);
	public int countNoLabourUnionCompany(Map<String, Object> params, Operater operater);
	public Page<Company> showNoLabourUnionCompanyPage(Page<Company> page, Operater operater);
	//粘贴未建会
	public boolean oldOrgToNewOrgByCompay(Long newOrganizationId, Long companyId, Operater operater)throws BaseException;
	public boolean poolToNewOrgByCompay(Long newOrganizationId, Long companyId, Operater operater)throws BaseException;
	public boolean oldOrgToNewOrg(Long newOrganizationId, Long oldOrganizationId, Operater operater)throws BaseException;
	public boolean oldOrgToPoolByCompany(Long oldOrganizationId, Long companyId, Operater operater)throws BaseException;
	public boolean oldOrgToPoolByArea(Long oldOrganizationId, Operater operater)throws BaseException;
	//删除未建会
	public boolean delNoUnion(Long companyId, Operater operater);
	//遍历查询该节点的未建会，并该未建会存在公司的list
	public List<TusLabourunionandcomVO> getNoUnionCompanyList(Map<String, Object> params);


	//查询无单位人员
	public List<User> listNoCompanyUser(Map<String, Object> params, Operater operater, PageData pageData);
	public int countNoCompanyUser(Map<String, Object> params, Operater operater);
	public Page<User> showNoCompanyUserPage(Page<User> page, Operater operater);

}
