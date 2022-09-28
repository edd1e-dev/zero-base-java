package CodingTest.Week1;

public class Q4 {
    public static int solution(int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    public static int recursion(int count, int n, int i, int j) {
        if (n == 2) { // 재귀 종료
            if (i == 0 && j == 0) { // 좌측 상단
                return count + 2;
            } else if (i == 1 && j == 0) { // 우측 상단
                return count + 1;
            } else if (i == 0 && j == 1) { // 좌측 하단
                return count + 3;
            } else { // 우측 하단
                return count + 4;
            }
        }

        int m = n / 2;
        // 재귀 호출
        if (i < m & j >= m) { // 우측 상단
            System.out.println("1: " + i + ", " + j);
            return recursion(count, m, i, j - m);
        } else if (i < m & j < m) { // 좌측 상단
            System.out.println("2: " + i + ", " + j);
            count += m * m;
            return recursion(count, m, i, j);
        } else if (i >= m & j < m) { // 좌측 하단
            System.out.println("3: " + i + ", " + j);
            count += m * m * 2;
            return recursion(count, m, i - m, j);
        } else { // 우측 하단
            System.out.println("4: " + i + ", " + j);
            count += m * m * 3;
            return recursion(count, m, i - m, j - m);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 1, 3));
    }
}
