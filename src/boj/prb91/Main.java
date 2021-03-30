package boj.prb91;

/*
https://www.acmicpc.net/problem/1138
홀로서기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            int left = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++){
               if(left == 0 && answer[j] == 0){
                    answer[j] = i+1;
                    break;
                }else if(answer[j] == 0) left--;

            }
        }
        System.out.println(Arrays.toString(answer).replace("[","").replace("]","").replace(",",""));
    }
}



