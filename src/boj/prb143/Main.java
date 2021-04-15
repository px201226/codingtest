package boj.prb143;

/*
https://www.acmicpc.net/problem/1747
소수 팰린드롬
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int[] numArrs = new int[]{0,1,2,3,4,5,6,7,8,9};
    public static List<Long> desc = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = prime(2000000);
        while (!isPalendrom(N) || isNotPrime[N]){
            N++;
        }
        System.out.println(N);
    }

    public static boolean isPalendrom(int N){
        String str = String.valueOf(N);
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
    public static boolean[] prime(int N){
        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[0] = isNotPrime[1] = true;

        for(int i=2; i*i<=N; i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<=N; j+=i)
                    isNotPrime[j] = true;
            }
        }
        return isNotPrime;
    }

}
