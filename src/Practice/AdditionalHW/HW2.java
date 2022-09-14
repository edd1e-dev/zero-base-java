package Practice.AdditionalHW;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UNNECESSARY;

public class HW2 {
    public static void main(String[] args) {
        // JDK 9+ 부터는 일반적인 String도 StringBuilder 처리되어서 동작함.

        String content = new FileUtils().getLoadText("./AdditionalHW2.txt");
        final int alphabetLength = 26;
        int[] count = new int[alphabetLength];
        // BigDecimal total = new BigDecimal();
        int total = 0;
        for (int i = 0; i < content.length(); ++i) {
            if (content.charAt(i) >= 'a' && content.charAt(i) <= 'z') {
                count[(content.charAt(i) - 'a')]++;
            } else if (content.charAt(i) >= 'A' && content.charAt(i) <= 'Z') {
                count[(content.charAt(i) - 'A')]++;
            }
        }

        for (var n : count) {
            // total.add(new BigDecimal(n));
            total += n;
        }

        double test = 0.0d;

        for (int i = 0; i < alphabetLength; ++i) {
            // BigDecimal data = new BigDecimal(count[i]).divide(total).multiply(BigDecimal.valueOf(100));
            System.out.println(String.format(" %c = %6d개, %3f%%", (char)(i + 'A'), count[i], ((double)count[i]) / ((double)total) * 100.0d));
            test += ((double)count[i]) / ((double)total) * 100.0d;
        }

        System.out.println(test);
    }
}
