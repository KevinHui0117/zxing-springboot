package com.zgh.business.dubbo_consumer;

import com.zgh.business.service.QrCodeServiceI;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huik
 * @date 2021/01/29
 */
@RestController
public class TestDubboController {
    @Reference
    QrCodeServiceI qrCodeServiceI;

    /**
     * 生成二维码
     * @return
     */
    @GetMapping("test_produce")
    public String testP() {
        Map<String, Object> params = new HashMap<>();
        params.put("genChannel", "personalCenter");//个人中心
        params.put("codeLink", "");
        params.put("codeLinkType", "");
        params.put("codeSize", 400);
        params.put("codeType", 1);
        params.put("effectiveDate", "2020-01-01 00:00:00");
        params.put("expirationDate", "2020-12-31 23:59:59");
        Map<String, Object> response = qrCodeServiceI.produceQrCode(params);
        return response.toString();
    }

    /**
     * 二维码校验
     * @return
     */
    @GetMapping("test_validate")
    public String testV() {
        String codeId = "79";
        String codePicId = "8c211663-859d-4406-85bb-4b9339099144";
        String operateMark = "待定";
        Map<String, Object> response = qrCodeServiceI.ScanCodeVerification(codeId, codePicId, operateMark);
        return response.toString();
    }

}
