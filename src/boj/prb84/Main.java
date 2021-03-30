package boj.prb84;

/*
https://www.acmicpc.net/problem/1748
수 이어 쓰기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 1, ans=0;
        while(num / i !=0){
            ans += num - i +1;
            i*=10;
        }
        System.out.println(ans);
    }

}



