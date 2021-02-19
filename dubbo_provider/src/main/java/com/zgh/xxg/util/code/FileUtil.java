package com.zgh.xxg.util.code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import de.erichseifert.vectorgraphics2d.SVGGraphics2D;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.UUID;


public class FileUtil {


    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return FileUtil.class.getResource("/").getPath();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }

    /**
     * 从InputStream中获取 byte[]
     *
     * @param is
     * @return
     * @throws Exception
     */
    public static byte[] getStreamBytes(InputStream is) throws Exception {
        byte[] data = null;
        if (is.available() == 0) {//严谨起见,一定要加上这个判断,不要返回data[]长度为0的数组指针
            return data;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        byte[] b = baos.toByteArray();
        is.close();
        baos.close();
        return b;
    }

    /**
     * @param source     源图片路径
     * @param formatName 将要转换的图片格式
     * @param result     目标图片路径
     */
    public static void convert(String source, String formatName, String result) {
        try {
            File f = new File(source);
            f.canRead();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, formatName, new File(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //直接复制代码就可生成,所要引入的pom在后面

    public static BitMatrix GetBitMatrix(String content, int size, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        size = (size <= 0) ? 400 : size;
        BitMatrix bitMatrix = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1); // 控制码图白边
        hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel); // 容错率
        bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints);
        return bitMatrix;
    }


    /**
     * 使用pdfbox将jpg转成pdf
     *
     * @param imagePath jpg输入路径
     * @param pdfPath   pdf文件存储路径
     * @throws IOException IOException
     */
    public static void convertJpg2Pdf(String imagePath, String pdfPath) throws IOException {
        URL url = new URL(imagePath);
        InputStream jpgStream = url.openStream();
        PDDocument pdDocument = new PDDocument();
        BufferedImage image = ImageIO.read(jpgStream);
        PDPage pdPage = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
        pdDocument.addPage(pdPage);
        PDImageXObject pdImageXObject = LosslessFactory.createFromImage(pdDocument, image);
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);
        contentStream.drawImage(pdImageXObject, 0, 0, image.getWidth(), image.getHeight());
        contentStream.close();
        pdDocument.save(pdfPath);
        pdDocument.close();
    }


    /**
     * 直接生成 svg
     */
    public static void processSvg(CodeStrategy codeStrategy) {
        try {
            double point_x = 0;
            double point_y = 0;
            final int blockSize = 1;
            SVGGraphics2D funcOld = new SVGGraphics2D(point_x, point_y, codeStrategy.getWidth() * blockSize, codeStrategy.getHeight() * blockSize);
            ExportQrCode.fill2VectorLine(funcOld, GetBitMatrix(codeStrategy.getContents(), codeStrategy.getWidth(), ErrorCorrectionLevel.H), blockSize);
            File file = new File(codeStrategy.getSvgFileName());
            PrintStream psFile = new PrintStream(file);
            psFile.append(funcOld.toString());
            psFile.close();
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String path = "C:\\Users\\MACHENIKE\\Desktop\\code\\out\\dest.jpg";
//        String dest = "C:\\Users\\MACHENIKE\\Desktop\\code\\out\\dest.";
////        // jpg==>png
////        convert(path, "png", dest + "png");
////        // jpg==>pdf
//        try {
//            convertJpg2Pdf(path, dest + "pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // jpg==>svg
//        CodeStrategy codeStrategy = new CodeStrategy();
//        codeStrategy.setContents("哈哈哈");
//        codeStrategy.setSvgFileName("C:\\Users\\MACHENIKE\\Desktop\\code\\out\\dest.pdf");
//        processSvg(codeStrategy);
////         jpg==>eps
//        convert(path, "eps", dest + "eps");
        for (int i = 0; i < 12; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }

    /**
     * 图片url地址转换成file文件
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static File getFile(String url) throws Exception {
        //对本地文件命名
        String fileName = url.substring(url.lastIndexOf("."), url.length());
        File file = null;

        URL urlfile;
        InputStream inStream = null;
        OutputStream os = null;
        try {
            file = File.createTempFile("net_url", fileName);
            //下载
            urlfile = new URL(url);
            inStream = urlfile.openStream();
            os = new FileOutputStream(file);

            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
                if (null != inStream) {
                    inStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return file;
    }


    /**
     * 将InputStream写入本地文件
     *
     * @param destination 写入本地目录
     * @param input       输入流
     * @throws IOException IOException
     */
    public static void inputStreamToFile(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        input.close();
        downloadFile.close();

    }

}
