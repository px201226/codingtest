package boj.prb167;

/*
https://www.acmicpc.net/problem/16206
롤케이크
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = map[v][u] = true;
        }
        System.out.println(DFS(map,new boolean[N+1],U,String.valueOf(U)));
        System.out.println(BFS(map,new boolean[N+1],U));
    }

    public static String DFS(boolean[][] map, boolean[] isVisited,int u, String result){

        isVisited[u] = true;
        for(int v=0; v<map.length; v++){
            if(!isVisited[v] && map[u][v]){
                result =  DFS(map,isVisited,v, result + " " + v);
            }
        }
        return result;
    }

    public static String BFS(boolean[][] map, boolean[] isVisited, int u){

        isVisited[u] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        StringBuilder sb = new StringBuilder("");
        sb.append(u +  " ");
        while(!q.isEmpty()){
            int u1 = q.poll();
            for(int v=0; v<map.length; v++){
                if(!isVisited[v] && map[u1][v]){
                    isVisited[v] = true;
                    q.add(v);
                    sb.append(v + " ");
                }
            }
        }
        return sb.toString();
    }
}