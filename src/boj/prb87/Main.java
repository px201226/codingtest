package boj.prb87;

/*
https://www.acmicpc.net/problem/18111
마인크래프ㅡ
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;
        int total = H*W;
        int[][] map = new int[H][W];
        for(int h=0; h<H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<W; w++){
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                map[h][w] = num;
            }
        }

        int answer = Integer.MAX_VALUE;
        int max =0;

        for(int target = 0; target <= 256; target++){
            int temp = K;
            int over = 0;
            int under = 0;
            for(int h=0; h<H; h++){
                for(int w=0; w<W; w++){
                    if(map[h][w] > target){
                        over += map[h][w] - target;
                        temp += map[h][w] - target;
                    }
                    if(map[h][w] < target){
                        under += target - map[h][w];
                        temp -= target - map[h][w];
                    }
                }
            }
            if(temp < 0) break;
            if(answer >= over * 2 + under){
                answer = over * 2 + under;
                max = target;
            }
        }
        System.out.printf("%d %d", answer,max);
    }
}



