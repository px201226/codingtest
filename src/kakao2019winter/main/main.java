package kakao2019winter.main;

import java.awt.*;
import java.util.Stack;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println( solution.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[] {1,5,3,5,1,2,1,4}));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            int y = pick(board, move-1);
            int character = board[y][move-1];
            board[y][move-1] = 0;
            if(character == 0) continue;
            if(stack.isEmpty()){
               stack.push(character);
            }else{
                answer += calcPoint(stack, character);
            }

        }

        return answer;
    }

    private int calcPoint(Stack<Integer> stack, int character) {
        if(stack.peek() == character){
            stack.pop();
            return 2;
        }
        stack.push(character);
        return 0;
    }

    public int pick(int[][] board, int x){
        int ret = board.length-1;
        for(int y=0; y<board.length; y++){
            if(board[y][x] != 0) {
                return y;
            }
        }
        return ret;
    }
}


