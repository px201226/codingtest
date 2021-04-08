package boj.prb116;

/*
https://www.acmicpc.net/problem/2573
빙산, union,find,queue 시뮬레이션
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent = new int[35];
    private static int W = 0, H=0;
    private static int[][] map;
    private final static int[][] dirent = new int[][]{
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        Arrays.fill(parent,-1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        Queue<int[]> colds  = new LinkedList<>();
        for(int h=0; h<H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<W; w++){
                map[h][w] = Integer.parseInt(st.nextToken());
                if(map[h][w]==0){
                    map[h][w] = -1;
                }
            }
        }
        int ice =getIce();
        int answer = 0;
        while (ice == 1){
            melt();
            answer++;
            ice = getIce();
        }
        System.out.println(ice > 1 ? answer : 0);
    }

    public static int getIce(){
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        int answer = 0;
        for(int y=0; y<map.length; y++){
            for(int x=0; x<map[0].length; x++){
                if(map[y][x] > 0 && !isVisited[y][x]){
                    answer++;
                    DFS(x,y,isVisited);
                }
            }
        }
        return answer;
    }

    private static void DFS(int x, int y, boolean[][] isVisited) {
       // System.out.printf("DFS %d,%d\n",x,y);
        isVisited[y][x] = true;
        for(int d=0; d<4; d++){
            int dx = x + dirent[d][0], dy = y + dirent[d][1];
            if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length || isVisited[dy][dx] || map[dy][dx] <= 0) continue;
            DFS(dx,dy,isVisited);
        }
    }

    public static void melt(){
        for(int h=0;h<map.length; h++){
            for(int w=0; w<map[h].length; w++){
                if(map[h][w] <= 0) continue;
                for(int d=0; d<4; d++){
                    int dx = w + dirent[d][0], dy = h + dirent[d][1];
                    if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length) continue;
                    if(map[h][w] > 0 && map[dy][dx] == -1) {
                        map[h][w]--;
                    }
                }
            }
        }
        for(int h=0;h<map.length; h++){
            for(int w=0; w<map[h].length; w++){
                if(map[h][w] == 0) map[h][w] = -1;
            }
        }
    }

}
