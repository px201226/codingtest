package boj.prb147;

/*
https://www.acmicpc.net/problem/17281
야구
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    public static int N;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        int[][] result = new int[N][9];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++)
                result[i][j] = parseInt(st.nextToken());
        }

        System.out.println(permutation(result,0,new int[9],new boolean[9]));

    }
    public static int getScoree(int[][] map, int[] batting){
        int score = 0, seq =0, out = 0;

        for(int i=0; i<N; i++){
            out = 0;
            boolean[] runner = new boolean[3];
            while (out<3){
                int result = map[i][batting[seq]];
                if(result == 0)
                    out++;
                else{
                    for(int jujaIdx=2; jujaIdx>=0; jujaIdx--){
                        if(runner[jujaIdx]){
                            if(jujaIdx + result >= 3)
                                score++;
                            else
                                runner[jujaIdx + result] = true;
                            runner[jujaIdx] = false;
                        }
                    }

                    if(result == 4)
                        score++;
                    else{
                        runner[result-1] = true;
                    }
                }
                seq = (seq+1) % 9;
            }
        }

        return score;
    }
    public static int permutation(int[][] map, int depth, int[] batter, boolean[] isVistied){
        if(depth == 9){
            if(batter[3] == 0){
                return getScoree(map,batter);
            }
        }

        int answer = 0;
        for(int i=0; i<9; i++){
            if(!isVistied[i]){
                isVistied[i] = true;
                batter[depth] = i;
                answer = Math.max(answer,permutation(map,depth+1,batter,isVistied));
                isVistied[i] = false;
            }
        }

        return answer;
    }


}
