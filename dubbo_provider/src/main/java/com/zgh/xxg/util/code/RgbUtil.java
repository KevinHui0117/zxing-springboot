package com.zgh.xxg.util.code;

import java.awt.*;

/**
 * 颜色转换工具类
 * @author huikai
 * @date 2020/01/14
 */
public class RgbUtil {

    /**
     * 将 #000000 格式的颜色转换为 0xFF000000 格式的颜色
     * @param colorStr
     * @return
     */
    public static String toStringFromColorCode(String colorStr){
        int i =   Integer.parseInt(colorStr.substring(1),16);
        Color c = new Color(i);
        return toHexFromColor(c);
    }
    /**
     * 将 #000000 格式的颜色转换为 0xFF000000 格式的颜色
     * @param colorStr
     * @return
     */
    public static int toIntFromColorCode(String colorStr){
        int i =   Integer.parseInt(colorStr.substring(1),16);
        return i;
    }
    /**
     * Color对象转换成字符串
     * @param color Color对象
     * @return 16进制颜色字符串
     * */
    public static String toHexFromColor(Color color){
        String r,g,b;
        StringBuilder su = new StringBuilder();
        r = Integer.toHexString(color.getRed());
        g = Integer.toHexString(color.getGreen());
        b = Integer.toHexString(color.getBlue());
        r = r.length() == 1 ? "0" + r : r;
        g = g.length() ==1 ? "0" +g : g;
        b = b.length() == 1 ? "0" + b : b;
        r = r.toUpperCase();
        g = g.toUpperCase();
        b = b.toUpperCase();
        su.append("0xFF");
        su.append(r);
        su.append(g);
        su.append(b);
        //0xFF0000FF
        return su.toString();
    }
    /**
     * 字符串转换成Color对象
     * @param colorStr 16进制颜色字符串
     * @return Color对象
     * */
    public static Color toColorFromString(String colorStr){
        colorStr = colorStr.substring(4);
        Color color =  new Color(Integer.parseInt(colorStr, 16)) ;
        //java.awt.Color[r=0,g=0,b=255]
        return color;
    }

    public static void main(String[] args) {
//        System.out.println(toHexFromColor(Color.BLACK));
//        System.out.println(toColorFromString(toHexFromColor(Color.BLACK)));
        String blk = "#000000";
        int i =   Integer.parseInt(blk.substring(1),16);
        Color c = new Color(i);
        System.out.println(toHexFromColor(c));
//        System.out.println(toColorFromString(toHexFromColor(c)));
    }

}
