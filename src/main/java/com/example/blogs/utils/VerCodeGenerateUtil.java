package com.example.blogs.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 言覃
 * @Date: 2022/12/13/23:47
 * @Description: 生成验证码工具类
 */
public class VerCodeGenerateUtil {
    /**
     * 验证码包含的字段，可自己设置
     */
    private static final String SYMBOLS = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new SecureRandom();

    /**
     * 生成 6 位随机字符串
     * @return 6位随机字符
     */
    public static String generateVerCode() {
        //	如果是六位，就生成大小为 6 的数组
        char[] numbers = new char[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(numbers);
    }
}
