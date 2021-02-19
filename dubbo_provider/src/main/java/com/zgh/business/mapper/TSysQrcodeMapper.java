package com.zgh.business.mapper;

import com.zgh.business.entity.QrcodeTypeSys;
import com.zgh.business.entity.TSysQrcode;
import com.zgh.business.entity.TSysQrcodeRecord;
import com.zgh.xxg.xxg.base.dao.IBaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 二维码生成记录表(TSysQrcode)表数据库访问层
 *
 * @author huikai
 * @since 2021-01-11 19:34:40
 */
@Mapper
public interface TSysQrcodeMapper {

    void updateSysCode(QrcodeTypeSys code);

    List<TSysQrcode> statisticList(Map<String, Object> param);

    int statisticCount(Map<String, Object> param);

    List<TSysQrcodeRecord> codeRecordList(Map<String, Object> param);

    int codeRecordCount(Map<String, Object> param);

    int insertCodeRecord(TSysQrcodeRecord codeRecord);

    List<TSysQrcode> getAllActiveCode();

    TSysQrcode getTSysQrcodeByName(Map<String, Object> params);

    int count(Map<String, Object> params);

    TSysQrcode getSingle(Map<String, Object> params);

    void insert(TSysQrcode entity);

    int update(TSysQrcode entity);

}
