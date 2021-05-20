package boj.prb192;

/*
https://www.acmicpc.net/problem/1411
비슷한 단어
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] array = new String[N];

        for(int i=0; i<N; i++) array[i] = br.readLine();

        int answer =0 ;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){

                int[] isChk1 = new int[27];
                int[] isChk2 = new int[27];
                if(array[i].length() != array[j].length()) continue;
                int k;
                for(k=0; k<array[i].length(); k++){
                    int a = array[i].charAt(k) - 'a' +1;
                    int b = array[j].charAt(k) - 'a' +1;
                    if(isChk1[a] == 0 && isChk2[b] == 0){
                        isChk1[a] = b;
                        isChk2[b] = a;
                    }else if(isChk1[a] != b) break;
                }
                if(k >= array[i].length()) answer++;
            }
        }

        System.out.println(answer);
    }
}