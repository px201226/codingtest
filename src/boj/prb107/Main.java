package boj.prb107;

/*
https://www.acmicpc.net/problem/1182
부분수열의합
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static int K;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i=1; i<=N; i++){
            answer += DFS(arr,N,i,0,new ArrayList<>());
        }
        System.out.println(answer);
    }

    public static int DFS(int[] arr, int n,int r, int begin, ArrayList<Integer> result){
        if(r == 0){
            if(result.stream().mapToInt(i->i).sum() == K)
                return 1;
            else
                return 0;
        }
        int answer = 0;
        for(int i=begin; i<n; i++){
            result.add(arr[i]);
            answer += DFS(arr,n,r-1,i+1,result);
            result.remove(result.size()-1);
        }
        return answer;
    }
}
