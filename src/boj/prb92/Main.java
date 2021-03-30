package boj.prb92;

/*
https://www.acmicpc.net/problem/1713
후보 추천
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] recommands = new int[101];
        int[] createTimes = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->
            recommands[a] == recommands[b] ? createTimes[a] - createTimes[b] : recommands[a] - recommands[b]
        );

        for(int n=0; n<K; n++){
            int idx = Integer.parseInt(st.nextToken());
            recommands[idx]++;
            boolean isContain = q.contains(idx);
            if(isContain) {
                q.remove(idx);
                q.add(idx);
            }else{
                if(q.size() == N){
                    recommands[q.poll()] = 0;
                }
                createTimes[idx] = n;
                q.add(idx);
            }
        }
        int[] integers = q.stream().mapToInt(a->a).toArray();
        Arrays.sort(integers);
        for(int i : integers) System.out.print(i + " ");
    }
}



