package com.math.u001;

/**
 * 如果不使用 Java 语言自带的 BigInteger 类，我们还有什么方法来实现十进制到二进制的转换呢？（提示：可以使用二进制的移位和按位逻辑操作来实现。）
 * 思路一：数字每次取模2，存储得到的余数，再向右移一位，直到为0。最后再将得到的余数翻转，就得到二进制了。
 * 思路二：利用最低位的数字与1进行与操作，存储得到的结果，再向右移一位，直到为0。最后再将得到的余数翻转，就得到二进制了。
 * 思路三：不进行右移，而是用Max数字（比如8位就是 11111111），不断进行右移，这样就不需要多一步进行翻转了。
 */
public class homeWork {

    /**
     * 思路二的实现方式
     * 注意负数的情形也要兼容，大概是利用负数=反码+1 的原理，要注意位数的限定。比如这里简单点就是32位。
     *
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary(int decimalSource) {
        StringBuilder binary = new StringBuilder();
        int optNum = decimalSource;

        //如果是负数，先统一转化成正数处理
        if (decimalSource < 0) {
//            optNum = -optNum;
            optNum = ((optNum * -1) ^ (Integer.MAX_VALUE)) + 1;
        }
        while (optNum != 0) {
            binary.append(optNum & 1);
            optNum = optNum >> 1;
        }
        //先翻转
        binary.reverse();

        //限定32位补足
        while (binary.length() < 32) {
            //如果是负数，前面补1，正数，则是前面补0
            if (decimalSource < 0) {
                binary.insert(0, 1);
            } else {
                binary.insert(0, 0);
            }
        }

        return binary.toString();
    }


    /**
     * 前面那种方法是比较符合人的思维，从最低位开始，但也会绕一个圈子，下面的实现是从最高位开始，更简洁一点
     * 这里的负数处理跟上面的也有点不同，这里是将有符号数负数转为一个无符号数对应的正数进行处理
     *
     * @param value
     * @return
     */
    public static String decimal2Binary(int value) {
        StringBuilder result = new StringBuilder();
        if (value < 0) {
            value = ((value * -1) ^ (Integer.MAX_VALUE)) + 1;
        }
        for (int i = 31; i >= 0; i--) {
            if ((value & (1 << i)) > 0) {
                result.append(1);
            } else {
                result.append(0);
            }
        }
        return result.toString();
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

        System.out.println(String.format("%d转为二进制后的结果是：%s", a, decimal2Binary(a)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", b, decimal2Binary(b)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", c, decimal2Binary(c)));
        System.out.println(String.format("%d转为二进制后的结果是：%s", d, decimal2Binary(d)));
    }
}
