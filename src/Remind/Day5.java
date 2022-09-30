package Remind;

public class Day5 {
    public static int solution(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxWidth = 0;

        while (leftIndex < rightIndex) {
            maxWidth = Math.max(maxWidth, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
        System.out.println(solution(new int[] { 5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 })); // 26
    }
}
