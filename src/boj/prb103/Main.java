package boj.prb103;

/*
https://www.acmicpc.net/problem/1502
물병
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++){

            int p = 1;
            while(p*2 <= N) p *= 2;
            N -= p;

            if(N == 0) break;
            if(i == K-1){
                System.out.println(p-N);
            }
        }
    }
}



