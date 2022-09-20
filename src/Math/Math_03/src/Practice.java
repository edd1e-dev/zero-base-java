package Math.Math_03.src;// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;

public class Practice {
    
//  약수: 값 x를 1부터 x로 나눠서 나머지가 발생하지 않는 수
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }
        result.add(num);

        return result;
    }

//  최대 공약수: 두 수의 약수중 최대로 일치하는 수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for (int itemA : (ArrayList<Integer>) divisorA) {
            for (int itemB : (ArrayList<Integer>) divisorB) {
                if (itemA == itemB) {
                    if (itemA > gcd) {
                        gcd = itemA;
                    }
                }
            }
        }

        return gcd;
    }

//  최소 공배수: 두 수의 배수 중에서 공통되는 가장 작은 값, 두 수를 곱하고 최소 공약수로 나눠도 똑같음
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);

        if (gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최대 공배수: " + p.getLCM(number1, number2));

        int[] arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length;) {
            System.out.print(arr[i]);
            if (++i < arr.length) {
                System.out.print(",");
            }
        }
    }
}
