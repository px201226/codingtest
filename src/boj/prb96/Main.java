package boj.prb96;

/*
https://www.acmicpc.net/problem/13335
경비원
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] stores = new int[K+1][3];
        for(int k=0; k<K+1; k++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int seq = Integer.parseInt(st.nextToken());
            stores[k][2] = dir;
            if(dir == 1){
                stores[k][0] = seq;
                stores[k][1] = 0;
            }else if(dir == 2){
                stores[k][0] = seq;
                stores[k][1] = H;
            }else if(dir == 3){
                stores[k][0] = 0;
                stores[k][1] = seq;
            }else{
                stores[k][0] = W;
                stores[k][1] = seq;
            }
        }
        int answer = 0;
        for(int i=0; i<K; i++){
            if( (stores[K][2] == 1 && stores[i][2] == 2) || (stores[K][2] == 2 && stores[i][2] == 1)){
                answer += Math.min(
                        H+stores[i][0]+stores[K][0],
                        H+W-stores[i][0]+W-stores[K][0]
                );
            }else if( (stores[K][2] == 3 && stores[i][2] == 4) || (stores[K][2] == 4 && stores[i][2] == 3)){
                answer += Math.min(
                        W+stores[i][1] + stores[K][1],
                        W+H-stores[i][1] + H-stores[K][1]
                );
            }else{
                answer += Math.abs(stores[K][0] - stores[i][0]) + Math.abs(stores[K][1] - stores[i][1]);
            }
        }
        System.out.println(answer);
    }

}



