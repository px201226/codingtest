package boj.prb97;

/*
https://www.acmicpc.net/problem/13335
트럭
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
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] weight = new int[N];
        int[] leg = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int idx = 0;


        while (idx < N){
            int curWeight = 0;
            for(int i=leg.length-1; i>=1; i--) {
                leg[i] = leg[i - 1];
                curWeight += leg[i];
            }
            curWeight += weight[idx];
            if(curWeight > L){
                leg[0] = 0;
            }else{
                leg[0] = weight[idx++];
            }
            time++;
        }
        System.out.println(time+W);

    }

}



