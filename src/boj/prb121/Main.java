package boj.prb121;

/*
https://www.acmicpc.net/problem/1065
한수 브루투포스
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N < 100){
            System.out.println(N);
            return;
        }else{
            int count = 99 ;
            for(int i=100; i<=N; i++){
                int a = i / 100;
                int b = (i%100) / 10;
                int c = i % 10;
                count += a-b == b-c ? 1 : 0;
            }
            System.out.println(count);
        }
    }

}
