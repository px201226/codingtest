package boj.prb145;

/*
https://www.acmicpc.net/problem/15684
사다리 조작
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[H+1][W+1];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[h][w] = true;
        }
        int dfs = DFS(map, 0,1);
        System.out.println(dfs == 4 ? -1 : dfs);
    }

    public static boolean check(boolean[][] map){
        for(int w=1; w<map[0].length; w++){
            int point = w;
            for(int h=1; h<map.length; h++){
                if(map[h][point]) point++;
                else if(map[h][point-1]) point--;
            }
            if(point != w) return false;
        }
        return true;
    }

    public static int DFS(boolean[][] map, int depth, int height){
        if(depth == 4){
            return 4;
        }
        if (check(map)) return depth;

        int answer = 4;
        for(int h=height; h<map.length; h++){
            for(int w=1; w<map[0].length-1; w++){
                if(map[h][w] || map[h][w-1] || map[h][w+1]) continue;
                map[h][w] = true;
                answer = Math.min(DFS(map,depth+1, h),answer);
                map[h][w] = false;
            }
        }
        return answer;
    }

}
