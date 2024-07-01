package 인프런.문자열조작;

import java.util.Scanner;

public class 문자열회문 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String reverseStr = new StringBuilder(str).reverse().toString();


        if (str.equalsIgnoreCase(reverseStr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
