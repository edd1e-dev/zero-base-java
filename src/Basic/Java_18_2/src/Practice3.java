package Practice.Java_18_2.src;

public class Practice3 {
    public static String solution(String input, String cmd) {
        StringBuffer sb = new StringBuffer(input);
        cmd = cmd.replaceAll(" ", "");
        int idx = sb.length();

        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'L') {
                if (idx > 0) idx--;
            } else if (cmd.charAt(i) == 'D') {
                if (idx < sb.length()) idx++;
            } else if (cmd.charAt(i) == 'B') {
                if (idx == 0) {
                    continue;
                }
                sb.delete(idx - 1, idx);
                if (idx > 0) idx--;
            } else if (cmd.charAt(i) >= 'a' && cmd.charAt(i) <= 'z') {
                sb.insert(idx++, cmd.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
