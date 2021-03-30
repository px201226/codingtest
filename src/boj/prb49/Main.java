package boj.prb49;

/*
https://www.acmicpc.net/problem/1260
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] edge = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());
            edge[u][v] = edge[v][u] = true;
        }

        DFS(edge,new boolean[N+1],V);
        System.out.println("");
        BFS(edge,new boolean[N+1],V);
    }

    public static void DFS(boolean[][] edge, boolean[] isVisited, int u){
        System.out.print(u + " ");
        isVisited[u] = true;
        for(int v=1; v<isVisited.length; v++){
            if(!isVisited[v] && u != v && edge[u][v]){
                DFS(edge,isVisited,v);
            }
        }
    }

    public static void BFS(boolean[][] edge, boolean[] isVisited, int U){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(U);
        isVisited[U] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");
            for(int v=1; v<isVisited.length; v++){
                if(!isVisited[v] && u != v && edge[u][v]){
                    isVisited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}