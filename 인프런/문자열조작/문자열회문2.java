package 인프런.문자열조작;

public class 문자열회문2 {
    public Boolean isPalindrome(String S) {
        Boolean answer = true;

        int rt = S.length() - 1;
        int lt = 0;

        while (lt < rt) {
            if (S.charAt(lt) != S.charAt(rt)) {
                return false;
            } else {
                lt++;
                rt--;
            }
        }
        return answer;
    }

    public String solution(String S){
        String answer = "YES";

        int rt = S.length() - 1;
        int lt = 0;

        while(lt < rt){
            if(S.charAt(lt) != S.charAt(rt)){
                String s1 = S.substring(lt, rt);
                String s2 = S.substring(lt + 1, rt + 1);
                if(!isPalindrome(s1) && !isPalindrome(s2)){
                    return "NO";
                }
                return answer;
            }
            lt++;
            rt--;
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열회문2 T = new 문자열회문2();
        System.out.println(T.solution("abcbdcba")); // YES
        System.out.println(T.solution("abcacbakcba")); // NO
    }
}
