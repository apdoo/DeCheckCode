package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * �и��������ڵ�һ���и���֤��
 * 
 * @author yuezhen
 * @version $Id: Cutter.java,v 0.1 2010-7-13 ����03:08:05 yuezhen Exp $
 */
public class Cutter {
    public static void main(String[] args) {
        BufferedImage image = null;
        BufferedImage checkCode[] = new BufferedImage[4];
        try {
            image = ImageIO.read(new File("E:/getcode.bmp"));
        } catch (IOException e) {
            System.out.println("can't open checkCode");
        }

        checkCode=Tools.getCheckCodes(image);

        for (int i = 0; i < checkCode.length; i++) {
            try {
                ImageIO.write(checkCode[i], "BMP", new File("E:\\sis" +"\\" +i+ ".bmp"));
            } catch (IOException e) {
                System.out.println("can't open checkCode");
            }
        }
    }
}
