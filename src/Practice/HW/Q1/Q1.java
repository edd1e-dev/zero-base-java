package Practice.HW.Q1;

public class Q1 {
    public static void main(String[] args) {
        final int MAGIC_NUMBER = 9;
        System.out.println("[구구단 출력]");

        for (int i = 1; i <= MAGIC_NUMBER; i++) {
            for (int j = 1; j <= MAGIC_NUMBER; j++) {
                System.out.print(String.format("%02d x %02d = %02d\t", j, i, i*j));
            }
            System.out.println();
        }
    }
}
