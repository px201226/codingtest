package boj.prb122;

/*
https://www.acmicpc.net/problem/14501
퇴사 DFS 브루투포스
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(map,0,0,new boolean[N]));
    }

    public static int DFS(int[][] map, int day,int idx, boolean[] isSelect){
        int answer = 0;

        if(idx > map.length) return answer;
        for(int i=0; i<isSelect.length; i++){
            if(isSelect[i]) {
                answer += map[i][1];
            }
        }


        for(int i=idx; i<map.length; i++){
            if( i >= day &&  i + map[i][0] <= map.length){
                isSelect[i] = true;
                answer = Math.max(answer,DFS(map,i+map[i][0], i+1,isSelect));
                isSelect[i] = false;
                answer = Math.max(answer,DFS(map,day+1,i+1,isSelect));
            }
        }
        return answer;
    }

}
