package boj.prb134;

/*
https://www.acmicpc.net/problem/1058
친구
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
        int[][] cost = new int[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                if(str.charAt(j) == 'Y'){
                    cost[i][j] = cost[j][i] = 1;
                }
            }
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j) continue;
                    if(cost[i][k] == 0 || cost[k][j] == 0) continue;
                    if(cost[i][j] == 0)
                        cost[i][j] = cost[i][k] + cost[k][j];
                    else
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++){
            int count =0;
            for(int j=0; j<N; j++){
                if(0<cost[i][j] && cost[i][j] <= 2) count++;
            }
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}
