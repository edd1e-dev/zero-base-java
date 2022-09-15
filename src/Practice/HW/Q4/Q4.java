package Practice.HW.Q4;

import java.util.Random;
import java.util.Scanner;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: JDK 9+ 부터는 StringConcatFactory가 StringBuilder로서 처리해주지만 이하 버전의 호환성을 위해 StringBuilder를 직접 사용하였습니다.
 */
public class Q4 {
    public static void main(String[] args) {
        final int NINTEEN_CENTURY_MALE = 1,
                NINTEEN_CENTURY_FEMALE = 2,
                TWENTY_CENTURY_MALE = 3,
                TWENTY_CENTURY_FEMALE = 4;
        final int RANDOM_COUNT = 6;

        System.out.println("[주민등록번호 계산]");

        Scanner sc = new Scanner(System.in);
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int birthYear = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        int birthMonth = sc.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        int birthDay = sc.nextInt();
        System.out.print("성별을 입력해 주세요(m/f):");
        char gender = sc.next().charAt(0);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", birthYear >= 2000 ? birthYear - 2000 : birthYear - 1900)); // 생년
        sb.append(String.format("%02d", birthMonth)); // 생월
        sb.append(String.format("%02d", birthDay)); // 생일

        sb.append("-");

        if (birthYear >= 2000) { // 성별
            sb.append(gender == 'm' ? TWENTY_CENTURY_MALE : TWENTY_CENTURY_FEMALE);
        } else {
            sb.append(gender == 'm' ? NINTEEN_CENTURY_MALE : NINTEEN_CENTURY_FEMALE);
        }

        for (int idx = 0; idx < RANDOM_COUNT; ++idx) {
            sb.append(new Random().nextInt(9));
        }

        System.out.println(sb);
    }
}
