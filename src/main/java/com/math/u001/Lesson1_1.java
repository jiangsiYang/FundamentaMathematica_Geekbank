package com.math.u001;

import java.math.BigInteger;

public class Lesson1_1 {
    /**
     * 十进制转换成二进制
     *
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource)); //转换成BigInteger类型，默认是十进制
        return bi.toString(2); //参数2指定的是转化成二进制
    }

    /**
     * 只能用BigInteger,Integer转换二进制无效
     *
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary2(int decimalSource) {
        Integer bi = new Integer(String.valueOf(decimalSource)); //转换成BigInteger类型，默认是十进制
        return bi.toString(2); //参数2指定的是转化成二进制
    }

    /**
     * 二进制转换成十进制
     *
     * @param binarySource
     * @return
     */
    private static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2); //转换为BigInteger类型，参数2指定的是二进制
        return Integer.parseInt(bi.toString()); //默认转换成十进制
    }

    public static void main(String[] args) {
        int a = 53;
        String b = "110101";
        System.out.println(String.format("数字%d的二进制是%s", a, Lesson1_1.decimalToBinary(a))); //获取十进制数53的二进制数
        System.out.println(String.format("数字%s的十进制是%d", b, Lesson1_1.binaryToDecimal(b))); //获取二进制数110101的十进制数
        System.out.println(String.format("数字%s的二进制是%s", a, Lesson1_1.decimalToBinary2(a))); //获取十进制数53的二进制数
    }

}