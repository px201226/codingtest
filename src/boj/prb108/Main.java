package boj.prb108;

/*
https://www.acmicpc.net/problem/14225
부분수열의합2
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    private static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(arr,N,0,0);
        for(int i=1; ; i++){
            if(!set.contains(i)){
                System.out.println(i);return;
            }
        }
    }
    public static void DFS(int[] arr, int n, int r, int sum){
        if(n == r) return;
        set.add(sum+arr[r]);
        DFS(arr,n,r+1, sum);
        DFS(arr,n,r+1,sum + arr[r] );
    }

}
