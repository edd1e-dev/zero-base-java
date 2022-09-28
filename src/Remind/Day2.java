package Remind;

public class Day2 {

    public static String solution(int[] arr) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int LEFT = 37;
        final int RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;
        char[] specialLetter = { ')', '!', '@', '#', '$', '%', '^', '&', '*', '(' };

        StringBuilder result = new StringBuilder();
        int cursor = result.length();

        for (int i = 0; i < arr.length; i++) { // 한 요소씩 탐색
            int key = arr[i]; // 요소

            if (key == BACK_SPACE) {
                result.deleteCharAt(cursor - 1);
                cursor -= 1;
            } else if (key == SHIFT) { // Shift는 16
                isShift = !isShift;
            } else if (key == CAPS_LOCK) {
                isCapsLock = !isCapsLock;
            } else if (key == SPACE_BAR) {
                result.insert(cursor, (char) key);
                cursor += 1;
            } else if (key == LEFT) {
                if (cursor > 0) cursor -= 1;
            } else if (key == RIGHT) {
                if (cursor < result.length() - 1) cursor += 1;
            } else if (key == INSERT) {
                isInsert = !isInsert;
                if (cursor > 0) cursor -= 1;
            } else if (key == DELETE) {
                result.deleteCharAt(cursor);
            } else if (key >= 'a' && key <= 'z') { // 97 ~ 122
                if (isInsert) {
                    result.deleteCharAt(cursor);
                }

                if (isShift && !isCapsLock) {
                    result.insert(cursor, (char) (key - ('a' - 'A')));
                } else if (!isShift && isCapsLock) {
                    result.insert(cursor, (char) (key - ('a' - 'A')));
                } else {
                    result.insert(cursor, (char) key);
                }

                isShift = false;
                cursor += 1;
            } else if (key >= '0' && key <= '9') {
                if (isInsert) {
                    result.deleteCharAt(cursor);
                }

                if (isShift) {
                    result.insert(cursor, specialLetter[key - '0']);
                } else {
                    result.insert(cursor, (char) key);
                }

                isShift = false;
                cursor += 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104 }));
        System.out.println(solution(new int[] { 20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97 }));
        System.out.println(solution(new int[] { 49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53 }));
        System.out.println(solution(new int[] { 20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51 }));
    }
}
