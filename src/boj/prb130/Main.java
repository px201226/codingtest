package boj.prb130;

/*
https://www.acmicpc.net/problem/2210
숫자판 점프
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dirent = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static HashSet<Integer> set = new HashSet<>();
    public static int[][] map = new int[5][5];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int h=0; h<5; h++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int w=0; w<5; w++)
                map[h][w] = Integer.parseInt(st.nextToken());
        }
        for(int h=0; h<5; h++){
            for(int w=0; w<5; w++)
                DFS(w,h,0,"");
        }
        System.out.println(set.size());
    }

    public static void DFS(int x,int y,int depth,String sb){
        if(depth==6){
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int d=0; d<4; d++){
            int dx = x+dirent[d][0], dy = y + dirent[d][1];
            if(dx < 0 || dx >= 5 || dy < 0 || dy >= 5) continue;
            DFS(dx,dy,depth+1, sb + map[dy][dx]);
        }

    }


}
