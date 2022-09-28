package CodingTest.Week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static int solution(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size(); // 6
        int m = 4;

        int u = 1;
        int d = 1;

        // nC4
        for (int i = 0; i < m; i++) {
            u = u * (n - i);
            d = d * (i + 1);
        }

        return (int) (u / d);
    }

    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바",
                "스쿨", "자바", "베이스", "베이스", "백엔드", "화이팅"};
        System.out.println(solution(names));
    }
}
