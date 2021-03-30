package boj.prb71;

/*
https://www.acmicpc.net/problem/1473
구현, 행사장대여
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[501][501];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++)
                    map[y][x] = true;
            }
        }
        int answer = 0;
        for(int y=0; y<map.length; y++){
            for(int x=0; x<map[0].length; x++){
                if(map[y][x]) answer++;
            }
        }
        System.out.println(answer);
    }

}



