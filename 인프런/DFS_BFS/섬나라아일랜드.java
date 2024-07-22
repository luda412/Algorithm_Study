package 인프런.DFS_BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x, y;
    Point (int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class 섬나라아일랜드 {

    static int n;
    static int [] dx = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    Queue<Point> queue = new LinkedList<>();

    public void BFS(int x, int y, int[][] board){
        queue.add(new Point(x,y));
        while (!queue.isEmpty()){
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board){
        int answer = 0; // solution 메서드 내에서 answer 변수를 초기화
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
        System.out.println(answer); // answer를 여기서 출력
    }

    public static void main(String[] args) throws IOException {
        섬나라아일랜드 T = new 섬나라아일랜드();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr); // solution 메서드를 호출
    }
}

/* 입력
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
*/