package boj.prb164;

/*
https://www.acmicpc.net/problem/16206
롤케이크
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)-> a%10 == b%10 ? a-b : a%10-b%10);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(st.nextToken()));
        int answer = 0;
        while (!pq.isEmpty()){
            Integer size = pq.poll();
            answer+=cut(size);
        }
        System.out.println(answer);
    }

    public static int cut(int len){
        if((K <= 0 && len!=10) || len < 10) return 0;
        if(len == 10) return 1;
        if(len > 10){
            len -= 10;
            K--;
            return 1+cut(len);
        }
        return 0;
    }
}