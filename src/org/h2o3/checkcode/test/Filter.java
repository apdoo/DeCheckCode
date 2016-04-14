/**
 * created since 2010-8-18
 */
package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * 针对图片操作的filter
 * 
 * @author yuezhen
 * @version $Id: Filter.java,v 0.1 2010-8-18 下午05:59:52 yuezhen Exp $
 */
public class Filter {

    /**
     * 纯黑纯白过滤器
     * 纯黑的r*r+g*g*b*b=195075
     * 纯白的r*r+g*g*b*b=0
     * 在91p的验证码中黑的是 145200 36300
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
     * 黑白过滤器
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
     * 针对91p的干扰线去除
     * 单独的一条黑色的线都去除
     */
    public static void myDoFilter(BufferedImage image){
        if (image == null) {
            return;
        }
        for (int i = 0; i < image.getHeight(); i++) {     //高
            for (int j = 0; j < image.getWidth(); j++) {   //宽
                if (i > 0 && j > 0 && i < (image.getHeight() - 1) && j < (image.getWidth() - 1)) {
                    //如果某一点为黑
                    if (image.getRGB(j, i) == 0xff000000) { //0xff000000  黑
                        //孤点去除
                        if (image.getRGB(j - 1, i) == 0xffffffff
                                && image.getRGB(j - 1, i - 1) == 0xffffffff     //  0xffffffff 白
                                && image.getRGB(j, i - 1) == 0xffffffff
                                && image.getRGB(j + 1, i) == 0xffffffff
                                && image.getRGB(j + 1, i + 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff) {
                              //设置为白
                               image.setRGB(j, i, 0xffffffff);
                        }
                        //如果这点的左右都为黑色 上下左上做下右上右下都为白色 认为是一条横线
                        if(image.getRGB(j - 1, i) == 0xff000000
                                &&image.getRGB(j + 1, i) == 0xff000000
                                && image.getRGB(j - 1, i - 1) == 0xffffffff
                                && image.getRGB(j, i - 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff
                                && image.getRGB(j, i + 1) == 0xffffffff )

                        {
                            //设置为白
                            image.setRGB(j, i, 0xffffffff);
                        }
                    }
                }
            }
        }
    }
    /**
     * 孤点过滤器
     * 只能去除孤点(即这个点的上下左右都是白色的)
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
                    if (image.getRGB(j, i) == 0xff000000) { //0xff000000 黑
                        if (image.getRGB(j - 1, i) == 0xffffffff
                            && image.getRGB(j - 1, i - 1) == 0xffffffff     //  0xffffffff 白
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
