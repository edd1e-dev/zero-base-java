package Practice.HW.Q6;

import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        final int MAX_VOTE = 10000;
        final int CANDIDATE_COUNT = 4;

        while (true) {
            int[] ballotBox = new int[CANDIDATE_COUNT + 1];

            Map<Integer, String> candidateMap = new HashMap<>() {{
                int idx = 0;
                put(++idx, "이재명");
                put(++idx, "윤석열");
                put(++idx, "심상정");
                put(++idx, "안철수");
            }};

            int maxVoteCount = 0;

            for (int idx = 1; idx <= MAX_VOTE; ++idx) {
                int select = new Random().nextInt(CANDIDATE_COUNT) + 1;
                ballotBox[select]++;

                maxVoteCount = Math.max(maxVoteCount, ballotBox[select]);

                System.out.printf("[투표진행율]: %05.2f%%, %d명 투표 => %s\n", (double) idx / 100, idx, candidateMap.get(select));
                int candidateIndex = 1;

                for (var candidate : candidateMap.entrySet()) {
                    System.out.printf("[기호:%d] %s: %05.2f%%, (투표수: %d)\n", candidate.getKey(), candidate.getValue(), (double) ballotBox[candidateIndex] / 100, ballotBox[candidateIndex]);
                    ++candidateIndex;
                }
                System.out.print("\n");
            }

            if (checkDuplicate(ballotBox) == false) {
                int firstPlace = 0;
                for (int i = 1; i <= ballotBox.length; i++) {
                    if (ballotBox[i] == maxVoteCount) {
                        firstPlace = i;
                        break;
                    }
                }
                System.out.printf("[투표결과] 당선인: %s\n", candidateMap.get(firstPlace));
                break;
            } else {
                System.out.printf("[투표결과] 동률로 인해 다시 시도합니다.");
            }

        }
    }

    private static boolean checkDuplicate(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < i; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
