package boj.prb157;

/*
https://www.acmicpc.net/problem/9357
패션왕
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int K = Integer.parseInt(br.readLine());
            HashMap<String,Integer> countByType = new HashMap<>();
            for(int k=0; k<K; k++){
                String type = br.readLine().split(" ")[1];
                countByType.put(type, countByType.getOrDefault(type,0)+1);
            }

            int result = 1;
            for(int num : countByType.values()){
                result *= (num+1);
            }
            System.out.println(result-1);

        }

    }

}