package com.zgh.xxg.util.code;





import com.zgh.xxg.xxg.util.PathUtil;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字体加载类
 *
 * @author huikai
 * @date 2020/01/13
 */
public class FontUtil {
    /**
     * 获取宋体汉字
     *
     * @return
     */
    public Font loadFontResource(int _fontSize) {
        InputStream resourceAsStream = null;
        Integer str = new Integer(_fontSize);
        int i = str.intValue();
        float fontSize = (float) i;
        try {
            String path = PathUtil.WEB_ROOT + "fonts/simsun.ttf";
            File f = new File(path);
            resourceAsStream = new FileInputStream(f);
            Font font = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
            Font targetFont = font.deriveFont(Font.BOLD, fontSize);
            return targetFont;
        } catch (FontFormatException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
