package boj.prb190;

/*
https://www.acmicpc.net/problem/16500
문자열 판별
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        List<String> stringList = new ArrayList<>();
        for(int i=0; i<N; i++) stringList.add(br.readLine());
        System.out.println(DP(target,stringList));
    }

    public static int DP(String target, List<String> stringList){
        int[] dp = new int[101];
        dp[target.length()] = 1;

        for(int i=target.length()-1; i>=0; i--){
            for(String compare : stringList){
                if(target.startsWith(compare,i) && dp[i+compare.length()] == 1){
                    dp[i] = 1;
                }
            }
        }
        return dp[0];
    }
}