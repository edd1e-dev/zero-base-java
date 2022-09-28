package Remind;

public class Day1 {
    public static String solution(String input, String from, String to) {

        String temp = "";
        int index = 0;

        while (index != -1) {
            index = find(input, from);

            if (index != -1) {
                for (int i = 0; i < index; i++) { // temp에 Hello 까지 추가
                    temp += input.charAt(i);
                }

                temp += to; // 자바 추가

                for (int i = from.length() + index; i < input.length(); i++) {
                    temp += input.charAt(i);
                }

                input = temp;
                temp = "";
            }
        }

        return input;
    }

    private static int find(String input, String from) {
        boolean isFind = false;
        for (int i = 0; i < input.length(); i++) { // 6
            int index = 0;
            if (input.charAt(i) == from.charAt(0)) { // 첫 글자 비교
                while (index < from.length()) {
                    if (input.charAt(i + index) == from.charAt(index)) {
                        isFind = true;
                    } else {
                        isFind = false;
                        break;
                    }
                    index++;
                }
            }

            if (isFind) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String input = "Hello Java, Nice to meet you! Java is fun!";
        String from = "Java";
        String to = "자바";
        System.out.println(solution(input, from, to));

        input = "POP";
        from = "P";
        to = "W";
        System.out.println(solution(input, from, to));
    }
}
