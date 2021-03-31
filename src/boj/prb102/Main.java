package boj.prb102;

/*
https://www.acmicpc.net/problem/18405
경쟁적 전염
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static class Virus extends Point implements Comparable<Virus>{
        int num;
        int time;
        public Virus(int x, int y, int num, int time) {
            super(x, y); this.num = num; this.time = time;
        }

        @Override
        public String toString() { return String.format("[%d,%d=%d/%d]",x,y,num,time);}

        @Override
        public int compareTo(Virus o) {
            return time == o.time ? num - o.num : time - o.time;
        }
    }
    private static int[][] dirent = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };

    public static void main(String[] args) throws IOException {

        PriorityQueue<Virus> q = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int h=0; h<N; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<N; w++){
                map[h][w] = Integer.parseInt(st.nextToken());
                if(map[h][w] != 0) q.add(new Virus(w,h,map[h][w],0));
            }
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken())-1;
        int X = Integer.parseInt(st.nextToken())-1;

        for(int k=0; k<K; k++){
            int size = q.size();
            while (size-- != 0){
                Virus poll = q.poll();
                for(int d=0; d<4; d++){
                    int dx = poll.x + dirent[d][0]; int dy = poll.y + dirent[d][1];
                    if(dx < 0 || dx >= N || dy < 0 || dy >= N || map[dy][dx] != 0) continue;
                    map[dy][dx] = poll.num;
                    q.add(new Virus(dx,dy,poll.num,k+1));
                }
            }

        }

        System.out.println(map[Y][X]);
    }
}



