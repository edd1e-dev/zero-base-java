package CodingTest.TestProblem.Problem5;

public class Problem5 {
    public static int solution(int n, int a, int b) {
        int answer = 0;

        // n은 참가자 수
        // 1, 2번 대결 3, 4번 대결 순서
        // 이긴 사람 다음 라운드 진출
        // A와 B가 몇번 째 라운드에서 만나는지

        // 단 A와 B는 서로 붙게 되기 전까지 항상 이김

        // 첫 라운드 4번
        // 1~2, 3~4, 5~6, 7~8

        // 두 번째 라운드 2번
        // 1~4, 5~8

        // 3번째 라운드
        // 1~8

        while (true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if (a == b) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7)); // 3
    }
}
