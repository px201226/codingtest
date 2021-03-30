package sort1;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[][]{});
        System.out.println(Arrays.toString(solution1));
    }
}


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx=0;
        for(int[] command : commands){
            int from = command[0] -1;
            int to = command[1];
            int k = command[2] -1;
            int[] tempArray = Arrays.copyOfRange(array,from,to);
            Arrays.sort(tempArray);
            answer[idx++] = tempArray[k];
        }
        return answer;
    }
}