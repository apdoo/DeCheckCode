package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: hexor
 * Date: 2015-09-10
 * Time: 9:32
 * 针对58情人站的测试
 * 验证码背景色 :r:238 g:238 b:238
 * 数字0：r:138 g:75 b:0
 * 数字1：r:217 g:0 b:0
 * 数字2：r:199 g:37 b:0
 * 数字3：r:2 g:109 b:164
 * 数字4：r:162 g:88 b:0
 * 数字5：r:0 g:62 b:221
 * 数字6：r:203 g:68 b:2
 * 数字7：r:162 g:0 b:99
 * 数字8：r:5 g:164 b:69
 * 数字9：r:0 g:103 b:230
 */
public class My58Test {
    public static String vB="238238238";//背景色
    public static String v0="138750";
    public static String v1="21700";
    public static String v2="199370";
    public static String v3="2109164";
    public static String v4="162880";
    public static String v5="062221";
    public static String v6="203682";
    public static String v7="162099";
    public static String v8="516469";
    public static String v9="0103230";
    public static String vcodes[]={v0,v1,v2,v3,v4,v5,v6,v7,v8,v9};//验证码组成的数组
    public static void main(String[] args) {
        BufferedImage image = Tools.getImage("58QingRen/getcode" +".bmp");
        System.out.println(String.valueOf(getCode(image)));
    }

    /**
     * 获得验证码
     * @param image
     * @return
     */
    public static  char[] getCode(BufferedImage image){
        if (image == null) {
            return null;
        }
        BufferedImage[] checkCode=Tools.getCheckCodes(image);//将验证码分解为四个小图分别对应验证码的四个数字
        char []result={'-','-','-','-'};
        for(int i=0;i<checkCode.length;i++){
            for (int j = 0; j < checkCode[i].getWidth(); j++) {
                if(getRgb(checkCode[i].getRGB(j,0))!='-'){
                   result[i]= getRgb(checkCode[i].getRGB(j,0));
                    break;
                }
            }
        }
        return result;
    }

    /***
     * 解析每一个验证码碎片中的验证码数字
     * @param pixel
     * @return
     */
    public static char getRgb(int pixel){
        //获取R/G/B
        int r = (pixel >> 16) & 0xff;  //右移16位并且与0xff做与运算 0xff是十六进制，换算成十进制是255
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;
        String rgb=String.valueOf(r)+String.valueOf(g)+String.valueOf(b);//图片像素点转换为rgb字符串
        String result = "";
        for(int i=0;i<vcodes.length;i++){
            if(vcodes[i].equals(rgb)){
                result=String.valueOf(i);
                char []chs=result.toCharArray();
                return chs[0];
            }
        }
        return '-';
    }
}
