package 백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int waterN = Integer.parseInt(br.readLine());
        int [] m = new int[waterN];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m.length; i++){
            m[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = m.length-1;

        Arrays.sort(m);

        int min = Integer.MAX_VALUE;

        int answer1 = 0;
        int answer2 = 0;


        while(lt < rt){

            int sum = m[lt]+m[rt];

            if (Math.abs(sum) < min ){
                min = Math.abs(sum);
                answer1 = m[lt];
                answer2 = m[rt];
            }

            if(sum < 0){
                lt ++;
            }else{
                rt--;
            }

        }
        System.out.println(answer1+" "+ answer2);

    }
}
