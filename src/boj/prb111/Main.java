package boj.prb111;

/*
https://www.acmicpc.net/problem/9663
n-queen
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(DFS(new int[N],N,0));
    }

    public static int DFS(int[] arr, int N, int depth){
        if(N == depth){
            return 1;
        }

        int answer = 0;
        for(int i=0; i<arr.length; i++){
            arr[depth] = i;
            if(isPromise(arr,depth)){
                answer += DFS(arr,N,depth+1);
            }
        }
        return answer;
    }

    private static boolean isPromise(int[] arr, int depth) {
        for(int c=0; c<depth; c++){
            if(arr[c] == arr[depth] || Math.abs(c-depth) == Math.abs(arr[c] - arr[depth])) return false;
        }
        return true;
    }
}
