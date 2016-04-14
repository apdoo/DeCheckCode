/**
 * created since 2010-8-18
 */
package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * ���ͼƬ������filter
 * 
 * @author yuezhen
 * @version $Id: Filter.java,v 0.1 2010-8-18 ����05:59:52 yuezhen Exp $
 */
public class Filter {

    /**
     * ���ڴ��׹�����
     * ���ڵ�r*r+g*g*b*b=195075
     * ���׵�r*r+g*g*b*b=0
     * ��91p����֤���кڵ��� 145200 36300
     */
    public static void myBlackAndWhiteFilter(BufferedImage image) {
        if (image == null) {
            return;
        }

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                System.out.print("i;"+i+"j:");
                image.setRGB(j, i, Tools.myPixelConvert(image.getRGB(j, i)));
            }
        }
    }
    /**
     * �ڰ׹�����
     * @param image
     * @return
     */
    public static void blackAndWhiteFilter(BufferedImage image) {
        if (image == null) {
            return;
        }

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                System.out.print("i;"+i+"j:"+j+"rgb:"+image.getRGB(j, i));
                image.setRGB(j, i, Tools.pixelConvert(image.getRGB(j, i)));
            }
        }
    }
    /**
     * ���91p�ĸ�����ȥ��
     * ������һ����ɫ���߶�ȥ��
     */
    public static void myDoFilter(BufferedImage image){
        if (image == null) {
            return;
        }
        for (int i = 0; i < image.getHeight(); i++) {     //��
            for (int j = 0; j < image.getWidth(); j++) {   //��
                if (i > 0 && j > 0 && i < (image.getHeight() - 1) && j < (image.getWidth() - 1)) {
                    //���ĳһ��Ϊ��
                    if (image.getRGB(j, i) == 0xff000000) { //0xff000000  ��
                        //�µ�ȥ��
                        if (image.getRGB(j - 1, i) == 0xffffffff
                                && image.getRGB(j - 1, i - 1) == 0xffffffff     //  0xffffffff ��
                                && image.getRGB(j, i - 1) == 0xffffffff
                                && image.getRGB(j + 1, i) == 0xffffffff
                                && image.getRGB(j + 1, i + 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff) {
                              //����Ϊ��
                               image.setRGB(j, i, 0xffffffff);
                        }
                        //����������Ҷ�Ϊ��ɫ �������������������¶�Ϊ��ɫ ��Ϊ��һ������
                        if(image.getRGB(j - 1, i) == 0xff000000
                                &&image.getRGB(j + 1, i) == 0xff000000
                                && image.getRGB(j - 1, i - 1) == 0xffffffff
                                && image.getRGB(j, i - 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff )

                        {
                            //����Ϊ��
                            image.setRGB(j, i, 0xffffffff);
                        }
                    }
                }
            }
        }
    }
    /**
     * �µ������
     * ֻ��ȥ���µ�(���������������Ҷ��ǰ�ɫ��)
     * @param image
     * @return
     */
    public static void dotFilter(BufferedImage image) {
        if (image == null) {
            return;
        }

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                if (i > 0 && j > 0 && i < (image.getHeight() - 1) && j < (image.getWidth() - 1)) {
                    if (image.getRGB(j, i) == 0xff000000) { //0xff000000 ��
                        if (image.getRGB(j - 1, i) == 0xffffffff
                            && image.getRGB(j - 1, i - 1) == 0xffffffff     //  0xffffffff ��
                            && image.getRGB(j, i - 1) == 0xffffffff
                            && image.getRGB(j + 1, i) == 0xffffffff
                            && image.getRGB(j + 1, i + 1) == 0xffffffff
                            && image.getRGB(j, i + 1) == 0xffffffff) {
                            image.setRGB(j, i, 0xffffffff);
                        }
                    }
                }
            }
        }
    }

}
