package boj.prb79;

/*
https://www.acmicpc.net/problem/3085
사탕 찾기
 * */


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int[][] rule = new int[][]{
            {1,0},{0,1}
    };
    public static int[][] vertical = new int[][]{
            {0,1},{0,-1}
    };
    public static int[][] horizen = new int[][]{
            {1,0},{-1,0}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = str.charAt(x);
            }
        }
        int max =0 ;
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                for(int d=0; d<2; d++){
                    int dx = x + rule[d][0];
                    int dy = y + rule[d][1];
                    if(dx < 0 || dx >= map[0].length || dy <0 || dy >= map.length) continue;
                    swap(map,x,y,dx,dy);
                    max = Math.max(max,getMax(map,x,y,vertical));
                    max = Math.max(max,getMax(map,dx,dy,vertical));
                    max = Math.max(max,getMax(map,x,y,horizen));
                    max = Math.max(max,getMax(map,dx,dy,horizen));
                    swap(map,x,y,dx,dy);
                }
            }
        }
        System.out.println(max);
    }
    public static void swap(char[][] map, int x1, int y1, int x2, int y2){
        char temp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = temp;
    }
    public static int getMax(char[][] map, int x, int y, int[][] dir){
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        isVisited[y][x] = true;
        int answer = 0;
        while(!queue.isEmpty()){
            Point poll = queue.poll();
            answer++;
            for(int d=0; d<dir.length; d++){
                int dx = poll.x + dir[d][0];
                int dy = poll.y + dir[d][1];
                if(dx < 0 || dx >= map[0].length || dy <0 || dy >= map.length) continue;
                if(map[dy][dx] == map[poll.y][poll.x] && !isVisited[dy][dx]){
                    queue.add(new Point(dx,dy));
                    isVisited[dy][dx] = true;
                }
            }
        }
        return answer;
    }
}



