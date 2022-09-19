package Practice.HW.Q2;

import java.util.Scanner;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: 페이백이 100단위가 아닐 시 내림을 하도록 구현하였습니다.
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");

        Scanner sc = new Scanner(System.in);
        final int CASH_BACK_LIMIT = 300;

        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int pay = sc.nextInt();

        int cashBack = (pay / 10) / 100 * 100;

        if(cashBack >= CASH_BACK_LIMIT) { // 페이백은 300원을 넘을 수 없음
            cashBack = CASH_BACK_LIMIT;
        }

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", pay, cashBack);
    }
}
