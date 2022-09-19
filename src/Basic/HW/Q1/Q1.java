package Practice.HW.Q1;


/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: 기본적인 구구단 로직입니다. 좌측부터 낮은 단이 오도록 출력 형식을 일치시켰습니다.
 */
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
