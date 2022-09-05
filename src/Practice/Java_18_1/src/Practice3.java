package Practice.Java_18_1.src;

import java.util.Arrays;

public class Practice3 {
    public static String solution(char[] str, char[] find, char[] to) {
        int idx = 0;
        String temp = "";
        char[] copy = str.clone();

        while (idx != -1) {
            idx = findIndex(copy, find);

            if (idx != -1) {
                for (int i = 0; i < idx; i++) {
                    temp += copy[i];
                }

                for (int i = 0; i < to.length; i++) {
                    temp += to[i];
                }

                for (int i = idx + find.length; i < copy.length; i++) {
                    temp += copy[i];
                }

                copy = temp.toCharArray();
                temp = "";
            }
        }

        return new String(copy);
    }

    public static int findIndex(char[] str, char[] find) {
        int idx = -1;
        boolean isMatch = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == find[0] && str.length - i >= find.length) {
                isMatch = true;
                for (int j = 1; j < find.length; j++) {
                    if (str[i + j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}
