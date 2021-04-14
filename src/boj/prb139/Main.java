package boj.prb139;

/*
https://www.acmicpc.net/problem/1107
리모콘
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] isPossible = new boolean[10];
        if(N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) isPossible[Integer.parseInt(st.nextToken())] = true;
        }

        minDifference = Math.abs(100 - target);
        getNearNumber(isPossible,target,0,"");
        System.out.println(minDifference);
    }

    public static void getNearNumber(boolean[] isPossible, int target, int depth, String result){

        if(result.length() >= 1){
            int temp = Math.abs(target - Integer.parseInt(result)) + String.valueOf(result).length();
            minDifference = Math.min(temp,minDifference);
        }
        if(result.length() > String.valueOf(target).length()) return;

        for(int i=0; i<10; i++){
            if(!isPossible[i]){
                getNearNumber(isPossible, target, depth + 1, result + i);
            }
        }
    }
}
