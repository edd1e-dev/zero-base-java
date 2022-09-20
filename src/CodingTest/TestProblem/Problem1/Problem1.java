package CodingTest.TestProblem.Problem1;

public class Problem1 {
    public static int solution(int n, int m) {

        int answer = 0;

        for (int i = n; i <= m; i++) {
            String value = String.valueOf(i);
            int startIdx = 0;
            int endIdx = value.length() - 1;
            while (true) {
                if (value.charAt(startIdx) == value.charAt(endIdx)) {
                    startIdx++;
                    endIdx--;
                    if (startIdx >= endIdx) {
                        answer++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 100)); // 18
        System.out.println(solution(100, 300)); // 20
    }
}
