package boj.prb140;

/*
https://www.acmicpc.net/problem/2589
보물섬
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dirent = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] isConnect = new boolean[H][W];
        for(int h=0;h<H;h++){
            String temp = br.readLine();
            for(int w=0;w<W;w++)
                isConnect[h][w] = temp.charAt(w) == 'L' ? true :false;
        }

        int maxium = 0;

        for(int h=0;h<H;h++){
            for(int w=0; w<W;w++){
                if(isConnect[h][w] == false) continue;
                Queue<int []> q = new LinkedList<>();
                boolean[][] isVisited = new boolean[H][W];
                q.add(new int[]{w,h,0});
                isVisited[h][w] = true;
                while (!q.isEmpty()) {
                    int[] poll = q.poll();
                    maxium = Math.max(poll[2],maxium);
                    for(int d=0; d<4;d++){
                        int dx = poll[0] + dirent[d][0], dy = poll[1] + dirent[d][1];
                        if( dx < 0 || dx >= W || dy < 0 || dy >= H) continue;
                        if(isConnect[dy][dx] && !isVisited[dy][dx]){
                            q.add(new int[]{dx,dy,poll[2] +1});
                            isVisited[dy][dx] = true;
                        }
                    }
                }
            }
        }
        System.out.println(maxium);
    }

}
