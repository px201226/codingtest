package boj.prb85;

/*
https://www.acmicpc.net/problem/1051
숫자정사각형ㅎ
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
        int[][] map = new int[H][W];
        for(int h=0; h<H; h++){
            String str = br.readLine();
            for(int w=0; w<W; w++){
                map[h][w] = Character.getNumericValue(str.charAt(w));
            }
        }

        int minLen = H < W ? H : W;
        int max = 0;
        for(int y=0; y<H; y++){
            for(int x=0; x<W; x++){
                for(int len=minLen-1; len > max; len--){
                    if(x+len >= W || y+len >= H) continue;
                    if(isSquare(map,x,y,len)){
                        max = Math.max(max,len);
                        break;
                    }
                }
            }
        }
        System.out.println((max+1)*(max+1));

    }


    public static boolean isSquare(int[][] map,int x, int y, int len){
        return(map[y][x] == map[y][x+len] && map[y+len][x] == map[y+len][x+len] && map[y][x] == map[y+len][x]) ;
    }
}



