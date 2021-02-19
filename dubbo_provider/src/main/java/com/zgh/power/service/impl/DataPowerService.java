package com.zgh.power.service.impl;

import java.util.*;

import com.zgh.xxg.cache.CacheConstant;
import com.zgh.xxg.cache.RedisCache;
import com.zgh.xxg.xxg.base.module.*;
import com.zgh.xxg.xxg.exception.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zgh.power.service.IDataPowerService;
import com.zgh.usercenter.service.IUserCenterService;

@Component
@Service
public class DataPowerService implements IDataPowerService {

    @Autowired
    private RedisCache redisCache;
    @Reference
    private IUserCenterService userCenterService;

    private static final String REDISKEY_DATAPOWER_OF_ORG = "dataPower:org:";  //数据权限-组织
    private static final String REDISKEY_DATAPOWER_OF_USER = "dataPower:user:"; //数据权限-用户
    private static final String REDISKEY_DATAPOWER_OF_BIG_ORG = "dataPower:bigOrg:";  //有权限的业务单位
    private static final String REDISKEY_DATAPOWER_OF_BIG_OA_ORG = "dataPower:bigOaOrg:";  //有权限的OA单位

    private static final String REDISKEY_SUPERADMIN = CacheConstant.RBAC + ":superAdmin";

    private static final String REDISKEY_USER_BY_ID = CacheConstant.USER_CENTER + ":userById";
    private static final String REDISKEY_LABOURUNION_BY_ID = CacheConstant.USER_CENTER + ":labourUnionById";
    private static final String REDISKEY_ORGANIZATION_BY_ID = CacheConstant.USER_CENTER + ":organizationById";
    private static final String REDISKEY_OA_ORGANIZATION_BY_ID = CacheConstant.USER_CENTER + ":oaOrganizationById";

    //检查是否超级管理员
	@Override
    public boolean checkIfSuperAdmin(Operater operater) {
        String superAdmin = redisCache.getString(REDISKEY_SUPERADMIN);
        if (StringUtils.isNotBlank(superAdmin)) {
            String[] strs = superAdmin.split(",");
            for (String str : strs) {
                str = str.trim();
                if (str.equals(String.valueOf(operater.getUserId()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getPowerOrganizationCodes(String dataName, Operater operater) {
        String common = "no";
        if (operater.getUserId() == -1) {
            return common;
        }
        common = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_ORG + operater.getUserId(), "common");
        if (StringUtils.isNotBlank(dataName)) {
            String str = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_ORG + operater.getUserId(), dataName);
            if (StringUtils.isNotBlank(str)) {
                common = str;
            }
        }
        if (StringUtils.isBlank(common)) {
            common = "no";
        }
        return common;
    }

    private String getPowerBigOrganizationIds(String dataName, Operater operater) {
        if (operater.getUserId() == -1) {
            return "";
        }
        String common = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_BIG_ORG + operater.getUserId(), "common");
        if (StringUtils.isNotBlank(dataName)) {
            String str = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_BIG_ORG + operater.getUserId(), dataName);
            if (StringUtils.isNotBlank(str)) {
                common = str;
            }
        }
        if (common == null) {
            common = "";
        }
        return common;
    }

    private String getPowerBigOaOrganizationIds(String dataName, Operater operater) {
        if (operater.getUserId() == -1) {
            return "";
        }
        String common = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_BIG_OA_ORG + operater.getUserId(), "common");
        if (StringUtils.isNotBlank(dataName)) {
            String str = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_BIG_OA_ORG + operater.getUserId(), dataName);
            if (StringUtils.isNotBlank(str)) {
                common = str;
            }
        }
        if (common == null) {
            common = "";
        }
        return common;
    }

    private String getPowerUserIds(String dataName, Operater operater) {
        if (operater.getUserId() == -1) {
            return "-1";
        }
        String common = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_USER + operater.getUserId(), "common");

        if (StringUtils.isNotBlank(dataName)) {
            String str = (String) redisCache.getMapValue(REDISKEY_DATAPOWER_OF_USER + operater.getUserId(), dataName);
            if (StringUtils.isNotBlank(str)) {
                common = str;
            }
        }

        if (StringUtils.isBlank(common)) {
            common = String.valueOf(operater.getUserId());
        }
        return common;
    }

    public Page setPowerPage(Map<String, Object> params, String dataName, Operater operater, Page page) {
        params = this.setPower(params, dataName, operater);
        String[] conditions = {"powerOrganizationCodes", "powerUserIds", "powerBigOaOrganizationIds"};
        for (String keyName : conditions) {
            String value = String.valueOf(params.get(keyName));
            if (StringUtils.isNotBlank(value) && !"null".equals(value)) {
                page.putCondition(keyName, value);
            }
        }
        return page;
    }

    @Override
    public Map<String, Object> setPower(Map<String, Object> params, String dataName, Operater operater) {
        if (checkIfSuperAdmin(operater)) {
            return params;
        }
        if (params == null) {
            params = new HashMap<String, Object>();
        }

        if (params.get("powerOrganizationCodes") == null &&
                params.get("powerUserIds") == null &&
                params.get("powerBigOrganizationIds") == null &&
                params.get("powerBigOaOrganizationIds") == null
        ) { //如果已经有事先设置权限则不需要设置

            String powerOrganizationCodes = getPowerOrganizationCodes(dataName, operater);
            if ("%".equals(powerOrganizationCodes)) {
                return params;
            }
            if (StringUtils.isNotBlank(powerOrganizationCodes)) {
                params.put("powerOrganizationCodes", powerOrganizationCodes);
            }

            String powerBigOrganizationIds = getPowerBigOrganizationIds(dataName, operater);
            if (StringUtils.isNotBlank(powerBigOrganizationIds)) {
                params.put("powerBigOrganizationIds", powerBigOrganizationIds);
            }

            String powerBigOaOrganizationIds = getPowerBigOaOrganizationIds(dataName, operater);
            if (StringUtils.isNotBlank(powerBigOaOrganizationIds)) {
                params.put("powerBigOaOrganizationIds", powerBigOaOrganizationIds);
            }

            String powerUserIds = getPowerUserIds(dataName, operater);
            if (StringUtils.isNotBlank(powerUserIds)) {
                params.put("powerUserIds", powerUserIds);
            }
        }

        return params;
    }

//    @Override
    public Map<String, Object> setPowerId(Map<String, Object> params,
                                          String dataName, Operater operater) {
        if (checkIfSuperAdmin(operater)) {
            return params;
        }
        if (params == null) {
            params = new HashMap<String, Object>();
        }

        if (params.get("powerOrganizationCodes") == null &&
                params.get("powerUserIds") == null &&
                params.get("powerBigOrganizationIds") == null &&
                params.get("powerBigOaOrganizationIds") == null
        ) { //如果已经有事先设置权限则不需要设置

            String powerOrganizationCodes = getPowerOrganizationCodes(dataName, operater);
            if (StringUtils.isNotBlank(powerOrganizationCodes)) {
                params.put("powerOrganizationCodes", powerOrganizationCodes);
            }

            String powerBigOrganizationIds = getPowerBigOrganizationIds(dataName, operater);
            if (StringUtils.isNotBlank(powerBigOrganizationIds)) {
                params.put("powerBigOrganizationIds", powerBigOrganizationIds);
            }

            String powerBigOaOrganizationIds = getPowerBigOaOrganizationIds(dataName, operater);
            if (StringUtils.isNotBlank(powerBigOaOrganizationIds)) {
                params.put("powerBigOaOrganizationIds", powerBigOaOrganizationIds);
            }

            String powerUserIds = getPowerUserIds(dataName, operater);
            if (StringUtils.isNotBlank(powerUserIds)) {
                params.put("powerUserIds", powerUserIds);
            }
        }

        Set<Long> bigOrgIds = new HashSet<Long>(); //单位ID
        Set<Long> orgIds = new HashSet<Long>();//部门ID
        String powerBigOaOrganizationIds = (String) params.get("powerBigOaOrganizationIds");
        if (StringUtils.isNotBlank(powerBigOaOrganizationIds)) {
            String[] ids = powerBigOaOrganizationIds.split(",");
            for (String id : ids) {
                bigOrgIds.add(Long.valueOf(id));
            }
        }

        String powerOrganizationCodes = (String) params.get("powerOrganizationCodes");
        if (StringUtils.isNotBlank(powerOrganizationCodes)) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("organizationCode", powerOrganizationCodes);
            PageData pageData = new PageData();
            pageData.setPageSize(PageData.MAX_PAGE_SIZE);
            List<OaOrganization> list = userCenterService.listOaOrganization(map, Operater.getSystemOperater(), pageData);
            if (list != null && !list.isEmpty()) {
                for (OaOrganization oao : list) {
                    if (oao.getBigId() > 0) {
                        orgIds.add(oao.getId());
                    } else {
                        bigOrgIds.add(oao.getId());
                    }
                }
            }
        }

        if (!bigOrgIds.isEmpty()) {
            for (Long id : bigOrgIds) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("bigId", id);
                PageData pageData = new PageData();
                pageData.setPageSize(PageData.MAX_PAGE_SIZE);
                List<OaOrganization> list = userCenterService.listOaOrganization(map, Operater.getSystemOperater(), pageData);
                if (list != null && !list.isEmpty()) {
                    for (OaOrganization oo : list) {
                        if (oo != null) {
                            orgIds.add(oo.getId());
                        }
                    }
                }
            }
            params.put("powerBigOaOrganizationIds", StringUtils.join(bigOrgIds, ","));
        }

        if (!orgIds.isEmpty()) {
            params.put("powerOrganizationIds", StringUtils.join(orgIds, ","));
        }

        return params;
    }

    @Override
    public void checkPower(long userId, long orgId, String dataName, Operater operater, String businessOrOa) {
        //没有指定用户，也没有指定单位数据不需要控制
        if (userId <= 0 && orgId <= 0) {
            return;
        }

        //总能操作自己的数据
        if (operater.getUserId() == userId) {
            return;
        }
        //超级管理员不控制
        if (checkIfSuperAdmin(operater)) {
            return;
        }

        //操作者的数据权限范围
        String powerOrganizationCodes = getPowerOrganizationCodes(dataName, operater);
        if ("%".equals(powerOrganizationCodes)) {
            return;
        }

        //操作者有权限的单位
        String powerBigOrganizationIds = getPowerBigOrganizationIds(dataName, operater);
        String[] bigIds = null;
        if (StringUtils.isNotBlank(powerBigOrganizationIds)) {
            bigIds = powerBigOrganizationIds.split(",");
            Arrays.sort(bigIds);
        }

        String powerBigOaOrganizationIds = getPowerBigOaOrganizationIds(dataName, operater);
        String[] bigOaIds = null;
        if (StringUtils.isNotBlank(powerBigOaOrganizationIds)) {
            bigOaIds = powerBigOaOrganizationIds.split(",");
            Arrays.sort(bigOaIds);
        }

        //操作该userId的权限
        if (userId > 0) {
            String powerUserIds = getPowerUserIds(dataName, operater);
            if (StringUtils.isNotBlank(powerUserIds)) {
                String[] strs = powerUserIds.split(",");
                for (String str : strs) {
                    if (str.equals(String.valueOf(userId))) {
                        return;
                    }
                }
            }

            User user = (User) redisCache.getMapValue(REDISKEY_USER_BY_ID, String.valueOf(userId));

            if (BUSINESS.equals(businessOrOa)) {
                List<UserAndOrganization> list = user.getUserAndOrganizations();
                if (list != null && !list.isEmpty()) {
                    for (UserAndOrganization uao : list) {
                        Organization org = (Organization) redisCache.getMapValue(REDISKEY_ORGANIZATION_BY_ID, String.valueOf(uao.getOrganizationId()));
                        if (bigIds != null) {
                            if (Arrays.binarySearch(bigIds, String.valueOf(org.getId())) >= 0) {
                                return;
                            }
                            if (Arrays.binarySearch(bigIds, String.valueOf(org.getBigId())) >= 0) {
                                return;
                            }
                        }
                        if (checkDataCode(org.getOrganizationCode(), powerOrganizationCodes)) {
                            return;
                        }
                    }
                }
            } else {
                List<UserAndOaOrganization> list = user.getUserAndOaOrganizations();
                if (list != null && !list.isEmpty()) {
                    for (UserAndOaOrganization uaoo : list) {
                        OaOrganization org = (OaOrganization) redisCache.getMapValue(REDISKEY_OA_ORGANIZATION_BY_ID, String.valueOf(uaoo.getOrganizationId()));
                        if (bigOaIds != null) {
                            if (Arrays.binarySearch(bigOaIds, String.valueOf(org.getId())) >= 0) {
                                return;
                            }
                            if (Arrays.binarySearch(bigOaIds, String.valueOf(org.getBigId())) >= 0) {
                                return;
                            }
                        }
                        if (checkDataCode(org.getOrganizationCode(), powerOrganizationCodes)) {
                            return;
                        }
                    }
                }
            }

        }


        if (orgId > 0) {
            if (BUSINESS.equals(businessOrOa)) {
                Organization org = (Organization) redisCache.getMapValue(REDISKEY_ORGANIZATION_BY_ID, String.valueOf(orgId));
                if (bigIds != null) {
                    if (Arrays.binarySearch(bigIds, String.valueOf(org.getId())) >= 0) {
                        return;
                    }
                    if (Arrays.binarySearch(bigIds, String.valueOf(org.getBigId())) >= 0) {
                        return;
                    }
                }
                if (checkDataCode(org.getOrganizationCode(), powerOrganizationCodes)) {
                    return;
                }
            } else {
                OaOrganization org = (OaOrganization) redisCache.getMapValue(REDISKEY_OA_ORGANIZATION_BY_ID, String.valueOf(orgId));
                if (bigOaIds != null) {
                    if (Arrays.binarySearch(bigOaIds, String.valueOf(org.getId())) >= 0) {
                        return;
                    }
                    if (Arrays.binarySearch(bigOaIds, String.valueOf(org.getBigId())) >= 0) {
                        return;
                    }
                }
                if (checkDataCode(org.getOrganizationCode(), powerOrganizationCodes)) {
                    return;
                }
            }

        }

        throw new BaseException(BaseException.NO_POWER,
                BaseException.NO_POWER_MESSAGE);
    }


    private boolean checkDataCode(String dataCode, String powerOrganizationCodes) {
        //有操作该数据所在组织的权限
        if (StringUtils.isNotBlank(powerOrganizationCodes)) {
            String[] strs = powerOrganizationCodes.split(",");
            for (String str : strs) {
                if (str.equals(dataCode)) {
                    return true;
                }
                if (str.endsWith("%")) {
                    str = str.substring(0, str.length() - 1);
                    if (dataCode.startsWith(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
