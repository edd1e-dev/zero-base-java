package CodingTest.TestProblem.Problem4;

public class Problem4 {
    static boolean canMove(int x, int y) {
        if (x >= 0 && x <= 10 && y >= 0 && y <= 10) {
            return true;
        }
        return false;
    }

    public static int solution(String dirs) {
        int answer = 0;
        int[][][][] path = new int[11][11][11][11];
        int xPos = 5, yPos = 5, n_xPos = 0, n_yPos = 0;

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'L') {
                n_xPos = xPos - 1;
                n_yPos = yPos;
            } else if (dirs.charAt(i) == 'R') {
                n_xPos = xPos + 1;
                n_yPos = yPos;
            } else if (dirs.charAt(i) == 'U') {
                n_xPos = xPos;
                n_yPos = yPos + 1;
            } else if (dirs.charAt(i) == 'D') {
                n_xPos = xPos;
                n_yPos = yPos - 1;
            }

            if (canMove(n_xPos, n_yPos)) {
                if (path[xPos][yPos][n_xPos][n_yPos] == 0) {
                    path[xPos][yPos][n_xPos][n_yPos] = 1; // 이동할 방향 기록
                    path[n_xPos][n_yPos][xPos][yPos] = 1; // 반대 방향도 기록
                    answer++;
                }
                xPos = n_xPos;
                yPos = n_yPos;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU")); // 7
        System.out.println(solution("LULLLLLLU")); // 7
    }
}
