package Basic.Java_18_1.src;

import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        if (c >= 'a' && c <= 'z') {
            System.out.printf("%c", c - ('a' - 'A'));
        } else if (c >= 'A' && c <= 'Z') {
            System.out.printf("%c", c + ('a' - 'A'));
        }
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
