package boj.prb129;

/*
https://www.acmicpc.net/problem/10819
차이를 최대로
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, (a,b)-> -(a-b) );
        System.out.println(DFS(arr,0,new boolean[N], new int[N]));
    }

    public static int DFS(Integer[] arr, int depth, boolean[] isVisited, int[] result){
       if(arr.length == depth){
           int answer = 0;
           for(int i=0; i<arr.length-1; i++)
               answer = answer + Math.abs(result[i] - result[i+1]);
           return answer;
       }

       int answer = Integer.MIN_VALUE;
       for(int i=0; i<arr.length; i++){
           if(!isVisited[i]){
               isVisited[i] = true;
               result[depth] = arr[i];
               answer = Math.max(answer,DFS(arr, depth + 1, isVisited, result));
               isVisited[i] = false;
           }
       }

       return answer;
    }


}
