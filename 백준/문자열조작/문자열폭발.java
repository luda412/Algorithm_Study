package 백준.문자열조작;

import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String explosionS = sc.next();
        int regexSize = explosionS.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            st.push(S.charAt(i));
            if (st.size() >= regexSize) {
                boolean flag = true;

                for (int j = 0; j < regexSize; j++) {
                    if (st.get(st.size() - regexSize + j) != explosionS.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < regexSize; j++) {
                        st.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c: st){
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA": sb.toString());
    }
}
