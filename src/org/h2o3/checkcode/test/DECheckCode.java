package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * ��֤��ʶ��
 *
 *
 * @author yuezhen
 * @version $Id: DECheckCode.java,v 0.1 2010-7-13 ����03:06:20 yuezhen Exp $
 */
public class DECheckCode {
    
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            BufferedImage image = Tools.getImage("checkCode/check"+i+".bmp");
            System.out.print("check"+i+".bmp == ");
            compare(image);    
            System.out.println("");
        }
    }
    
    public static void compare(BufferedImage image){
        BufferedImage checkCode[] = Tools.getCheckCodes(image);

        //4λ���ֱȶ�
        for (int t = 0; t < 4; t++) {
            boolean ckFlg = true;
            int num=-1;
            //����0-9ͼƬ�ıȶ�
            for (int i = 0; i < 10; i++) {
                //��ʼ����־λ
                num=-1;
                ckFlg = true;
                BufferedImage testImage = Tools.getImage("check" + (t + 1) + "/" + i+ ".bmp");
                
                if(testImage==null){
                    continue;
                }
                
                //һ������һ�����صıȶ�
                for (int y = 0; y < checkCode[t].getHeight(); ++y) {
                    for (int x = 0; x < checkCode[t].getWidth(); ++x) {
                        int expRGB = Tools.pixelConvert(checkCode[t].getRGB(x, y));
                        int cmpRGB = Tools.pixelConvert(testImage.getRGB(x, y));
                        if (expRGB != cmpRGB) {
                            ckFlg = false;
                            break;
                        }
                    }
                }

                //����������ص㶼һ������������������
                if (ckFlg) {
                    num=i;
                    break;
                }
            }
            if (ckFlg) {
                System.out.print(num);
            } else {
                //���û�ҵ�ƥ�����X��ʾ�����洢����ͼƬ��������ѧϰ��
                System.out.print("x");
                Tools.writeImageToFile("E:/studyImg-"+t+".bmp", checkCode[t]);
            }
        }
    }
}
