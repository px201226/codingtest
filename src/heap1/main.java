package heap1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println( solution.solution(new int[]{1,2,3}, 6) );
    }
}


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(scoville).forEach( a -> pq.add(a));

        while(true){
            int lowScovile = pq.poll();
            if(lowScovile >= K )
                return answer;
            if(pq.size() == 0) return -1;

            pq.offer(lowScovile + (pq.poll() * 2));

            answer++;
        }
    }
}