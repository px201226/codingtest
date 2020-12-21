package heap2;

import java.util.*;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{ {0,3},{1,9},{2,6}}));
    }

}


class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0] );

        PriorityQueue<Work> workQueue = new PriorityQueue<Work>();
        int currentTime = 0, index=0, finish=0;
        while(finish < jobs.length){

            while(index < jobs.length && jobs[index][0] <= currentTime){
                workQueue.add(new Work(jobs[index][0],jobs[index][1]));
                index++;
            }

            if(!workQueue.isEmpty()){
                Work work = workQueue.peek();
                if(work.start <= currentTime){
                    workQueue.poll();
                    answer += (currentTime - work.start ) + work.time;
                    currentTime += work.time;
                    finish++;
                }
            }else{
                currentTime++;
            }
        }

        return answer/jobs.length;
    }

    private class Work implements Comparable<Work> {
        public int start;
        public int time;
        public Work(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            return time - o.time;
        }
    }
}
