package kakao2019.main2.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.solution(5, new int[]{2,2,3,3,3,4});
    }
}

class Solution {
    class FailPerStage implements Comparable<FailPerStage>{
        public int stage;
        public int success;
        public int N;
        public double failPersent;

        public FailPerStage(int stage, int success, int n) {
            this.stage = stage;
            this.success = success;
            this.N = n;
            failPersent = success / (double) N;

        }

        @Override
        public int compareTo(FailPerStage o) {
            if (failPersent == o.failPersent){
                return stage - o.stage;
            }
            if(o.failPersent - failPersent > 0){
                return 1;
            }else{
                return -1;
            }
        }

        @Override
        public String toString() {
            return "FailPerStage{" +
                    "stage=" + stage +
                    ", success=" + success +
                    ", N=" + N +
                    ", failPersent=" + failPersent +
                    '}';
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] temp = new int[N+2];
        int size = stages.length;

        ArrayList<FailPerStage> failPerStages = new ArrayList<>();
        for(int stage : stages)
            temp[stage]++;

        for(int i=1; i<=N; i++){
            if(temp[i] == 0){
                failPerStages.add(new FailPerStage(i,0,1));
            }else{
                failPerStages.add(new FailPerStage(i, temp[i], size));
                size -= temp[i];
            }
        }

        Collections.sort(failPerStages);

        for(FailPerStage f : failPerStages){
            System.out.println(f
            );
        }
        answer = failPerStages.stream().mapToInt( (o) -> o.stage).toArray();
        return answer;
    }
}

