package org.h2o3.checkcode.test;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: hexor
 * Date: 2015-09-10
 * Time: 9:32
 * ���58����վ�Ĳ���
 * ��֤�뱳��ɫ :r:238 g:238 b:238
 * ����0��r:138 g:75 b:0
 * ����1��r:217 g:0 b:0
 * ����2��r:199 g:37 b:0
 * ����3��r:2 g:109 b:164
 * ����4��r:162 g:88 b:0
 * ����5��r:0 g:62 b:221
 * ����6��r:203 g:68 b:2
 * ����7��r:162 g:0 b:99
 * ����8��r:5 g:164 b:69
 * ����9��r:0 g:103 b:230
 */
public class My58Test {
    public static String vB="238238238";//����ɫ
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
    public static String vcodes[]={v0,v1,v2,v3,v4,v5,v6,v7,v8,v9};//��֤����ɵ�����
    public static void main(String[] args) {
        BufferedImage image = Tools.getImage("58QingRen/getcode" +".bmp");
        System.out.println(String.valueOf(getCode(image)));
    }

    /**
     * �����֤��
     * @param image
     * @return
     */
    public static  char[] getCode(BufferedImage image){
        if (image == null) {
            return null;
        }
        BufferedImage[] checkCode=Tools.getCheckCodes(image);//����֤��ֽ�Ϊ�ĸ�Сͼ�ֱ��Ӧ��֤����ĸ�����
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
     * ����ÿһ����֤����Ƭ�е���֤������
     * @param pixel
     * @return
     */
    public static char getRgb(int pixel){
        //��ȡR/G/B
        int r = (pixel >> 16) & 0xff;  //����16λ������0xff�������� 0xff��ʮ�����ƣ������ʮ������255
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;
        String rgb=String.valueOf(r)+String.valueOf(g)+String.valueOf(b);//ͼƬ���ص�ת��Ϊrgb�ַ���
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
