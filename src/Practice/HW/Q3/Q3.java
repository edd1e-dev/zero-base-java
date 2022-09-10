package Practice.HW.Q3;

import java.util.Scanner;

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

        int pay = 0;

        if (age < 3) { // 나이 체크
            pay = 4000;
        } else if (age >= 3 && age < 13) {
            pay = 8000;
        } else {
            pay = 10000;
        }

        if (nationalMerit == 'y' || welfareCard == 'y') { // 국가유공자, 복지카드 체크
            pay = Math.min(8000, pay);
        }

        if (entranceTime > 17) { // 입장시간 체크
            pay = Math.min(4000, pay);
        }

        System.out.printf("입장료: %d\n", pay);
    }
}
