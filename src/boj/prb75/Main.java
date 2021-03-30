package boj.prb75;

/*
https://www.acmicpc.net/problem/7568
덩치
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        int[][] human = new int[N][2];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            human[n][0] = Integer.parseInt(st.nextToken());
            human[n][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=0; j<N; j++){
                if(j==i) continue;
                if(human[i][0] < human[j][0] && human[i][1] < human[j][1]){
                    temp++;
                }
            }
            answer[i] = temp+1;
        }

        for(int i=0; i<answer.length; i++)
            System.out.print(answer[i] + " ");
    }

}



