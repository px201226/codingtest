package boj.prb95;

/*
https://www.acmicpc.net/problem/5567
결혼식
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N+1][N+1];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = true;
            map[v][u] = true;
        }
        Set<Integer> set = new HashSet<>();
        for(int v=2; v<=N; v++) {
            if (map[1][v]) {
                set.add(v);
                for (int w = 2; w <= N; w++) {
                    if (map[v][w]) set.add(w);
                }
            }
        }
        System.out.println(set.size());
    }

}



