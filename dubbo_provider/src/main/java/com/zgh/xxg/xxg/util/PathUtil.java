package com.zgh.xxg.xxg.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName: PathUtil
 * @Author huikai
 * @Description: TODO(获取web环境中的相应路径)
 * @Date 2019-07-18 11:10:56
 */
public class PathUtil {
    /**
     * eg: G:/workspace/FNFramework/WebRoot/WEB-INF/classes/
     */
    public static final String CLASSES = getClassesPath();

    /**
     * eg: G:/workspace/FNFramework/WebRoot/WEB-INF/
     */
    public static final String WEB_INF = getWEB_INFPath();

    /**
     * eg: G:/workspace/FNFramework/WebRoot/
     */
    public static final String WEB_ROOT = getWEB_ROOTPath();

    /**
     * 获取某个类所在的路径 ,eg:
     * G:/workspace/FNFramework/WebRoot/WEB-INF/classes/com/funo/framework/entity/
     */
    public static <T> String getClassPath(Class<T> cls) {
        String s = cls.getResource("").getPath();
        if (s.startsWith("/")) s = s.substring(1);
        return s;
    }

    /**
     * 获取classes目录下的资源流
     */
    public static InputStream getInputStreamFromClasses(String packageNameAndFileName) {
        try {
            FileInputStream fin = new FileInputStream(CLASSES + packageNameAndFileName);
            return fin;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取WEB-INF目录下的资源流
     */
    public static InputStream getInputStreamFromWebInf(String fileName) {
        try {
            FileInputStream fin = new FileInputStream(WEB_INF + fileName);
            return fin;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从jar文件获取资源流
     *
     * @param oneClassInJar jar里面的一个类
     * @param fileName
     * @return
     */
    public static <T> InputStream getInputStreamFromJar(Class<T> oneClassInJar, String fileName) {
        InputStream is = oneClassInJar.getResourceAsStream(fileName);
        return is;
    }

    /**
     * 取得classes目录, eg:
     * G:/workspace/FNFramework/WebRoot/WEB-INF/classes/
     *
     * @return
     */
    private static String getClassesPath() {
        String s = PathUtil.class.getResource("/").getPath();
        if (s.startsWith("/")) s = s.substring(1);

        return s;
    }

    /**
     * 取得web-inf路径, eg:
     * G:/workspace/FNFramework/WebRoot/WEB-INF/
     *
     * @return
     */
    private static String getWEB_INFPath() {
        String classes = getClassesPath();
        int last = classes.lastIndexOf("classes/");

        return classes.substring(0, last);
    }

    /**
     * 取得WEB_ROOT目录, eg:
     * G:/workspace/FNFramework/WebRoot/
     *
     * @return
     */
    private static String getWEB_ROOTPath() {
        String classes = getClassesPath();
        int last = classes.lastIndexOf("WEB-INF/classes/");
        String webroot = classes.substring(0, last);
        // linux
        if (File.separator.equals("/")) {
            webroot = "/" + webroot;
        }
        return webroot;
    }

    /**
     * 获取项目的工程绝对路径
     *
     * @param request
     * @return
     */
    public static String getWebRoot(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/").replace('\\', '/') + "/";
    }

    public static void main(String[] args) {
        System.out.println(PathUtil.CLASSES);
        System.out.println(PathUtil.WEB_INF);
        System.out.println(PathUtil.WEB_ROOT);

    }
}
