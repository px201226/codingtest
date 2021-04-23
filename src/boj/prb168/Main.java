package boj.prb168;

/*
https://www.acmicpc.net/problem/2606
바이러스
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N+1][N+1];
        for(int k=0; k<K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = map[v][u] = true;
        }

        System.out.print(BFS(map,1));
    }


    public static int BFS(boolean[][] map, int begin){
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[map.length];
        isVisited[begin] = true;
        q.add(begin);
        int answer = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v=1; v<map.length; v++){
                if(!isVisited[v] && map[u][v]){
                    isVisited[v] = true;
                    q.add(v);
                    answer++;
                }
            }
        }

        return answer;
    }
}