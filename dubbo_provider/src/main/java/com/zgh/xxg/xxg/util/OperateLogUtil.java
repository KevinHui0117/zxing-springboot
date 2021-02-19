package com.zgh.xxg.xxg.util;

import com.zgh.xxg.xxg.base.module.OperateLog;
import com.zgh.xxg.xxg.base.module.Operater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OperateLogUtil  {

    private static final Logger logger= LoggerFactory.getLogger(OperateLogUtil.class);

    public static void saveOperateLog(Connection conn, OperateLog log, Operater operater) {
        PreparedStatement	ps=null;
        try{
            ps=conn.prepareStatement("INSERT INTO tlog_log (id ,logType ,systemName ,systemCode ,ifCluster ,clusterNode ,systemIp,operateModule,operateSubModule,operateData,operateParam,operateStatus,operateResult,errorMessage,note,operaterId ,operaterName ,operaterIp,operateTime,businessCode,dataCode) values (seq_tlog_log.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, log.getLogType());
            ps.setString(2, SystemProperty.getProperty("systemName"));
            ps.setString(3, SystemProperty.getProperty("systemCode"));
            ps.setString(4, SystemProperty.getProperty("ifCluster"));
            ps.setString(5, SystemProperty.getProperty("clusterNode"));
            ps.setString(6, SystemProperty.getProperty("systemIp"));
            ps.setString(7, log.getOperateModule());
            ps.setString(8, log.getOperateSubModule());
            ps.setString(9, log.getOperateData());
            ps.setString(10, log.getOperateParam());
            ps.setString(11, log.getOperateStatus());
            ps.setString(12, log.getOperateResult());
            ps.setString(13, log.getErrorMessage());
            ps.setString(14, log.getNote());
            ps.setLong(15,operater==null?0:operater.getUserId());
            ps.setString(16, operater==null?"":operater.getFullName());
            ps.setString(17, operater==null?"":operater.getIp());
            ps.setString(18,TimeUtil.getCurrentDateTime());
            ps.setString(19,operater==null?"":operater.getBusinessCode());
            ps.setString(20,operater==null?"":operater.getUserDataCode());
            ps.execute();
        }catch(SQLException ex){
            logger.error("记录操作日志出错",ex);
            return;
        }finally{
            if(ps!=null){
                try{ps.close();}catch(Exception ex){}
            }
        }
    }


    public static void saveOperateLog(Connection conn,OperateLog log) {
        PreparedStatement	ps=null;
        try{
            ps=conn.prepareStatement("INSERT INTO tlog_log (id ,logType ,systemName ,systemCode ,ifCluster ,clusterNode ,systemIp,operateModule,operateSubModule,operateData,operateParam,operateStatus,operateResult,errorMessage,note,operaterId ,operaterName ,operaterIp,operateTime,businessCode,dataCode) values (seq_tlog_log.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, log.getLogType());
            ps.setString(2, SystemProperty.getProperty("systemName"));
            ps.setString(3, SystemProperty.getProperty("systemCode"));
            ps.setString(4, SystemProperty.getProperty("ifCluster"));
            ps.setString(5, SystemProperty.getProperty("clusterNode"));
            ps.setString(6, SystemProperty.getProperty("systemIp"));
            ps.setString(7, log.getOperateModule());
            ps.setString(8, log.getOperateSubModule());
            ps.setString(9, log.getOperateData());
            ps.setString(10, log.getOperateParam());
            ps.setString(11, log.getOperateStatus());
            ps.setString(12, log.getOperateResult());
            ps.setString(13, log.getErrorMessage());
            ps.setString(14, log.getNote());
            ps.setLong(15, log.getOperaterId());
            ps.setString(16, log.getOperaterName());
            ps.setString(17, log.getOperaterIp());
            ps.setString(18,log.getOperateTime());
            ps.setString(19,log.getBusinessCode());
            ps.setString(20, log.getDataCode());
            ps.execute();
        }catch(SQLException ex){
            logger.error("记录操作日志出错",ex);
            return;
        }finally{
            if(ps!=null){
                try{ps.close();}catch(Exception ex){}
            }
        }
    }


    public static void saveOperateLogs(Connection conn,List<OperateLog> list){
        if(list==null || list.isEmpty()){
            return;
        }
        PreparedStatement	ps=null;
        try{
            ps=conn.prepareStatement("INSERT INTO tlog_log (id ,logType ,systemName ,systemCode ,ifCluster ,clusterNode ,systemIp,operateModule,operateSubModule,operateData,operateParam,operateStatus,operateResult,errorMessage,note,operaterId ,operaterName ,operaterIp,operateTime,businessCode,dataCode) values (seq_tlog_log.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            for(OperateLog log:list){
                ps.setString(1, log.getLogType());
                ps.setString(2, SystemProperty.getProperty("systemName"));
                ps.setString(3, SystemProperty.getProperty("systemCode"));
                ps.setString(4, SystemProperty.getProperty("ifCluster"));
                ps.setString(5, SystemProperty.getProperty("clusterNode"));
                ps.setString(6, SystemProperty.getProperty("systemIp"));
                ps.setString(7, log.getOperateModule());
                ps.setString(8, log.getOperateSubModule());
                ps.setString(9, log.getOperateData());
                ps.setString(10, log.getOperateParam());
                ps.setString(11, log.getOperateStatus());
                ps.setString(12, log.getOperateResult());
                ps.setString(13, log.getErrorMessage());
                ps.setString(14, log.getNote());
                ps.setLong(15, log.getOperaterId());
                ps.setString(16, log.getOperaterName());
                ps.setString(17, log.getOperaterIp());
                ps.setString(18,log.getOperateTime());
                ps.setString(19,log.getBusinessCode());
                ps.setString(20, log.getDataCode());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch(SQLException ex){
            logger.error("记录详细操作日志出错",ex);
            return;
        }finally{
            if(ps!=null){
                try{ps.close();}catch(Exception ex){}
            }
        }
    }

}



