package boj.prb76;

/*
https://www.acmicpc.net/problem/1475
방번호
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cache = new int[9];
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == '6' || str.charAt(i) == '9')
                cache[6]++;
            else{
                cache[str.charAt(i) -'0'] = cache[str.charAt(i)-'0'] +2;
            }
        }
        int answer =Arrays.stream(cache).max().getAsInt();
        System.out.println(answer % 2 == 1 ? (answer+1)/2 : answer/2) ;
    }

}



