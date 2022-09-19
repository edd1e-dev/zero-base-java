package Practice.AdditionalHW;

import java.util.Scanner;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: Nothing
 */
public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("<<<<[메뉴 선택]>>>>");
            System.out.println("1. 회원 관리");
            System.out.println("2. 과목 관리");
            System.out.println("3. 수강 관리");
            System.out.println("4. 결제 관리");
            System.out.println("5. 종료");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("회원 관리 메뉴를 선택했습니다.");
                    break;
                case 2:
                    System.out.println("과목 관리 메뉴를 선택했습니다.");
                    break;
                case 3:
                    System.out.println("수강 관리 메뉴를 선택했습니다.");
                    break;
                case 4:
                    System.out.println("결제 관리 메뉴를 선택했습니다.");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("입력값이 정확하지 않습니다.");
                    break;
            }
        }
    }
}
