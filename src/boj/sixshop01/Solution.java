package boj.sixshop01;


import javax.crypto.Mac;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    class Machine{
        public int state;
        public int index;
        public Machine(int state, int index) {
            this.state = state;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(3, new int[]{4, 2, 4, 5, 3});
        System.out.println(Arrays.toString(solution1));
    }

    public int[] solution(int N, int[] coffee_times) {
        List<Integer> answer = new ArrayList<>();
        Machine[] machines = new Machine[N];
        PriorityQueue<Integer> finishedQueue = new PriorityQueue<>();

        for(int i=0; i<machines.length; i++) machines[i] = new Machine(0,0);
        int coffeePointer = 1;

        while (answer.size() < coffee_times.length){

            // 비어 있는 머신에 할 일 추가
            for(int i=0; i<machines.length; i++){
                if(machines[i].index == 0 && coffeePointer <= coffee_times.length){
                    machines[i].state = coffee_times[coffeePointer-1];
                    machines[i].index = coffeePointer;
                    coffeePointer++;
                }
            }

            // 최소 값 찾기
            int min = getMinMachineState(machines);

            runMachines(machines, min);

            for(int i=0; i<machines.length; i++){
                if(machines[i].state == 0 && machines[i].index != 0){
                    finishedQueue.add(machines[i].index);
                    machines[i].index = 0;
                }
            }

            answer.add(finishedQueue.poll());
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    private void runMachines(Machine[] machines, int work) {
        for(int i=0; i<machines.length; i++){
            if(machines[i].index == 0) continue;
            machines[i].state -= work;
        }
    }

    private int getMinMachineState(Machine[] machines){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<machines.length; i++){
            if(machines[i].index == 0) continue;
            min = Math.min(min,machines[i].state);
        }
        return min;
    }
}

