package boj.prb179;

/*
https://www.acmicpc.net/problem/1431
시리얼번호
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(br.readLine());
        Collections.sort(list, (str1,str2) -> {
            if(str1.length() == str2.length()){
                int sum = 0;
                for(char c : str1.toCharArray()){
                    if(Character.isDigit(c)) sum += (c - '0');
                }
                for(char c : str2.toCharArray()){
                    if(Character.isDigit(c)) sum -= (c - '0');
                }
                if(sum == 0){
                    return str1.compareTo(str2);
                }else{
                    return sum;
                }
            }else{
                return str1.length() - str2.length();
            }
        });

        list.stream().forEach(s-> System.out.println(s));
    }
}