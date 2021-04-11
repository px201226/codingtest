package boj.prb123;

/*
https://www.acmicpc.net/problem/1120
문자열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.MAX_VALUE;
        for(int jump=0; jump+a.length() <= b.length(); jump++) {
            int cnt=0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i+jump)) cnt++;
            }
            min = Math.min(min,cnt);
        }
        System.out.println(min);
    }


}
