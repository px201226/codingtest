package boj.prb93;

/*
https://www.acmicpc.net/problem/9934
완전이진트리
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] inOrder = new int[(1<<N)-1];
        int[] answer = new int[(1<<N)-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< (1<<N)-1; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        DFS(inOrder,answer,0,0,N-1);
        for(int i=0, idx=0; i<N; i++){
            for(int j=0; j<(1<<i); j++){
                System.out.print(answer[idx++] + " ");
            }
            System.out.println("");
        }
    }

    public static void DFS(int[] inOrder,int[] answer,int idx, int depth, int N){

        if(depth == N){
            answer[idx] = inOrder[count++];
            return;
        }

        DFS(inOrder,answer,idx*2+1,depth+1,N);
        answer[idx] = inOrder[count++];
        DFS(inOrder,answer,idx*2+2,depth+1,N);
    }
}



