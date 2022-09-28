package Math.Math_07.src;// Practice
// 제곱과 제곱근을 Math 없이 구현하기

public class Practice {
    public static double pow(int n, int m) {
        double result = 1;
        boolean isMinus = false;

        if (m == 0) {
            // 어떤 수의 0 제곱은 1
            return 1;
        } else if (m < 0) {
            m *= -1;
            isMinus = true;
        }

        for (int i = 0; i < m; i++) {
            result *= n;
        }

        return isMinus ? 1 / result : result;
    }

    public static double sqrt(int n) {
        double result = 1;

        for (int i = 0; i < 10; i++) { // 바빌로니아 법을 이용한 제곱근 구하기
            result = (result + (n / result)) / 2;
        }

        return result;
    }

    public static void main(String[] args) {

//      Test code
        System.out.println("== Math pow ==");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println("== My pow ==");
        System.out.println(pow(2, 3));
        System.out.println(pow(2, -3));
        System.out.println(pow(-2, -3));

        System.out.println("== Math sqrt ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));

        System.out.println("== My sqrt ==");
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));

    }
}
