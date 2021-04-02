package boj.prb113;

/*
https://www.acmicpc.net/problem/2529
부등호
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static char[] arr;
    private static String max = String.valueOf(Long.MIN_VALUE);
    private static String min = String.valueOf(Long.MAX_VALUE);
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[N];
        for(int i=0; i<N; i++) arr[i] = st.nextToken().charAt(0);
        permutate(N+1,0,new boolean[10], new char[N+1]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void permutate(int N, int depth, boolean[] isSelect, char[] answer){
        if(N == depth){
            if(check(answer)) {
                String s = new String(answer);
                if (Long.valueOf(s) > Long.valueOf(max)) max = s;
                if (Long.valueOf(s) < Long.valueOf(min)) min = s;
            }
            return;
        }

        for(int i=9; i>=0; i--){
            if(!isSelect[i]){
                isSelect[i] = true;
                answer[depth] = (char) (i +'0');
                permutate(N,depth+1,isSelect,answer);
                isSelect[i] = false;
            }
        }
    }

    public static boolean check(char[] answer){
        boolean isCollect = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '>'){
                if(answer[i] <= answer[i+1]) return false;
            }else{
                if(answer[i] >= answer[i+1]) return false;
            }
        }
        return true;
    }
}
