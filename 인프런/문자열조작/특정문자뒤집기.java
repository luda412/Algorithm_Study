package 인프런.문자열조작;

import java.util.Scanner;

public class 특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char[] arr = str.toCharArray();

        int lt = 0;
        int rt = str.length()-1;


        while (lt < rt ){
            if (!Character.isAlphabetic(arr[lt])){
                lt++;
            }else if(!Character.isAlphabetic(arr[rt])){
                rt--;
            }else{
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        System.out.println(String.valueOf(arr));

    }
}
