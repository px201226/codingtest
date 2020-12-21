package stack5;

import java.awt.desktop.QuitEvent;
import java.util.*;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new int[] {40, 93, 30, 55, 60, 65}, new int[]{60, 1, 30, 5 , 10, 7})));
    }
}


class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int doProgress = 100 - progresses[i];
            int doDay = doProgress / speeds[i];
            doDay = doProgress % speeds[i] != 0 ? doDay + 1 : doDay;
            queue.add(doDay);
        }


        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int endDay = queue.poll();
        while (!queue.isEmpty()){
            int nextEndDay = queue.poll();
            if(endDay >= nextEndDay){
                count++;
            }else{
                list.add(count);
                count=1;
                endDay = nextEndDay;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
