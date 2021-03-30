package heap3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main {
}


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> refHeap;
        int heapSize = 0;
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation," ");
            char operator = st.nextToken().charAt(0);
            int operand = Integer.parseInt(st.nextToken());
            switch (operator){
                case 'I':
                    if(heapSize == 0){
                        maxHeap.clear(); minHeap.clear();
                    }
                    maxHeap.offer(operand); minHeap.offer(operand);
                    heapSize++;
                    break;

                case 'D':
                    if(operand > 0) {
                        refHeap = maxHeap;
                    }else {
                        refHeap = minHeap;
                    }
                    if(heapSize != 0) {
                        refHeap.poll();
                        heapSize--;
                    }

                    break;

                default:
                    throw new IllegalArgumentException();
            }
        }

        if(heapSize == 0)
            answer = new int[]{0,0};
        else{
            answer = new int[]{maxHeap.poll(), minHeap.poll()};
        }
        return answer;
    }
}
