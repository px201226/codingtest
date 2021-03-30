package boj.prb10;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://programmers.co.kr/learn/courses/30/lessons/42626
비교 알고리즘이 핵심
* */

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(i->q.add(i));
        while(q.size() >= 1){
            int a = q.poll();
            if(a >= K) return answer ;
            if(q.size() == 0) return -1;
            int b = q.poll();
            int c = a + (b * 2);
            q.offer(c);
            answer++;
        }
        return -1;
    }
}