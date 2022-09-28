package Remind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    public static int[] solution(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                answer.add(nums[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {4, 3, 2, 7, 8, 2, 3, 1}))); // 2, 3
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 2}))); // 1
        System.out.println(Arrays.toString(solution(new int[] {1, 3, 1, 3, 5, 5}))); // 1, 3, 5
    }
}