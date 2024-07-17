package 인프런.문자열조작;

import java.util.HashMap;
import java.util.Scanner;

public class 한번사용한최초문자 {
    public int soultion( String S){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: S.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(int i = 0; i < S.length(); i++){
            if(map.get(S.charAt(i))==1){
                return i+1 ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        한번사용한최초문자 T = new 한번사용한최초문자();
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(T.soultion(S));

    }
}
