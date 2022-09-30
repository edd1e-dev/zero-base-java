package CodingTest.Week2;

import java.util.Arrays;

public class Q1 {
    public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] + 1 != numbers[i + 1]) {
                return numbers[i] + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {9, 4, 2, 3, 7, 5}));
    }
}
