package Remind;

import java.util.HashMap;
import java.util.Map;

public class Day4 {
    public static int solution(String str) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] chars = str.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            int left = map.get(chars[i]);
            int right = map.get(chars[i + 1]);

            if (left < right) {
                result -= left;
                System.out.print("-" + left + " ");
            } else {
                result += left;
                System.out.print(left + " ");
            }
        }

        result += map.get(chars[chars.length - 1]);

        return result;
    }

    public static void main(String[] args) {
        // 앞자리가 작으면 감소 크면 덧셈
        System.out.println(solution("III")); // 1+1+1 3
        System.out.println(solution("IV")); // 1-5 4
        System.out.println(solution("VI")); // 5+1 6
        System.out.println(solution("XIII")); // 10+1+1+1 13
        System.out.println(solution("XXVI")); // 10+10+5+1 26
        System.out.println(solution("MCMXCIV")); // 1994
    }
}
