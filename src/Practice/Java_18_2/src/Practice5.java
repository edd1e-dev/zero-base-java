package Practice.Java_18_2.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice5 {
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int idx = 0;
        int upCount = 1;
        int downCount = 0;
        int peak = 0;
        int result = 1;

        while (idx < ratings.length - 1) {
            if (ratings[idx] < ratings[idx + 1]) {
                upCount++;
                downCount = 0;
                peak = upCount;
                result = result + upCount;
            } else if (ratings[idx] == ratings[idx + 1]) {
                upCount = 1;
                downCount = 0;
                peak = 0;
                result = result + 1;
            } else {
                upCount = 1;
                downCount++;
                result = result + downCount;

                if (peak <= downCount) {
                    result = result + 1;
                }
            }
            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
