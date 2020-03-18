package com.math.u001;

/**
 * 如果不使用 Java 语言自带的 BigInteger 类，我们还有什么方法来实现十进制到二进制的转换呢？（提示：可以使用二进制的移位和按位逻辑操作来实现。）
 * 思路一：数字每次取模2，存储得到的余数，再向右移一位，直到为0。最后再将得到的余数翻转，就得到二进制了。
 * 思路二：利用最低位的数字与1进行与操作，存储得到的结果，再向右移一位，直到为0。最后再将得到的余数翻转，就得到二进制了。
 */
public class homeWork {

    /**
     * 思路二的实现方式
     * 注意负数的情形也要兼容
     *
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary(int decimalSource) {
        StringBuilder binary = new StringBuilder();
        while (decimalSource > 0) {
            binary.append(decimalSource & 1);
            decimalSource = decimalSource >> 1;
        }
        return binary.reverse().toString();
    }

    public static void main(String args[]) {
        int a = 4;
        int b = 10;
        int c = 16;
        int d = -2;
        System.out.println(String.format("%d转为二进制后的结果是：%s", a, decimalToBinary(a)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", b, decimalToBinary(b)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", c, decimalToBinary(c)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", d, decimalToBinary(d)));
    }
}
