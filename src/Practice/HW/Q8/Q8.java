package Practice.HW.Q8;

import java.util.*;

public class Q8 {
    enum Boundary {
        FIRST(0),
        SECOND(12_000_000),
        THIRD(46_000_000),
        FOURTH(88_000_000),
        FIFTH(150_000_000),
        SIXTH(300_000_000),
        SEVENTH(500_000_000),
        EIGHTH(1_000_000_000);

        private final long value;

        Boundary(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }

    enum TaxRate {
        FIRST(6),
        SECOND(15),
        THIRD(24),
        FOURTH(35),
        FIFTH(38),
        SIXTH(40),
        SEVENTH(42),
        EIGHTH(45);

        private final int value;

        TaxRate(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    enum Deduction {
        FIRST(0),
        SECOND(1_080_000),
        THIRD(5_220_000),
        FOURTH(14_900_000),
        FIFTH(19_400_000),
        SIXTH(25_400_000),
        SEVENTH(35_400_000),
        EIGHTH(65_400_000);

        private final long value;

        Deduction(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        Scanner sc = new Scanner(System.in);
        long annualSalary = sc.nextLong();

        StringBuilder sb = new StringBuilder();
        int taxRate;
        long taxResult = 0;
        int maxBoundary = 0;
        Boundary[] boundaries = Boundary.values();
        TaxRate[] taxRates = TaxRate.values();
        Deduction[] deductions = Deduction.values();

        for (int idx = 0; idx < boundaries.length - 1; ++idx) {
            if (annualSalary > boundaries[idx].getValue()) {
                taxRate = taxRates[idx].getValue();
                long boundary;

                if (annualSalary < boundaries[idx + 1].getValue()) { // 과세표준 10억원 이하
                    boundary = annualSalary - boundaries[idx].getValue();
                    sb.append(String.format("%10d * %2d%% = %10d\n", boundary, taxRate, boundary * taxRate / 100));
                } else {
                    boundary = boundaries[idx + 1].getValue() - boundaries[idx].getValue();
                    sb.append(String.format("%10d * %2d%% = %10d\n", boundary, taxRate, boundary * taxRate / 100));
                }

                taxResult += boundary * taxRate / 100;
                maxBoundary = Math.max(maxBoundary, idx);

                if (boundaries[idx + 1].getValue() == Boundary.EIGHTH.getValue()) { // 과세표준 10억원 초과
                    if (annualSalary > Boundary.EIGHTH.getValue()) {
                        boundary = annualSalary - boundaries[idx + 1].getValue();
                        taxRate = taxRates[idx + 1].getValue();
                        sb.append(String.format("%10d * %2d%% = %10d\n", boundary, taxRate, boundary * taxRate / 100));
                        taxResult += boundary * taxRate / 100;
                        maxBoundary = Math.max(maxBoundary, idx + 1);
                    }
                }
            }
        }

        long deduction = (long) (annualSalary * taxRates[maxBoundary].getValue() * 0.01 - deductions[maxBoundary].getValue());

        sb.append(String.format("\n[세율에 의한 세금]:\t\t\t\t%10d", taxResult));
        sb.append(String.format("\n[누진공제 계산에 의한 세금]:\t%10d", deduction));

        System.out.println(sb);
    }
}
