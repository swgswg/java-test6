package com;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  1.  统计一个字符串里面另一个字符串出现的次数，例如统计"monkey"在"I am monkey1024.monkey like banana.little monkey is smart."中出现的次数.
 * 2.  编写程序将 “jdk” 全部变为大写,然后截取子串”DK”
 * 3. "abcd23abcd34bcd"中，判断该字符串中是否包含"bc"子串。如果包含，求子串的所有出现位置。
 * 4. String s = "113@ ere qqq yyui" 请输出所有子串
 * 113
 * ere
 * qqq
 * yyui
 * 5. 字符串可以直接用加号进行拼接，但是也有几种不同的情况. 以下不同情况的拼接,分别创建了几个对象?
 * 1） String str = "hello" + "world";
 * 2）String str1 = "hello";   String str2 = str1 + "world";
 * 3）String str1 = new String("hello"); String str2 = str1 + "world";
 */

public class Main {

    public static void main(String[] args) {
        // 1
	    String str = "I am monkey1024.monkey like banana.little monkey is smart.";
	    int count = subStrCount(str, "monkey");
        System.out.println(count);

        // 2
        String sub = "jdk".toUpperCase().substring(1);
        System.out.println(sub);

        // 3
        Object[] objArr = subIndex("abcd23abcd34bcd", "bc");
        System.out.println(Arrays.toString(objArr));

        // 4
        Object[] substrArr = subSplit("113@ ere qqq yyui");
        System.out.println(Arrays.toString(substrArr));

        // 5
        String s = "hello" + "world";
        System.out.println("s的地址: " + System.identityHashCode(s));
        String s1 = "hello";
        System.out.println("s1的地址: " + System.identityHashCode(s1));
        String s2 = s1 + "world";
        System.out.println("s2的地址: " + System.identityHashCode(s2));
        String s3 = new String("hello");
        System.out.println("s3的地址: " + System.identityHashCode(s3));
        String s4 = s1 + "world";
        System.out.println("s4的地址: " + System.identityHashCode(s4));

        System.out.print("s2跟s是否相等:");
        System.out.println(s2==s ? true : false);
        System.out.print("s4跟s是否相等:");
        System.out.println(s4==s ? true : false);
        System.out.print("s4跟s2是否相等:");
        System.out.println(s4==s2 ? true : false);
    }


    /**
     * 统计一个字符串里面另一个字符串出现的次数
     * @param str
     * @param subStr
     * @return
     */
    public static int subStrCount(String str, String subStr){
        String[] newStr = str.split(subStr);
        return newStr.length - 1;
    }


    /**
     * "abcd23abcd34bcd"中，判断该字符串中是否包含"bc"子串。如果包含，求子串的所有出现位置。
     * @param str
     * @param subStr
     * @return
     */
    public static Object[] subIndex(String str, String subStr)
    {
        HashMap<Integer, Integer> index = new HashMap<>();
        if (str.contains(subStr)) {
            String[] newStr = str.split(subStr);
            int len = newStr.length;
            int subLen = subStr.length();
            int idx = 0;
            for(int i = 0; i < len-1; ++i) {
                idx += newStr[i].length();
                index.put(idx, idx);
                idx += subLen;
            }
        }
        return index.values().toArray();
    }


    /**
     * 4. String s = "113@ ere qqq yyui" 请输出所有子串
     * 113
     * ere
     * qqq
     * yyui
     * @param str
     * @return
     */
    public static Object[] subSplit(String str)
    {
        String newStr = str.replaceAll("[^\\w\\s]", "");
        return newStr.split(" ");
    }

}
