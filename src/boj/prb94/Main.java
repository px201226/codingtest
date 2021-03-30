package boj.prb94;

/*
https://www.acmicpc.net/problem/11286
절대값 힙
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>( (a,b)->
                Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b)
        );
        for(int i=0; i<N; i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                if(q.isEmpty()) System.out.println("0");
                else System.out.println(q.poll());
            }else{
                q.add(cmd);
            }
        }
    }

}



