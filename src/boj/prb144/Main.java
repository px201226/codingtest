package boj.prb144;

/*
https://www.acmicpc.net/problem/17141
연구소2
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] dir = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    static int[][] map;
    static List<int []> canVirus;
    static int N;
    static int removeCount = 0;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        canVirus = new ArrayList<>();
        for(int h=0; h<N; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<N; w++){
                map[h][w] = Integer.parseInt(st.nextToken());
                if (map[h][w] == 2){
                    removeCount++;
                    canVirus.add(new int[]{w,h,0});
                }else if (map[h][w] == 0){
                    removeCount++;
                }
            }
        }
        int answer = combination(0,K,canVirus.size(),0,new boolean[10]);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static int BFS(Queue<int[]> q, boolean[][] isVisited){
        int count = 0, time=0;
        while (!q.isEmpty()){
            int[] poll = q.poll();
            count++;
            time = poll[2];
            for(int d=0; d<4; d++){
                int dx = poll[0] + dir[d][0], dy = poll[1] + dir[d][1];
                if(dx < 0 || dx >= N || dy < 0 || dy >= N || isVisited[dy][dx] || map[dy][dx] == 1) continue;
                isVisited[dy][dx] = true;
                q.add(new int[]{dx,dy,poll[2]+1});
            }
        }
        return removeCount == count ? time : Integer.MAX_VALUE;
    }
    public static int combination(int idx, int K, int virusN, int depth, boolean[] isSelect){
        if(depth == K){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] isVisited = new boolean[N][N];
            for(int i=0; i<isSelect.length;i++){
                if(isSelect[i]){
                    q.add(canVirus.get(i));
                    isVisited[canVirus.get(i)[1]][canVirus.get(i)[0]] = true;
                }
            }
            return BFS(q,isVisited);
        }

        int answer = Integer.MAX_VALUE;
        for(int i=idx; i<virusN; i++){
            isSelect[i] = true;
            answer = Math.min(combination(i+1,K,virusN,depth+1,isSelect),answer);
            isSelect[i] = false;
        }
        return answer;
    }
}
