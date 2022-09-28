package Basic.Java_18_3.src;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public static List<Integer> solution(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        // 성립하려면 값 전체가 배열 요소 사이즈보다 작아야함

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 배열 사이즈에 넘지 않게 값을 기준으로 절대값 순번을 구해옴

            if (nums[index] < 0) { // 마킹된 값이 -일 경우 추가
                answer.add(Math.abs(index + 1));
            }

            nums[index] = nums[index] * -1; // 배열에 값을 기준으로 마킹
            // System.out.println(Arrays.toString(nums));
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
