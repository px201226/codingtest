package boj.prb178;

/*
https://www.acmicpc.net/problem/11656
접미사 배열
 * */
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeSet<String> answer = new TreeSet<>();
        for(int begin=0; begin<str.length(); begin++){
            answer.add(str.substring(begin));
        }
        StringBuilder output = new StringBuilder("");
        int a = 2;
        answer.stream().forEach( word -> output.append(word+"\n" ));
        System.out.println(output);
    }
}