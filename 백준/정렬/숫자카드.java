package 백준.정렬.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
    private static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) /2;
            if(key <= arr[mid]){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while (lo < hi){
            int mid = (lo + hi) / 2;
            if(key < arr[mid]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cardN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            cardN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardN);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(cardN, key) - lowerBound(cardN, key)).append(' ');
        }
        System.out.println(sb);
    }
}
