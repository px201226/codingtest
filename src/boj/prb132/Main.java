package boj.prb132;

/*
https://www.acmicpc.net/problem/1535
안녕
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int j=0; j<2; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        DFS(arr,0,0,100);
        System.out.println(max);
    }

    public static void DFS(int[][] arr, int depth, int smile, int health){
        if(health <= 0)
            return;

        if(depth == arr.length) {
            max = Math.max(max, smile);
            return;
        }

        DFS(arr,depth+1,smile+arr[depth][1], health-arr[depth][0]);
        DFS(arr,depth+1,smile,health);
    }

}
