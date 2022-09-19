package Practice.HW.Q5;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: 첫 주가 1일부터 시작 시 발생하는 오류 해결하였습니다. 예시) 2022년 05월
 */
public class Q5 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");

        Scanner sc = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n\n[%s년 %s월]", year >= 10 ? year : "0" + year, month >= 10 ? month : "0" + month));
        sb.append("\n일\t월\t화\t수\t목\t금\t토");

        LocalDate localDate = LocalDate.of(year, month, 1);
        int startDay = localDate.get(ChronoField.DAY_OF_WEEK) == 7 ? 0 : localDate.get(ChronoField.DAY_OF_WEEK);
        int lastDay = localDate.lengthOfMonth();
        int day = 1;

        for (int idx = 0; idx <= startDay + lastDay; ++idx) {
            if (idx <= startDay) {
                sb.append("  \t");
            } else {
                sb.append(String.format("%02d\t", day++));
            }

            if (idx % 7 == 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
