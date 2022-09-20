package Basic.Java_18_3.src;

public class Practice1 {
    public static void solution(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (idx == 0 || num > nums[idx - 1]) {
                nums[idx++] = num;
            }
        }

        for (int i = 0; i < idx;) {
            System.out.print(nums[i]);
            if (++i < idx) {
                System.out.print(",");
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
