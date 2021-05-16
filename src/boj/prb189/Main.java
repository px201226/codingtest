package boj.prb189;

/*
https://www.acmicpc.net/problem/11478
서로다른 부분문자열
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                set.add(str.substring(i,j));
            }
        }

        System.out.print(set.size());
    }
}