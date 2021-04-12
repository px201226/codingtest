package boj.prb125;

/*
https://www.acmicpc.net/problem/10974
모든 순열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DFS(N,0,new boolean[N], new int[N]);
        System.out.println(sb);
    }

    public static void DFS(int N, int depth, boolean[] isVisited, int[] output){
        if(depth == N){
            for(int a : output) sb.append(a +1 + " ");
            sb.append("\n");
        }
        for(int i=0; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                output[depth] = i;
                DFS(N,depth+1,isVisited,output);
                isVisited[i] = false;
            }
        }
    }


}
