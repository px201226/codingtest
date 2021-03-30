package stack3;

import java.util.*;


public class main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution(new int[]{2,1,3,2},2));
    }
}

class Solution {

    public int solution(int[] priorities, int location) {

        int answer = 0;
        Queue<int[]> waitQueue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int i = 0;
        for(int priority : priorities){
            waitQueue.add(new int[]{i++, priority});
            priorityQueue.add(priority);
        }

        while(!waitQueue.isEmpty()){
            int[] work = waitQueue.poll();

            if(work[1] == priorityQueue.peek()){
                priorityQueue.poll();
                answer++;
                if(work[0] == location)
                    break;
            }else{
                waitQueue.offer(work);
            }
        }
        return answer;
    }

}