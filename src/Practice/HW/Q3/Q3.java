package Practice.HW.Q3;

import java.util.Scanner;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: 나이가 3세 미만일 경우도 입장시간, 국가유공자, 복지카드를 받도록 형식을 일치시켰습니다.
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println("[입장권 계산]");

        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int entranceTime = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        char nationalMerit = sc.next().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        char welfareCard = sc.next().charAt(0);

        int pay = 10000;
        boolean isFinish = false;

        if (age < 3) {
            pay = 0;
            isFinish = true;
        } else if (age >= 3 && age < 13) { // 나이 체크
            pay = 4000;
        }

        if (isFinish == false) {
            if (entranceTime > 17) { // 입장시간 체크
                pay = Math.min(4000, pay);
            }

            if (nationalMerit == 'y' || welfareCard == 'y') { // 국가유공자, 복지카드 체크
                pay = Math.min(8000, pay);
            }
        }

        System.out.printf("입장료: %d\n", pay);
    }
}
