package Practice.HW.Q7;

import java.util.*;

/**
 * 제로베이스 백엔드 5기 강상우(edd1e-dev.git)
 * comment: Nothing
 */
public class Q7 {
    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]\n");

        int lotteryCount;

        while (true) {
            System.out.printf("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
            Scanner sc = new Scanner(System.in);
            lotteryCount = sc.nextInt();

            if (lotteryCount < 1 || lotteryCount > 10) {
                System.out.println("숫자 1 ~ 10 사이만 입력이 가능합니다.");
            } else {
                break;
            }
        }

        Map<Character, String> lotteryMap = new HashMap<>();

        for (int i = 0; i < lotteryCount; ++i) {
            String lottery = getNewLottery();
            lotteryMap.put((char) (i + 'A'), lottery);
            System.out.printf("%c\t%s\n", (char) (i + 'A'), lottery);
        }

        System.out.println("\n[로또 발표]");
        String lotteryResult = getNewLottery();
        System.out.printf("\t%s\n\n", lotteryResult);

        System.out.println("[내 로또 결과]");

        for (Map.Entry<Character, String> lottery : lotteryMap.entrySet()) {
            String[] lotteryNumbers = lottery.getValue().split(",");
            int match = findMatch(lotteryNumbers, lotteryResult.split(","));
            System.out.printf("%c\t%s => %d개 일치\n", lottery.getKey(), lottery.getValue(), match);
        }
    }

    private static String getNewLottery() {
        final int RANDOM_COUNT = 6;
        List<Integer> lotteryList = new ArrayList<>();

        for (int j = 0; j < RANDOM_COUNT; ++j) {
            int random;

            while (true) {
                random = new Random().nextInt(45) + 1;

                if (lotteryList.contains(random) == false) {
                    break;
                }
            }

            lotteryList.add(random);
        }

        String lottery = lotteryList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");

        StringBuilder sb = new StringBuilder();
        String[] lotteries = lottery.split(",");

        getCommaAppliedString(sb, lotteries);

        return sb.toString();
    }

    private static void getCommaAppliedString(StringBuilder sb, String[] lotteries) {
        for (int idx = 0; idx < lotteries.length;) {
            sb.append(String.format("%02d", Integer.parseInt(lotteries[idx])));
            if (++idx < lotteries.length) {
                sb.append(",");
            }
        }
    }

    private static int findMatch(String[] lotteryNumber, String[] lotteryResult) {
        int match = 0;

        for (int i = 0; i < lotteryNumber.length; ++i) {
            for (int j = 0; j < lotteryResult.length; ++j) {
                if (lotteryNumber[i].equals(lotteryResult[j])) {
                    match++;
                }
            }
        }

        return match;
    }
}
