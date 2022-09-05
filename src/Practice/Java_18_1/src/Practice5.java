package Practice.Java_18_1.src;

public class Practice5 {
    public static int solution(int[] height) {
        int left = 0; // 첫번째
        int right = height.length - 1; // 마지막
        int maxWidth = 0;

        while (left < right) {
            int x = (right - left);
            int y = height[left] < height [right] ? height[left] : height[right];
            int curWidth = x * y;
            maxWidth = maxWidth > curWidth ? maxWidth : curWidth;

            // System.out.println("left: " + left + "(" + height[left] +  ")" + " / right: " + right + "(" + height[right] +  ")" + " / curWidth: " + curWidth);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
