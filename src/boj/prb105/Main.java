package boj.prb105;

/*
https://www.acmicpc.net/problem/14500
테트로미노
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int[][] dir = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H= Integer.parseInt(st.nextToken());
        int W= Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        for(int h=0; h<H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<W; w++){
                map[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int h=0; h<H; h++){
            for(int w=0; w<W; w++){
                answer = Math.max(answer,DFS(map,w,h,0,0));
                answer = Math.max(answer,BFS(map,w,h));
            }
        }
        System.out.println(answer);
    }

    public static int DFS(int[][] map, int x, int y, int depth, int sum){
        if(depth == 4) { return sum ;}

        int answer = 0;
        int temp = map[y][x];
        map[y][x] = 0;
        for(int d=0; d<4; d++){
            int dx = x + dir[d][0]; int dy = y + dir[d][1];
            if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length || map[dy][dx] == 0) continue;
            answer = Math.max(answer,DFS(map,dx,dy,depth+1,sum+temp));
        }
        map[y][x] = temp;
        return answer;
    }

    public static int BFS(int[][] map, int x, int y){
        int sum = map[y][x];
        int min = Integer.MAX_VALUE;
        int canDirNumber = 0;
        for(int d=0; d<4; d++){
            int dx = x + dir[d][0]; int dy = y + dir[d][1];
            if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length) continue;
            sum += map[dy][dx];
            min = Math.min(min,map[dy][dx]);
            canDirNumber++;
        }
        if(canDirNumber == 4) sum -=min;
        return sum;
    }
}



