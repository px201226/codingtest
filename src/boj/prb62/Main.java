package boj.prb62;

/*
https://www.acmicpc.net/problem/1916
다익스트라
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];
        for(int[] cost1 : cost)
            Arrays.fill(cost1,Integer.MAX_VALUE);

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if(cost[u][v] > c)
                cost[u][v] = c;
        }
        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken()) -1;
        int V = Integer.parseInt(st.nextToken()) -1;
        System.out.println(dijkstra(cost,U,V,N));
    }

    private static int dijkstra(int[][] cost, int U, int V, int N){
        int[] distance = new int[N];
        boolean[] isVisited = new boolean[N];

        for(int i=0; i<N; i++) {
                distance[i] = cost[U][i];
        }

        distance[U] = 0;
        isVisited[U] = true;
        for(int i=0; i<N-1; i++){

            int u = 0;
            int minCost = Integer.MAX_VALUE;
            for(int v=0; v<N; v++){
                if(!isVisited[v] && distance[v] < minCost){
                    minCost = distance[v];
                    u = v;
                }
            }

            isVisited[u] = true;
            for(int v=0; v<N; v++){
                if(!isVisited[v] && cost[u][v] != Integer.MAX_VALUE) {
                    if (distance[v] > distance[u] + cost[u][v]) {
                        distance[v] = distance[u] + cost[u][v];
                    }
                }
            }
        }

        return distance[V];
    }

}

