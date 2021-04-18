package boj.prb150;

/*
https://www.acmicpc.net/problem/5568
카드 놓기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        DFS(arr,0,K,new boolean[N],"");
        System.out.println(set.size());
    }

    public static void DFS(int[] arr, int depth, int K, boolean[] isSelect, String answer){
        if(K == depth){
            set.add(answer);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!isSelect[i]){
                isSelect[i] = true;
                DFS(arr, depth+1,K,isSelect,answer+arr[i]);
                isSelect[i] = false;
            }
        }
    }

}