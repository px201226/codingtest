package boj.prb54;

/*
https://www.acmicpc.net/problem/10870
 * */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(fibo(N));
    }

    public static int fibo(int n){
        int[] dp = new int[21];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}