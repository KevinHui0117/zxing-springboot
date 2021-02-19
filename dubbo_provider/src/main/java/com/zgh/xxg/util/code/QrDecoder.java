package com.zgh.xxg.util.code;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码解码类
 */
public class QrDecoder {

    public static String decode(String codeAddr){
        String result = "";
        //获取logo
//        String destLogoPath = FileUtil.getPath() + "tempForDecode/";
            try {
                HttpURLConnection httpUrl = (HttpURLConnection) new URL(codeAddr).openConnection();
                httpUrl.connect();
                BufferedImage bi = ImageIO.read(httpUrl.getInputStream());
                if (bi != null) {
                    Map<DecodeHintType, String> hints = new HashMap<>();
                    hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
                    LuminanceSource source = new BufferedImageLuminanceSource(bi);
                    BinaryBitmap bitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));
                    Result res = new MultiFormatReader().decode(bitmap, hints);
                    result = res.getText();
                    System.out.println(res);
                    System.out.println("decode successfully!");
                }
                httpUrl.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
}
