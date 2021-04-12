package boj.prb127;

/*
https://www.acmicpc.net/problem/9996
한국이 그리울 땐 서버에 접속하자
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String p = "^" + br.readLine().replace("*","(.*)") + "$";
        Pattern pattern = Pattern.compile(p);
        for (int i=0; i<N; i++){
            String temp = br.readLine();
            Matcher matcher = pattern.matcher(temp);
            if(matcher.matches()){
                System.out.println("DA");
            }else
                System.out.println("NE");
        }

    }
}
