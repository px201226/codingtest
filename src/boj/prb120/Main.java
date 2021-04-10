package boj.prb120;

/*
https://www.acmicpc.net/problem/1018
체스판 브르투포스
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        for(int h=0; h<H; h++){
            map[h] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=H-8; i++){
            for(int j=0; j<=W-8; j++){
                answer = Math.min(getMinFillCount(map,j,i),answer);
            }
        }
        System.out.println(answer);
    }

    public static int getMinFillCount(char[][] map, int x, int y){
        int count = 0;
        for(int i=y; i<y+8; i++){
            for(int j=x; j<x+8; j++){
                if(i%2 == 0){
                    if(j%2 == 0 && map[i][j] == 'W') count++;
                    else if(j%2==1 && map[i][j] == 'B') count++;
                }else{
                    if(j%2 == 0 && map[i][j] == 'B') count++;
                    else if(j%2==1 && map[i][j] == 'W') count++;
                }
            }
        }
        return Math.min(count,64-count);
    }


}
