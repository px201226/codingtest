package boj.prb169;

/*
https://www.acmicpc.net/problem/2178
미로찾기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dir = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[H][W];
        for(int h=0; h<H; h++){
            String str = br.readLine();
            for(int w=0; w<W; w++){
                if(str.charAt(w) == '1') map[h][w] = true;
            }
        }
        System.out.println(BFS(map));
    }

    public static int BFS(boolean[][] map){
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        isVisited[0][0] = true;

        int answer = 0;
        while(!q.isEmpty()){
            int[] poll = q.poll();
            System.out.println(Arrays.toString(poll));
            if(poll[0] == map[0].length -1  && poll[1] == map.length-1){
                answer = poll[2];
                break;
            }
            for(int d=0; d<4; d++){
                int dx = poll[0] + dir[d][0], dy = poll[1] + dir[d][1];
                if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length || isVisited[dy][dx] || !map[dy][dx])
                    continue;

                isVisited[dy][dx] = true;
                q.add(new int[]{dx,dy,poll[2]+1});

            }

        }

        return answer;
    }
}
