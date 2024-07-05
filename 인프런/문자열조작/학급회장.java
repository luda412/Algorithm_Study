package 인프런.문자열조작;


import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public char Solution(String S){
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: S.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int max = Integer.MIN_VALUE;

        for(Character key: map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
                System.out.println(map.get(key));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        학급회장 T = new 학급회장();
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(T.Solution(S));

    }
}
