//package com.zgh.business.service.impl;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.util.ObjectUtil;
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSON;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import com.zgh.business.entity.QrcodeTypeSys;
//import com.zgh.business.entity.TSysQrcode;
//import com.zgh.business.entity.TSysQrcodeRecord;
//import com.zgh.business.mapper.TSysQrcodeMapper;
//import com.zgh.business.service.QrCodeServiceRestI;
//import com.zgh.power.service.IDataPowerService;
//import com.zgh.usercenter.service.IUserCenterService;
//import com.zgh.xxg.CodeEnums.CodeTypeEnum;
//import com.zgh.xxg.CodeEnums.FrequencyEnum;
//import com.zgh.xxg.util.code.*;
//import com.zgh.xxg.xxg.app.constants.YNTag;
//import com.zgh.xxg.xxg.app.model.ResponseBean;
//import com.zgh.xxg.xxg.app.model.ResultStatus;
//import com.zgh.xxg.xxg.app.utils.AppDateUtils;
//import com.zgh.xxg.xxg.app.utils.AppNumberUtils;
//import com.zgh.xxg.xxg.app.utils.AppStringUtils;
//import com.zgh.xxg.xxg.base.module.*;
//import com.zgh.xxg.xxg.fastdfs.FastDFSFile;
//import com.zgh.xxg.xxg.fastdfs.FastDFSUtil;
//import com.zgh.xxg.xxg.util.DataCodeUntil;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.dubbo.config.annotation.Service;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.*;
//
///**
// * @author huik
// * @date 2021/01/28
// */
//@Service(interfaceClass = QrCodeServiceRestI.class, protocol = {"rest", "dubbo"})
//@Path("/qrCode/service/")
//@Component
//public class TQrCodeServiceImplRestful implements QrCodeServiceRestI {
//    @Resource
//    private TSysQrcodeMapper tSysQrcodeDao;
//    @Resource
//    private IDataPowerService dataPowerService;
//
//    @Reference
//    IUserCenterService userCenterService;
//
//
//    /**
//     * 生成二维码
//     */
//    @GET
//    @Path("produceQrCode")
//    @Override
//    public Map<String, Object> produceQrCode(Map<String, Object> req) {
//        Map<String, Object> response = new HashMap<>();
//        Operater operater = new Operater();
//        operater.setUserId(1);
//        TSysQrcode tSysQrcode = new TSysQrcode();
//        BeanUtil.copyProperties(req, tSysQrcode);
//        String codeName = "App生成-" + UUID.randomUUID().toString();
//        tSysQrcode.setCodeName(codeName);
//        ResponseBean _saveRes = this.saveOrUpdate(tSysQrcode, operater);
//        if (_saveRes.getCode() == YNTag.Y.value()) {
//            tSysQrcode = (TSysQrcode) _saveRes.getData();
//        } else {
//            if (_saveRes.getCode() == YNTag.N.value()) {
//                response.put("code", "0");
//                response.put("msg", "生成失败，请重试！");
//                return response;
//            }
//        }
//        Map<String, Object> result = this.generateQrCode(tSysQrcode, operater);
//        String _codeAddr = ObjectUtil.isEmpty(result.get("codeAddr")) ? "" : result.get("codeAddr").toString();
//        String _codePicId = ObjectUtil.isEmpty(result.get("codePicId")) ? "" : result.get("codePicId").toString();
//        if (_codeAddr.contains("?token")) {
//            int _end = AppStringUtils.indexOf(_codeAddr, "?token");
//            _codeAddr = _codeAddr.substring(0, _end);
//        }
//        response.put("code", "0");
//        response.put("msg", "success");
//        response.put("codeId", String.valueOf(tSysQrcode.getId()));
//        response.put("codePicId", _codePicId);
//        response.put("httpCodePicAddr", _codeAddr);
//        return response;
//    }
//
//    /**
//     * 校验二维码
//     *
//     * @param codeId      二维码配置编号
//     * @param codePicId   二维码生成的图片的编号
//     * @param operateMark 二维码的业务标志
//     */
//    @GET
//    @Path("ScanCodeVerification")
//    @Override
//    public Map<String, Object> ScanCodeVerification(String codeId, String codePicId, String operateMark) {
//        Map<String, Object> response = new HashMap<>();
//        boolean isOk = false;
//        String msg = "当前二维码生效中!";
//
//        Operater operater = new Operater();
//        operater.setUserId(1);
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", AppNumberUtils.toLong(codeId, 0));
//        TSysQrcode _tSysQrcode = tSysQrcodeDao.getSingle(params);
//
//        // 判断生效日期/失效日期
//        String effectiveDate = _tSysQrcode.getEffectiveDate();
//        String expirationDate = _tSysQrcode.getExpirationDate();
//        Calendar calendar = Calendar.getInstance();
//
//        long miliSt = 0;//生效时间的毫秒
//        long miliNow = 0;//当前时间的毫秒
//        long miliEnd = 0;//失效时间的毫秒
//        long createMili = 0;
//
//        // 失效判断
//        if (StrUtil.isNotEmpty(effectiveDate) && StrUtil.isNotEmpty(expirationDate)) {
//            try {
//                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(effectiveDate + " 00:00:00"));
//                miliSt = calendar.getTimeInMillis();
//                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(AppDateUtils.getTime()));
//                miliNow = calendar.getTimeInMillis();
//                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expirationDate + " 23:59:59"));
//                miliEnd = calendar.getTimeInMillis();
//
//                // 生效期间内 先更新图片和设置，然后判断被扫的图片是否仍可用
//                if (miliNow > miliSt && miliNow < miliEnd) {
//                    if (AppNumberUtils.toInt(_tSysQrcode.getCodeType(), 0) == CodeTypeEnum.DYNAMIC.value()) {
//                        refreshQrCode(operater, _tSysQrcode);
//                        if (StrUtil.isNotEmpty(codePicId)) {
//                            ResponseBean _re = toVerifyPicIsUsable(codeId, codePicId);
//                            if (_re.getCode() == YNTag.Y.value()) {
//                                msg = msg + "  " + AppDateUtils.getTime() + "进行了更新！";
//                                isOk = true;
//                            } else {
//                                response.put("code", "0");
//                                response.put("msg", "该二维码已失效！");
//                                return response;
//                            }
//                        } else {
//                            msg = msg + "  " + AppDateUtils.getTime() + "进行了更新！";
//                            isOk = true;
//                        }
//                    } else {
//                        isOk = true;
//                    }
//                } else {
//                    isOk = false;
//                    response.put("code", "0");
//                    response.put("msg", "该二维码已失效！");
//                    return response;
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (isOk) {
//            this.insertCodeRecord(_tSysQrcode.getId(), operater);
//            response.put("code", "1");
//            response.put("msg", "该二维码校验成功，可用！");
//            return response;
//        } else {
//            response.put("code", "0");
//            response.put("msg", "该二维码不可用！");
//            return response;
//        }
//    }
//
//
//    @Transactional
//    public void updateSysCode(QrcodeTypeSys code, Operater operater) {
//        DataCodeUntil.updateSet(operater, code);
//        tSysQrcodeDao.updateSysCode(code);
//    }
//
//    public Page getStatisticCodePage(Map<String, Object> params, Operater operater) {
//        Page page = new Page();
//        String pageNo = String.valueOf(params.get("pageNo"));
//        if (StringUtils.isNotBlank(pageNo) && !"null".equals(pageNo)) {
//            page.setPageNo(pageNo);
//        }
//        String pageSize = String.valueOf(params.get("pageSize"));
//        if (StringUtils.isNotBlank(pageSize) && !"null".equals(pageSize)) {
//            page.setPageSize(pageSize);
//        }
//        dataPowerService.setPower(params, "", operater);
//        //查询条件
//        String[] conditions = {"codeName", "codeType", "codeClassification", "expirationDateBegin", "expirationDateEnd", "createTimeBegin",
//                "createTimeEnd", "updateTimeBegin", "updateTimeEnd", "powerOrganizationCodes", "powerUserIds", "id", "ids", "scanCount"};
//        for (String keyName : conditions) {
//            String value = String.valueOf(params.get(keyName));
//            if (StringUtils.isNotBlank(value) && !"null".equals(value)) {
//                page.putCondition(keyName, value);
//            }
//        }
//        page.setTotal(tSysQrcodeDao.statisticCount(page.getMap()));
//        PageData pageData = new PageData();
//        pageData.setCurrentPage(page.getPageNo());
//        pageData.setPageSize(page.getPageSize());
//        page.getMap().put("pageData", pageData);
//        page.setRows(tSysQrcodeDao.statisticList(page.getMap()));
//        page.getMap().remove("pageData");
//        return page;
//    }
//
//
//    public Page getCodeRecordPage(Map<String, Object> params, Operater operater) {
//        Page page = new Page();
//        String pageNo = String.valueOf(params.get("pageNo"));
//        if (StringUtils.isNotBlank(pageNo) && !"null".equals(pageNo)) {
//            page.setPageNo(pageNo);
//        }
//        String pageSize = String.valueOf(params.get("pageSize"));
//        if (StringUtils.isNotBlank(pageSize) && !"null".equals(pageSize)) {
//            page.setPageSize(pageSize);
//        }
//        //查询条件
//        String[] conditions = {"codeId", "userName", "sex", "phone", "labourUnionName", "createTimeBegin", "createTimeEnd"};
//        for (String keyName : conditions) {
//            String value = String.valueOf(params.get(keyName));
//            if (StringUtils.isNotBlank(value) && !"null".equals(value)) {
//                page.putCondition(keyName, value);
//            }
//        }
//        page.setTotal(tSysQrcodeDao.codeRecordCount(page.getMap()));
//        PageData pageData = new PageData();
//        pageData.setCurrentPage(page.getPageNo());
//        pageData.setPageSize(page.getPageSize());
//        page.getMap().put("pageData", pageData);
//        page.setRows(tSysQrcodeDao.codeRecordList(page.getMap()));
//        page.getMap().remove("pageData");
//        return page;
//    }
//
//
//    /**
//     * 新增扫码明细接口
//     *
//     * @param codeId,二维码id
//     * @param operater
//     * @return
//     */
//    @Transactional
//    public int insertCodeRecord(Long codeId, Operater operater) {
//        TSysQrcodeRecord codeRecord = new TSysQrcodeRecord();
//        codeRecord.setCodeId(codeId);
//        User user = userCenterService.getUser(operater.getUserId(), Operater.getSystemOperater());
//        codeRecord.setUserId(user.getId());
//        codeRecord.setUserName(user.getFullName());
//        codeRecord.setSex(user.getSex());
//        codeRecord.setPhone(user.getMobile());
//        LabourUnion labourUnion = userCenterService.getUserLabourUnion(operater.getUserId());
//        codeRecord.setLabourUnionId(labourUnion == null ? null : labourUnion.getId());
//        DataCodeUntil.insertSet(operater, codeRecord);
//        DataCodeUntil.updateSet(operater, codeRecord);
//        return tSysQrcodeDao.insertCodeRecord(codeRecord);
//    }
//
//
//    /**
//     * 保存/更新二维码生成页面信息
//     *
//     * @param operater
//     * @return
//     */
//    @Transactional
//    public ResponseBean saveOrUpdate(TSysQrcode tSysQrcode, Operater operater) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("codeNameR", tSysQrcode.getCodeName());
//        // 每次保存&修改之前，二维码图片做一次静默更新
//        Map<String, Object> result = this.generateQrCode(tSysQrcode, operater);
//        tSysQrcode.setCodeAddr(result.get("codeAddr") == null ? "" : result.get("codeAddr").toString());
//        tSysQrcode.setCodePicId(result.get("codePicId") == null ? "" : result.get("codePicId").toString());
//        // 去除链接最后面的逗号
//        if (tSysQrcode.getCodeLink() != null) {
//            if(tSysQrcode.getCodeLink().contains(",")){
//                String codeLink = tSysQrcode.getCodeLink().substring(0, tSysQrcode.getCodeLink().length() - 1);
//            }
//        }
//        // 保存
//        try {
//            if (tSysQrcode.getId() == null && "0".equals(tSysQrcode.getStatus())) {
//                DataCodeUntil.insertSet(operater, tSysQrcode);
//                // 短连接
//                if (tSysQrcode.getCodeLinkType() == 2) {
//                    String shortLink = ShortUrlUtil.processShortLink(AppStringUtils.defaultIfEmpty(tSysQrcode.getCodeLink(), ""));
//                    tSysQrcode.setCodeShortLink(shortLink);
//                }
//                //去重判定
//                int count = tSysQrcodeDao.count(params);
//                if (count > 0) {
//                    return ResponseBean.error(0, "当前用户已申请过同名二维码，请修改名称重试！", null);
//                } else {
//                    DataCodeUntil.insertSet(operater, tSysQrcode);
//                    tSysQrcode.setEnable("1");
//                    tSysQrcode.setCreater(operater.getUserId());
//                    tSysQrcodeDao.insert(tSysQrcode);
//                    tSysQrcode = tSysQrcodeDao.getSingle(params);
//                    return ResponseBean.suc(tSysQrcode);
//                }
//            } else {//修改
//                DataCodeUntil.updateSet(operater, tSysQrcode);
//                TSysQrcode _tSysQrcode = tSysQrcodeDao.getSingle(params);
//                if (ObjectUtil.isNotNull(_tSysQrcode)) {
//                    if (_tSysQrcode.getCodeLinkType() == 2 && StrUtil.isEmpty(_tSysQrcode.getCodeShortLink())) {
//                        String shortLink = ShortUrlUtil.processShortLink(AppStringUtils.defaultIfEmpty(tSysQrcode.getCodeLink(), ""));
//                        tSysQrcode.setCodeShortLink(shortLink);
//                    }
//                    // 前端原来是活码，改成静态码了，将活码短连接设为空
//                    if (tSysQrcode.getCodeLinkType() == 1 && StrUtil.isNotEmpty(_tSysQrcode.getCodeShortLink())) {
//                        tSysQrcode.setCodeShortLink("");
//                    }
//                }
//                tSysQrcode.setUpdater(operater.getUserId());
//                tSysQrcodeDao.update(tSysQrcode);
//                return ResponseBean.suc(tSysQrcode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBean.error(ResultStatus.SYS_ERROR);
//        }
//    }
//
//
//    /**
//     * 生成二维码(只要是走该接口的，都是需要美化的)
//     * 该接口生成 png && jpg 两种格式的 图片
//     *
//     * @param tSysQrcode
//     * @param operater
//     * @return codeAddr, codePicId
//     */
//    public Map<String, Object> generateQrCode(TSysQrcode tSysQrcode, Operater operater) {
//        Map<String, Object> result = new HashMap<>();
//        CodeBuilder builder = new CodeBuilder();
//        CodeStrategy strategy = new CodeStrategy();
//        // 二维码内容的 map
//        Map<String, String> map = new HashMap<>();
//
//        strategy.setWidth(tSysQrcode.getCodeSize());
//        strategy.setHeight(tSysQrcode.getCodeSize());
//
//        if (StrUtil.isNotEmpty(tSysQrcode.getCodeColor())) {
//            strategy.setCodeColor(RgbUtil.toIntFromColorCode(tSysQrcode.getCodeColor()));
//        }
//        if (StrUtil.isNotEmpty(tSysQrcode.getCodeBgdColor())) {
//            strategy.setCodeBgdColor(RgbUtil.toIntFromColorCode(tSysQrcode.getCodeBgdColor()));
//        }
//        strategy.setErrorCorrectionLevel(ErrorCorrectionLevel.forBits(tSysQrcode.getRecognitionDgree()));
//
//        if (tSysQrcode.getId() != null) {
//            map.put("codeId", tSysQrcode.getId().toString());
//            map.put("textAreaLink", "app/qrCode/fetchTextArea?codeId=" + tSysQrcode.getId() == null ? "0" : tSysQrcode.getId().toString());
//            map.put("verificationLink", "app/qrCode/ScanCodeVerification?codeId=" + tSysQrcode.getId() == null ? "0" : tSysQrcode.getId().toString());
//            if (tSysQrcode.getCodeLinkType() == 2) {
//                Map<String, Object> params = new HashMap<>();
//                params.put("codeNameR", tSysQrcode.getCodeName());
//                TSysQrcode _tSysQrcode = tSysQrcodeDao.getSingle(params);
//                if (ObjectUtil.isNotNull(_tSysQrcode)) {
//                    map.put("codeShortLink", AppStringUtils.defaultIfEmpty(_tSysQrcode.getCodeShortLink(), ""));
//                }
//            }
//        }
//        // 业务链接
//        if (StrUtil.isNotEmpty(tSysQrcode.getCodeName())) {
//            String path = "/app/qrCode/fetchTextArea?codeName=";
//            //移动端可根据该路径去获取content的内容
//            map.put("codeAreaPath", path + tSysQrcode.getCodeName());
//        }
//        if (tSysQrcode.getId() != null) {
//            map.put("codeId", String.valueOf(tSysQrcode.getId()));
//        }
//        if (tSysQrcode.getIsRefreshValidate() == YNTag.Y.value()) {
//            map.put("codePicId", UUID.randomUUID().toString());
//        } else {
//            map.put("codePicId", StrUtil.isEmpty(tSysQrcode.getCodePicId()) ? UUID.randomUUID().toString() : tSysQrcode.getCodePicId());
//        }
//        result.put("codePicId", map.get("codePicId").toString());
//        String salt = UUID.randomUUID().toString() + "-" + AppDateUtils.getTime();
//        map.put("salt", salt);
//        String content = JSON.toJSONString(map);
//        strategy.setContents(content);
//        strategy.setDesc(tSysQrcode.getLogoWord());
//        String destName = "";
//        if ("png".equals(tSysQrcode.getFormat())) {// 下载 png使用
//            destName = FileUtil.getPath() + "tempForDownLoad/" + tSysQrcode.getCodeName() + operater.getUserId() + "." + tSysQrcode.getFormat();
//        } else if ("jpg".equals(tSysQrcode.getFormat())) {//创建临时文件 (jpg格式) -- 生成动作使用
//            destName = FileUtil.getPath() + "tempForGen/" + tSysQrcode.getCodeName() + operater.getUserId() + "." + tSysQrcode.getFormat();
//        }
//        //生成二维码
//        builder.createCodeImage(strategy, destName);
//        String codeAddr = "";
//        try {
//            FileInputStream preUpload = new FileInputStream(destName);
//            String ext = tSysQrcode.getFormat();
//            FastDFSFile file = new FastDFSFile(FileUtil.getStreamBytes(preUpload), tSysQrcode.getCodeName(), ext, operater.getFullName());
//            String url = FastDFSUtil.upload(file);
//            codeAddr = FastDFSUtil.getHttpPath(url);
//            result.put("codeAddr", codeAddr);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    public List<TSysQrcode> getAllActiveCode() {
//        return tSysQrcodeDao.getAllActiveCode();
//    }
//
//    public TSysQrcode getTSysQrcodeByName(Map<String, Object> params) {
//        return tSysQrcodeDao.getTSysQrcodeByName(params);
//    }
//
//
//    /**
//     * 根据频率刷新二维码
//     *
//     * @param operater
//     * @param _tSysQrcode
//     */
//    private void refreshQrCode(Operater operater, TSysQrcode _tSysQrcode) {
//        // 创建时间
//        String createTime = _tSysQrcode.getUpdateTime();
//        // 更新二维码频率值
//        int refreshFrequency = _tSysQrcode.getRefreshFrequency();
//        // 更新二维码频率单位
//        int frequencyUnit = _tSysQrcode.getFrequencyUnit();
//        // 二维码生成后出参 codeAddr 和 codePicId
//        Map<String, Object> result = new HashMap<>();
//        _tSysQrcode.setIsRefreshValidate(YNTag.Y.value());
//
//        LocalDateTime nowTime = LocalDateTime.now();
//        LocalDateTime _createTime = LocalDateTime.of(
//                AppNumberUtils.toInt(createTime.substring(0, 4)),
//                AppNumberUtils.toInt(createTime.substring(5, 7)),
//                AppNumberUtils.toInt(createTime.substring(8, 10)),
//                AppNumberUtils.toInt(createTime.substring(11, 13)),
//                AppNumberUtils.toInt(createTime.substring(14, 16)),
//                AppNumberUtils.toInt(createTime.substring(16, 18)));
//        // 创建时间与当前时间相差的时间
//        Duration duration = Duration.between(nowTime, _createTime);
//        // 秒
//        if (frequencyUnit == FrequencyEnum.SECOND.value()) {
//            if (refreshFrequency >= duration.toMillis() / 1000) {
//                result = this.generateQrCode(_tSysQrcode, operater);
//                _tSysQrcode.setCodeAddr(result.get("codeAddr").toString());
//                _tSysQrcode.setCodePicId(result.get("codePicId").toString());
//                DataCodeUntil.updateSet(operater, _tSysQrcode);
//                tSysQrcodeDao.update(_tSysQrcode);
//            }
//        }
//        // 分钟
//        if (frequencyUnit == FrequencyEnum.MINUTE.value()) {
//            if (refreshFrequency >= duration.toMinutes()) {
//                result = this.generateQrCode(_tSysQrcode, operater);
//                _tSysQrcode.setCodeAddr(result.get("codeAddr").toString());
//                _tSysQrcode.setCodePicId(result.get("codePicId").toString());
//                DataCodeUntil.updateSet(operater, _tSysQrcode);
//                tSysQrcodeDao.update(_tSysQrcode);
//            }
//        }
//        // 小时
//        if (frequencyUnit == FrequencyEnum.HOUR.value()) {
//            if (refreshFrequency >= duration.toHours()) {
//                result = this.generateQrCode(_tSysQrcode, operater);
//                _tSysQrcode.setCodeAddr(result.get("codeAddr").toString());
//                _tSysQrcode.setCodePicId(result.get("codePicId").toString());
//                DataCodeUntil.updateSet(operater, _tSysQrcode);
//                tSysQrcodeDao.update(_tSysQrcode);
//            }
//        }
//        // 天
//        if (frequencyUnit == FrequencyEnum.DAY.value()) {
//            if (refreshFrequency >= duration.toDays()) {
//                result = this.generateQrCode(_tSysQrcode, operater);
//                _tSysQrcode.setCodeAddr(result.get("codeAddr").toString());
//                _tSysQrcode.setCodePicId(result.get("codePicId").toString());
//                DataCodeUntil.updateSet(operater, _tSysQrcode);
//                tSysQrcodeDao.update(_tSysQrcode);
//            }
//        }
//    }
//
//    /**
//     * 校验当前被扫码的二维码是否可用
//     *
//     * @param codeId
//     * @param codePicId
//     * @return
//     */
//    public ResponseBean toVerifyPicIsUsable(String codeId, String codePicId) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("codeId", codeId);
//        TSysQrcode _tSysQrcode = tSysQrcodeDao.getSingle(params);
//        String _codePicId = AppStringUtils.defaultString(_tSysQrcode.getCodePicId(), "none");
//        if (AppStringUtils.defaultIfEmpty(codePicId, "empty").equals(_codePicId)) {
//            return ResponseBean.suc("校验一致，该二维码图片可用！");
//        }
//        return ResponseBean.error("校验不一致，该二维码图片已失效！");
//    }
//}
//
