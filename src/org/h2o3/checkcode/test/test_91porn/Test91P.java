package org.h2o3.checkcode.test.test_91porn;

import org.h2o3.checkcode.test.Filter;
import org.h2o3.checkcode.test.Tools;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: hexor
 * Date: 2016-04-12
 * Time: 13:44
 */
public class Test91P {
    public static void main(String[] args) {
//        for(int i=1;i<=9;i++){
////            handler("MyPics/"+i,".png");
//            handlerMyF("MyPics/"+i,".png");
//
//        }
        //测试去除干扰
//        handlerMyF("91porn/a" ,".png");

        //测试变色
//        BufferedImage image = Tools.getImage("MyPics/2" +".png");
//        Filter.myBlackAndWhiteFilter(image);
//        Tools.writeImageToFile("MyPics/2"+"-d"+".png", image);


        for(int i=1;i<=8;i++){
            BufferedImage image = Tools.getImage("91porn/"+i+".png");
            BufferedImage new_image=Tools.subImageFor91P(image);
            Tools.writeImageToFile("E:/cachetmpdir/test_"+i+".bmp",new_image);
            BufferedImage checkCode[] = Tools.getCheckCodes(new_image);
            for(int t=0;t<4;t++){
                Tools.writeImageToFile("E:/cachetmpdir/checkCode-"+i+"-"+t+".bmp", checkCode[t]);
            }
        }

    }

    public static void handlerMyF(String name,String suffix){
        BufferedImage image = Tools.getImage(name +suffix);
        Filter.blackAndWhiteFilter(image);   //黑白像素转换
        Filter.myDoFilter(image);
        Tools.writeImageToFile(name+"----c"+suffix, image);
    }
}
