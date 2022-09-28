package Math.Math_06.src;// Practice2
// 최대공약수를 재귀함수로 구현하시오.

public class Practice2 {
    public static int gcd(int n, int m) {
        System.out.println(n + " " + m);
        // 종료 조건
        if (n % m == 0) {
            return m;
        }

        return gcd(m, n % m);
    }

    public static void main(String[] args) {
//      Test code
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
    }
}
