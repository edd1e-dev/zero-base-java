package Practice.HW.Q2;

import java.util.Scanner;

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

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.\n", pay, cashBack);
    }
}
