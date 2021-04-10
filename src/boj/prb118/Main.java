package boj.prb118;

/*
https://www.acmicpc.net/problem/14890
경사로
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<map.length; i++){
            answer+=solve(map,i,L,true);
         //   System.out.println(answer);
            answer+=solve(map,i,L,false);
            System.out.println(answer);
        }
        System.out.println(answer);
    }

    public static int solve(int[][] map, int i, int L, boolean isRow){
        int cnt = 1;
        for(int j=0; j<map.length -1; j++){
            int d = isRow ? map[i][j] - map[i][j+1] : map[j][i] - map[j+1][i];
            if(d==0) cnt++;
            else if(d==-1 && cnt>=L) cnt = 1;
            else if(d==1 && cnt>=0) cnt = -L +1;
            else return 0;
        }
        return cnt >=0 ? 1 : 0;
    }
}
