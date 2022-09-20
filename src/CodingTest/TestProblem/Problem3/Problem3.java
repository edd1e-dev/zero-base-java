package CodingTest.TestProblem.Problem3;

public class Problem3 {
    public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer = answer + (n % 10);
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(123)); // 6
        System.out.println(solution(987)); // 24
    }
}
