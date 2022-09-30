package Remind;

public class Day6 {
    public static int solution(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;

        while (left < right) { // 서로 만나기 전까지
            if (height[left] < height[right]) { // 왼쪽이 높이가 작을 경우
                if (height[left] >= leftMax) { // 최대 보다 클 경우
                    leftMax = Math.max(leftMax, height[left]); // 최댓값 갱신
                } else {
                    sum += leftMax - height[left]; // 최대보다 작을 경우
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = Math.max(rightMax, height[right]);
                } else {
                    sum += rightMax - height[right];
                }

                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(solution(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}
