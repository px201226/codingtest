package boj.prb135;

/*
https://www.acmicpc.net/problem/2961
도영이 음식문제
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
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(arr,new boolean[N],0,0L,0L,0));
    }

    public static Long DFS(int[][] arr, boolean[] isVisited, int depth, Long mult, Long sum, int select){
        if(depth == arr.length && select >=1){
            return Math.abs(mult-sum);
        }
        if(depth == arr.length){return Long.MAX_VALUE;}

        Long answer = Long.MAX_VALUE;
        answer = Math.min(answer,DFS(arr,isVisited,depth+1, mult == 0 ? arr[depth][0] : mult * arr[depth][0], sum+arr[depth][1],select+1));
        answer = Math.min(answer,DFS(arr,isVisited,depth+1, mult,sum,select));

        return answer;
    }
}
