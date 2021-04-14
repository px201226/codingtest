package boj.prb136;

/*
https://www.acmicpc.net/problem/15661
링크와 스타트
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            answer = Math.min(answer,DFS(arr,new boolean[N], 0,0,i));
        }
        System.out.println(answer);
    }

    public static int DFS(int[][] arr, boolean[] isSelect, int depth, int idx, int N){
        if(depth == N){
            int sum0=0, sum1=0;
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    if(i==j) continue;
                    if(isSelect[i] && isSelect[j]) sum0 += arr[i][j];
                }
            }

            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    if(i==j) continue;
                    if(!isSelect[i] && !isSelect[j]) sum1 += arr[i][j];
                }
            }
            return Math.abs(sum0-sum1);
        }
        int answer = Integer.MAX_VALUE;
        for(int i=idx; i<arr.length; i++){
            if(!isSelect[idx]){
                isSelect[idx] = true;
                answer = Math.min(answer,DFS(arr,isSelect,depth+1,i+1,N));
                isSelect[idx] = false;
            }
        }
        return answer;
    }

}
