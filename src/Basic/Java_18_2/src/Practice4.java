package Basic.Java_18_2.src;

import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    public static String solution(int[] keyLog) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        StringBuffer loggedString = new StringBuffer();
        boolean isCapsLock = false;
        boolean isShift = false;
        boolean isInsert = false;
        int idx = 0;
        int cur = 0;

        while (idx < keyLog.length) {
            int key = keyLog[idx];
            if (key == BACK_SPACE) {
                if (loggedString.isEmpty()) {
                    idx++;
                    continue;
                }
                loggedString.delete(cur - 1, cur);
                if (cur > 0) cur--;
            } else if (key == SHIFT) {
                isShift = !isShift;
            } else if (key == CAPS_LOCK) {
                isCapsLock = !isCapsLock;
            } else if (key == SPACE_BAR) {
                loggedString.insert(cur, " ");
                cur++;
            } else if (key >= 97 && key <= 122) {
                int step = ('a' - 'A');
                if (isInsert) {
                    loggedString.delete(cur, cur + 1);
                }
                if ((isCapsLock && !isShift) || (!isCapsLock && isShift)) {
                    loggedString.insert(cur, (char) (keyLog[idx] - step));
                } else {
                    loggedString.insert(cur, (char) (keyLog[idx]));
                }
                isShift = false;
                cur++;
            } else if (key == KEY_LEFT) {
                if (cur > 0) cur--;
            } else if (key == KEY_RIGHT) {
                if (cur < loggedString.length()) cur++;
            } else if (key == INSERT) {
                isInsert = !isInsert;
            } else if (key == DELETE) {
                loggedString.delete(cur, cur + 1);
            } else if (key >= 48 && key <= 57) {
                Map<Integer, Character> specialKeys = new HashMap<>() {{
                    put(48, ')');
                    put(49, '!');
                    put(50, '@');
                    put(51, '#');
                    put(52, '$');
                    put(53, '%');
                    put(54, '^');
                    put(55, '&');
                    put(56, '*');
                    put(57, '(');
                }};
                if (isInsert) {
                    loggedString.delete(cur, cur + 1);
                }
                if (!isCapsLock && !isShift) {
                    loggedString.insert(cur, (char) (keyLog[idx]));
                } else {
                    loggedString.insert(cur, specialKeys.get(key));
                }
                isShift = false;
                cur++;
            }

            idx++;
        }

        return loggedString.toString();
    }

    public static void main(String[] args) {
        // Test code
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97};
        System.out.println(solution(keyLog));

        keyLog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keyLog));
    }
}
