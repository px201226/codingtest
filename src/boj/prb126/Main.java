package boj.prb126;

/*
https://www.acmicpc.net/problem/1057
토너먼트
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A<B ? solve(A,B) : solve(B,A));
    }

    public static int solve(int a, int b){
        int answer = 1;
        for(; a%2!=1 || b-a != 1; answer++){
            a = a%2 == 0 ? a/2 : a/2+1;
            b = b%2 == 0 ? b/2 : b/2+1;
        }
        return answer;
    }
}
