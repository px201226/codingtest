package boj.prb146;

/*
https://www.acmicpc.net/problem/15684
사다리 조작
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long[] minArray = new long[]{0,0,1, 7, 4, 2, 6, 8,10};
    public static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(dp,Long.MAX_VALUE);
        for(int i=0; i<minArray.length; i++)
            dp[i] = minArray[i];

        int N = Integer.parseInt(br.readLine());
        getMinNum();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(String.format("%d %s",dp[num],getMaxNum(num)));
        }

    }
    public static void getMinNum(){
        String[] add = {"1", "7", "4", "2", "0", "8"};
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String curr = dp[i - j] + add[j-2];
                dp[i] = Math.min(dp[i], Long.parseLong(curr));
            }
        }
    }
    public static String getMaxNum(int n){
        if(n == 3) return "7";
        if(n % 2 == 0){
            return String.format("%0" + n/2 +"d",0).replaceAll("0","1");
        }else{
            return String.format("7%0" + (n/2-1) +"d",0).replaceAll("0","1");
        }
    }


}
