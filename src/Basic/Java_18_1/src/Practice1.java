package Practice.Java_18_1.src;

public class Practice1 {
    public static void solution(int num) {
        int val = num, res = 0;
        while (val > 0 || val < 0) {
            res *= 10;
            res += val % 10;
            val /= 10;
        }
        if (val < 0) res *= -1;
        System.out.println(res);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
