package CodingTest.Week1;

import java.util.Arrays;

public class Q1 {
    public static int solution(int n) {
        int intArray[] = new int[n];

        // 0, 1 제외
        for (int i = 2; i < n; i++) {
            intArray[i] = 1;
        }

        // n의 제곱근까지
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (intArray[i] == 0) continue;

            int num = i * 2;
            while (num < n) {
                intArray[num] = 0;
                num += i;
            }
        }

        return Arrays.stream(intArray).sum();
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
    }
}
