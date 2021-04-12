package boj.prb128;

/*
https://www.acmicpc.net/problem/18429
근손실
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) map[i] = Integer.parseInt(st.nextToken());

        System.out.println(DFS(N,0,new boolean[N], new int[N], K, map));
    }

    public static int DFS(int N, int depth, boolean[] isVisited, int[] output, final int K, final int[] map){
        if(depth == N){
            int weight = 500;
            for(int count=0; count<N; count++){
                weight += map[output[count]];
                weight -= K;
                if(weight < 500) return 0;
            }
            return 1;
        }

        int answer =0;
        for(int i=0; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                output[depth] = i;
                answer += DFS(N,depth+1,isVisited,output,K,map);
                isVisited[i] = false;
            }
        }
        return answer;
    }


}
