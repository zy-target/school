package cn.zyforget.school.label;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompressTranTest {


    @Test
    public void compressTgranTest(){
        String s = GetImageStr();
        System.out.println("s:" + s.length());
        try {
            String s1 = compressTest(s);
            System.out.println("s1:" + s1.length());
            System.out.println("s1:" + s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //图片转化成base64字符串
    public static String GetImageStr()
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = "E:\\TGRAM\\test\\123.jpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
//读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    public String compressTest(String imgStr) throws IOException {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
//Base64解码
            byte[] imgBytes = decoder.decodeBuffer(imgStr);
            byte[] resultImg = compressUnderSize(imgBytes, 800 * 1024);
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(resultImg);//返回Base64编码过的字节数组字符串
//            byte2image(resultImg, "E:\\TGRAM\\test\\erter5qwqw.jpg");
//            long timeEnd = System.currentTimeMillis();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将图片压缩到指定大小以内
     *
     * @param srcImgData 源图片数据
     * @param maxSize 目的图片大小
     * @return 压缩后的图片数据
     */
    public static byte[] compressUnderSize(byte[] srcImgData, long maxSize) {
        double scale = 0.9;
        byte[] imgData = Arrays.copyOf(srcImgData, srcImgData.length);

        if (imgData.length > maxSize) {
            do {
                try {
                    imgData = compress(imgData, scale);

                } catch (IOException e) {
                    throw new IllegalStateException("压缩图片过程中出错，请及时联系管理员！", e);
                }

            } while (imgData.length > maxSize);
        }

        return imgData;
    }

    /**
     * 按照 宽高 比例压缩
     *
     * @return 压缩后图片数据
     * @throws IOException 压缩图片过程中出错
     */
    public static byte[] compress(byte[] srcImgData, double scale) throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(srcImgData));
        int width = (int) (bi.getWidth() * scale); // 源图宽度
        int height = (int) (bi.getHeight() * scale); // 源图高度

        Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ImageIO.write(tag, "JPEG", bOut);

        return bOut.toByteArray();
    }

        //byte数组到图片
        public static void byte2image(byte[] data,String path){
            if(data.length<3||path.equals("")) return;
            try{
                FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
                imageOutput.write(data, 0, data.length);
                imageOutput.close();
                System.out.println("Make Picture success,Please find image in " + path);
            } catch(Exception ex) {
                System.out.println("Exception: " + ex);
                ex.printStackTrace();
            }
        }
}
