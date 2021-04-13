package boj.prb133;

/*
https://www.acmicpc.net/problem/1254
팰린드롬 만들기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int jump=0;
        for(; jump<str.length(); jump++){
            boolean isEquals = true;
            int i=jump;
            int j=str.length()-1;
            while (i<j){
                if(str.charAt(i) != str.charAt(j)){
                    isEquals = false;
                    break;
                }
                i++;j--;
            }
            if(isEquals) break;
        }
        System.out.println(str.length()+jump);
    }


}
