package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

/**
 * ͼƬ��ȡ��д�롢�и���ࡣ
 * 
 * @author yuezhen
 * @version $Id: Tools.java,v 0.1 2010-7-13 ����03:08:21 yuezhen Exp $
 */
public class Tools {
    /**
     * ��ͼƬд������ļ�
     * 
     * @param imgFile �ļ�·��
     * @param bi BufferedImage ����
     * @return ��
     */
    public static void writeImageToFile(String imgFile, BufferedImage bi) {
        // дͼƬ��������
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(imgFile
            .substring(imgFile.lastIndexOf('.') + 1));
        ImageWriter writer = (ImageWriter) writers.next();
        // �������Դ
        File f = new File(imgFile);
        ImageOutputStream ios;

        try {
            ios = ImageIO.createImageOutputStream(f);
            writer.setOutput(ios);
            // д�뵽����
            writer.write(bi);
            ios.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    /**
     * ��rgbֵ����145200��ȫ��ת��Ϊ��ɫ��
     */
    public static int myPixelConvert(int pixel){
        int result = 0;
//        System.out.print("pixel:" + pixel);
        //��ȡR/G/B
        int r = (pixel >> 16) & 0xff;  //����16λ������0xff�������� 0xff��ʮ�����ƣ������ʮ������255
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;
        System.out.print("r:"+r+"g:"+g+"b:"+b);
        //Ĭ�Ϻ�ɫ
        result = 0xff000000;

        int tmp = r * r + g * g + b * b;
        System.out.println("temp:"+tmp);
        if (tmp >=145200) {
           //ת����ɫ
            result += 0x00ffffff;
        }

        return result;
    }

    /**
     * ��һ�����ص�תΪ��ɫ���ߺ�ɫ��
     * 
     * @param pixel
     * @return ת��������ص㣨��/�ף�
     */
    public static int pixelConvert(int pixel) {
        int result = 0;
        System.out.print("pixel:" + pixel);
        //��ȡR/G/B
        int r = (pixel >> 16) & 0xff;  //����16λ������0xff�������� 0xff��ʮ�����ƣ������ʮ������255
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;
        System.out.println("r:"+r+"g:"+g+"b:"+b);
        //Ĭ�Ϻ�ɫ
        result = 0xff000000;

        int tmp = r * r + g * g + b * b;
        System.out.println("temp:"+tmp);
        if (tmp > 3 * 128 * 128) {
            //��ɫ��ȫF
            result += 0x00ffffff;
        }

        return result;
    }


    /**
     * ��ȡͼƬ
     * @param path
     * @return
     */
    public static BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
        }

        return image;
    }

    public static BufferedImage subImageFor91P(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();
        return image.getSubimage(12,6,43,16);
    }
    /**
     * ���91porn����֤����и�
     * */
    public static BufferedImage[] getCheckCodesFor91P(BufferedImage image){
        BufferedImage checkCode[] = new BufferedImage[4];
        int height = image.getHeight();
        int width = image.getWidth();
        checkCode[0] = image.getSubimage(0 * (width / checkCode.length)+10, 0, width
                        / checkCode.length,
                height);
        checkCode[1] = image.getSubimage(1 * (width / checkCode.length) + 1, 0, width
                / checkCode.length
                - 1, height);
        checkCode[2] = image.getSubimage(2 * (width / checkCode.length), 0, width
                        / checkCode.length - 3,
                height);
        checkCode[3] = image.getSubimage(3 * (width / checkCode.length) - 2, 0, width
                        / checkCode.length,
                height);

        return checkCode;
    }

    /**
     * ��һ��ͼƬ���չ����з�Ϊ4��
     * @param image
     * @return
     */
    public static BufferedImage[] getCheckCodes(BufferedImage image) {
        BufferedImage checkCode[] = new BufferedImage[4];
        int height = image.getHeight();
        int width = image.getWidth();
        checkCode[0] = image.getSubimage(0 * (width / checkCode.length), 0, width
                                                                            / checkCode.length,
            height);
        checkCode[1] = image.getSubimage(1 * (width / checkCode.length) + 1, 0, width
                                                                                / checkCode.length
                                                                                - 1, height);
        checkCode[2] = image.getSubimage(2 * (width / checkCode.length), 0, width
                                                                            / checkCode.length - 3,
            height);
        checkCode[3] = image.getSubimage(3 * (width / checkCode.length) - 2, 0, width
                                                                                / checkCode.length,
            height);

        return checkCode;
    }
}
