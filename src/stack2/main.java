package stack2;

import java.util.Arrays;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] ret = solution.solution(new int[]{1,5,3,6,7,6,5});
        System.out.println(Arrays.toString(ret));
    }
}


class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<heights.length; i++){

            int receivedIndex = 0;
            while(!stack.isEmpty()){

                int[] compare = stack.peek();
                if(compare[1] > heights[i]){
                    receivedIndex = compare[0];
                    break;
                }
                stack.pop();
            }

            stack.push(new int[]{i+1,heights[i]});
            answer[i] = receivedIndex;
        }

        return answer;
    }
}

