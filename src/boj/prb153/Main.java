package boj.prb153;

/*
https://www.acmicpc.net/problem/2164
카드2
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=N; i++) list.add(i);
        while (list.size() != 1){
            list.remove();
            list.addLast(list.remove(0));
        }
        System.out.println(list.get(0));
    }

}