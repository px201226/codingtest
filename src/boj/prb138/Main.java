package boj.prb138;

/*
https://www.acmicpc.net/problem/1759
암호 만들기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        DFS(arr,0,0,N,"");
    }

    public static void DFS(char[] arr, int depth, int idx, int N, String sb){
        if(depth == N){
            int consonent = 0;
            int vowel = 0;
            for(char ch : sb.toCharArray()){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowel++;
                else{
                    consonent++;
                }
            }
            if(consonent >=2 && vowel >=1) System.out.println(sb);
            return;
        }

        for(int i=idx; i<=arr.length-N+depth; i++){
            DFS(arr,depth+1,i+1,N, sb + arr[i]);
        }
    }

}
