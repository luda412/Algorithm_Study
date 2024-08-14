package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 과제는끝나지않아 {
    static class Assignment{
        int A, T;

        Assignment(int a, int t){
            this.A = a;
            this.T = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        Deque<Assignment> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int res = 0;
        int A, T;
        Assignment assignment;

        while (N-- > 0){
            input = br.readLine().split(" ");

            if(input[0].equals("1")){
                A = Integer.parseInt(input[1]);
                T = Integer.parseInt(input[2]);
                if(T == 1){
                    res += A;
                }else{
                    stack.push(new Assignment(A, T-1));
                }
            }else if(!stack.isEmpty()){
                assignment = stack.pop();
                if(assignment.T == 1){
                    res += assignment.A;;
                }else {
                    --assignment.T;
                    stack.push(assignment);
                }
            }
        }
        System.out.println(res);
    }
}
