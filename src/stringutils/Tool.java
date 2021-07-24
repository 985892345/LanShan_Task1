package stringutils;

import java.util.Arrays;
import java.util.Locale;

public class Tool {

    public static void main(String[] args) {
        String s = "acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";
        String[] ss = s.split(",");
        for (String a : ss) {
            boolean isAllNumber = isNumber(a);
            boolean isAllLetters = isLetters(a);
            System.out.println(a);

            if (isAllNumber) {
                System.out.println("是否全是数字：true       升序排序后：" + toIntArrayAndSort(a));
            }else {
                System.out.println("是否全是数字：false");
            }

            if (isAllLetters) {
                System.out.println("是否全是字母：true       全转换为大写：" + toUpperCase(a) + "       升序排序后：" + toStringArrayAndSort(a));
            }else {
                System.out.println("是否全是字母：false");
            }

            System.out.println("是否全是大写字母：" + isCapital(a));
            System.out.println("是否全是小写字母：" + isLowercase(a));
            System.out.println();
        }
    }

    /**
     * 判断字符串是否全是数字
     */
    public static boolean isNumber(String s) {
        return s.matches("[0-9]+");
    }

    /**
     * 判断字符串是否全是大写字母
     */
    public static boolean isCapital(String s) {
        return s.matches("[A-Z]+");
    }

    /**
     * 判断字符串是否全是小写字母
     */
    public static boolean isLowercase(String s) {
        return s.matches("[a-z]+");
    }

    /**
     * 判断字符串是否全是字母
     */
    public static boolean isLetters(String s) {
        return s.matches("[a-zA-Z]+");
    }

    /**
     * 将字符串全转换为大写字母
     */
    public static String toUpperCase(String s) {
        return s.toUpperCase(Locale.ROOT);
    }

    public static String toIntArrayAndSort(String s) {
        String[] a = s.split("");
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(b);
        return Arrays.toString(b);
    }

    public static String toStringArrayAndSort(String s) {
        String[] a = s.split("");
        Arrays.sort(a);
        return Arrays.toString(a);
    }
}
