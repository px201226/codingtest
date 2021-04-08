package boj.prb117;

/*
https://www.acmicpc.net/problem/2638
치즈, BFS
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dirent = new int[][] {
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] map = new int[Y][X];
        for(int y=0; y<Y; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<X; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (clear(map) != 0){
            BFS(map);
            answer++;
        }
        System.out.println(answer);
    }
    public static int clear(int[][] map){
        int chease =0;
        for(int y=0; y<map.length; y++){
            for(int x=0; x<map[0].length; x++){
                if(map[y][x] >= 3){
                    map[y][x] = 0;
                }else if(map[y][x] == 2){
                    map[y][x] = 1;
                    chease++;
                }else if(map[y][x] ==1){
                    chease++;
                }
            }
        }
        return chease;
    }
    public static void BFS(int[][] map){

        boolean[][] isVisited = new boolean[map.length][map[0].length];
        isVisited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0], y = poll[1];
            for(int d=0; d<4; d++){
                int dx = x + dirent[d][0], dy = y + dirent[d][1];
                if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length || isVisited[dy][dx]) continue;;
                if(map[dy][dx] == 0){
                    isVisited[dy][dx] = true;
                    q.add(new int[]{dx,dy});
                }
                else
                    map[dy][dx]++;
            }
        }

    }
}
