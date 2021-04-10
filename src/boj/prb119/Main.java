package boj.prb119;

/*
https://www.acmicpc.net/problem/10800
컬러볼
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            map[n] = new int[]{n,color,size};
        }
        Arrays.sort(map, ((o1, o2) -> o1[2] - o2[2]));
        int[] answer = new int[N];
        int total = 0;
        HashMap<Integer, Integer> sizeByColors = new HashMap<>();
        for(int i=0,j=0; i<N; i++){
            int[] color = map[i];
            for(;map[j][2] < map[i][2];j++){
                total += map[j][2];
                sizeByColors.put(map[j][1], sizeByColors.getOrDefault(map[j][1],0) + map[j][2]);
            }
            answer[color[0]] += total - sizeByColors.getOrDefault(color[1],0);
        }
        for(int num : answer){
            System.out.println(num);
        }
    }


}
