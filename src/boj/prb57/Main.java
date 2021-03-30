package boj.prb57;

/*
https://www.acmicpc.net/problem/1806
부분합
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int sum = arr[0];
        int minLength = N+1;
        while(left <= right && right < N){
            if(sum < S){
                sum += arr[++right];
            }else if (sum > S){
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }else{
                minLength = Math.min(minLength, right - left + 1);
                sum += arr[++right];
            }
        }

        System.out.print(minLength == N+1 ? 0 : minLength);
    }

}