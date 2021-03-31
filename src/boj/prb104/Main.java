package boj.prb104;

/*
https://www.acmicpc.net/problem/1502
물병
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int temp=2, k=0;
        while(temp*2-2<n) {
            temp<<=1;k++;
        }
        System.out.println(temp);
        n-=(temp-1);
        while(k>=0) {
            if((n & (1<<k)) >= 1) System.out.print("7");
            else System.out.print(4);;
            k--;
        }
    }
}



