package CodingTest.Week1;

public class Q3 {
    public static int solution(int N) {
        // f(1) = 1
        // f(2) = 2

        int a = 1, b = 2;

        if (N == 1) return a;

        for (int i = 3; i <= N; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static int solution_recursive(int N) {
        if (N <= 2) { // 탈출 조건
            return N;
        }

        return solution_recursive(N - 1) + solution_recursive(N - 2); // 반복 조건
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution_recursive(4));
    }
}
