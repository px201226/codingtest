package boj.prb110;

/*
https://www.acmicpc.net/problem/16198
에너지 모으기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(arr,new boolean[N], 0 ,0 ));
    }

    public static int DFS(int[] arr, boolean[] isSelect, int size, int result){
        if(size == arr.length - 2){
            return result;
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1; i<arr.length -1; i++){
            if(isSelect[i] == false){
                isSelect[i] = true;
                int sum = arr[getNearIdx(isSelect,i,1)] * arr[getNearIdx(isSelect,i,-1)];
                answer = Math.max(answer,DFS(arr,isSelect,size+1, result + sum));
                isSelect[i] = false;
            }
        }

        return answer;
    }

    public static int getNearIdx(boolean[] isSelect,int base, int increase){
        for(int i=base; i >= 0 && i < isSelect.length; i += increase){
            if(!isSelect[i]) return i;
        }
        return -1;
    }

}
