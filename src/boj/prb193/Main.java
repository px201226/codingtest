package boj.prb193;

/*
https://www.acmicpc.net/problem/2798
블랙잭
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){

                    int temp = array[i] + array[j] + array[k];
                    if(temp > sum) continue;;
                    answer = Math.max(temp,answer);
                }
            }
        }

        System.out.println(answer);
    }
}