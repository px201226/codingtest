package boj.prb73;

/*
https://www.acmicpc.net/problem/1316
구현, 그룹 단어 체커
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N; n++){
            String s = br.readLine();
            boolean[] isSelect = new boolean[30];
            boolean isPass = true;
            char prev = '-';

            for(int i=0; i<s.length(); i++){
                if(!isSelect[ s.charAt(i) -'a'] || prev == s.charAt(i)){
                    isSelect[ s.charAt(i) -'a'] = true;
                    prev = s.charAt(i);
                }else{
                    isPass = false;
                }
            }
            if(isPass) answer++;

        }
        System.out.println(answer);
    }

}



