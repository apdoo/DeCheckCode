package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-23
 * Time: 上午12:18
 * To change this template use File | Settings | File Templates.
 */
public class Mytest {
    public static void main(String[] args) {
//        for(int i=1;i<=9;i++){
////            handler("MyPics/"+i,".png");
//            handlerMyF("MyPics/"+i,".png");
//
//        }
        //测试去除干扰
        handlerMyF("MyPics/2" ,".png");

        //测试变色
//        BufferedImage image = Tools.getImage("MyPics/2" +".png");
//        Filter.myBlackAndWhiteFilter(image);
//        Tools.writeImageToFile("MyPics/2"+"-d"+".png", image);
    }
    public static void handlerMyF(String name,String suffix){
        BufferedImage image = Tools.getImage(name +suffix);
        Filter.blackAndWhiteFilter(image);   //黑白像素转换
        Filter.myDoFilter(image);
        Tools.writeImageToFile(name+"----c"+suffix, image);
    }
    public static void handler(String name,String suffix){
        BufferedImage image = Tools.getImage(name +suffix);

        Filter.blackAndWhiteFilter(image);
        Tools.writeImageToFile(name+"-a"+suffix, image);

        Filter.dotFilter(image);
        Tools.writeImageToFile(name+"-b"+suffix, image);
    }
}
