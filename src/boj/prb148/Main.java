package boj.prb148;

/*
https://www.acmicpc.net/problem/1158
야구
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(Arrays.toString(solve(N,K)).replace("[","<").replace("]",">"));
    }

    public static int[] solve(int N, int K){
        int[] answer = new int[N];
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++) arr[i] = i+1;
        for(int size=N, index=0; size>0; size--){
            index = (index+K-1) % size;
            answer[N-size] = arr[index];
            for(int j=index; j<N-1; j++){
                arr[j] = arr[j+1];
            }
        }
        return answer;
    }
}