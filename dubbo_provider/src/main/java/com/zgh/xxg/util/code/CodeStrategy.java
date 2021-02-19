package com.zgh.xxg.util.code;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Data;

import java.io.File;

/**
 * 二维码生成策略
 * @author huikai
 * @date 2020/01/13
 *
 */
@Data
public class CodeStrategy {
    /**
     * 扫码内容
     */
    private String contents;
    /**
     * 二维码宽度
     */
    private int width = 400;
    /**
     * 二维码高度
     */
    private int height = 400;
    /**
     * logo宽度
     */
    private int logoWidth = 0;
    /**
     * logo高度
     */
    private int logoHeight = 0;
    /**
     * 二维码格式 jpg/png
     */
    private String format = "jpg";
    /**
     * 二维码字符集
     */
    private String character_set = "utf-8";
    /**
     * 二维码中间logo的文件
     */
    private File logoFile;
    /**
     * 二维码边缩放比例
     */
    private float logoRatio = 0.20f;
    /**
     * 二维码底部文字
     */
    private String desc;
    /**
     * 二维码底部文字字号
     */
    private int fontSize = 12;
    /**
     * 白边的宽度
     */
    private int whiteWidth;
    /**
     * 二维码最下边的开始坐标
     */
    private int[] bottomStart;
    /**
     * 二维码最下边的结束坐标
     */
    private int[] bottomEnd;
    /**
     * 二维码识别度 默认最高
     * ErrorCorrectionLevel
     *     L(1),
     *     M(0),
     *     Q(3),
     *     H(2);
     */
    private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.H;
    /**
     * 二维码颜色
     */
    private int codeColor = RgbUtil.toIntFromColorCode("#000000");
    /**
     * 二维码背景颜色
     */
    private int codeBgdColor = RgbUtil.toIntFromColorCode("#ffffff");
    /**
     * 二维码文字颜色
     */
    private int codeFontColor = RgbUtil.toIntFromColorCode("#000000");
    /**
     * 二维码svg/eps生成目录
     */
    private String svgFileName;
}