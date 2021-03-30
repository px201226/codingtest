package boj.prb1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
https://programmers.co.kr/learn/courses/30/lessons/42587
프린터 대기큐에서 우선순위가 높은 순서대로 프린트하기 위해
대기큐 시퀀스를 저장하는 일반 큐와 우선순위큐를 만든다ㅣ.
대기큐에서 프린트를 할지 결정할 때 우선순위가 더 높은 것이 있는지 확인하기 위해 우선순위큐를 사용한다.
완전탐색일 경우 최대 O(n)이 걸리지만 우선순위큐를 사용하므로 nlog(n)의 비교로 알 수 있따.
* */

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int []> waitQueue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for(int p : priorities){
            waitQueue.add(new int[]{index++, p});
            priorityQueue.add(p);
        }

        int answer = 0;
        while(!waitQueue.isEmpty()){
            int[] peek = waitQueue.peek();
            if(peek[1] == priorityQueue.peek()){
                waitQueue.poll();
                priorityQueue.poll();
                answer++;
                if(peek[0] == location){
                    return answer;
                }
            }else{
                waitQueue.add(waitQueue.poll());
            }
        }
        return answer;
    }
}
