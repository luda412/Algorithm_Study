package 백준.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
    static int n, m, answer = 0;
    static boolean[] visit = new boolean[101];
    static int[][] computer = new int[101][101];

    public static int dfs(int node){
        visit[node] = true;
        for(int j = 1; j <= n; j++){
            if(!visit[j] && computer[node][j] == 1){ // node가 1이고, j가 2일 떄는 answer가 올라가지만, node 가 2고 j가 1일 때 answer가 올라가지 않는 이유는 !visit[j]에 의해서 false가 되기 때문에 answer를 증가 시킬 수 없음
                answer++;
                dfs(j);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computer[x][y] = 1;
            computer[y][x] = 1;
        }

        System.out.println(dfs(1));
    }
}
