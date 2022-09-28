package Basic.Java_18_3.src;

import java.util.Arrays;

public class Practice1 {
    public static void solution(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx == 0 || nums[idx - 1] < nums[i]) {
                /*
                            idx     i
                1 cycle:    0       0
                2 cycle:    1       1
                3 cycle:    1       2
                3 cycle:    2       3
                 */
                nums[idx] = nums[i];
                idx++;
                System.out.println(Arrays.toString(nums));
            }
        }

        for (int i = 0; i < idx;) {
            System.out.print(nums[i]);
            if (++i < idx) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
