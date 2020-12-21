package total;


import java.util.Stack;

public class main1 {
}

class Solution15 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int pick : moves){
            int pickDoll = pickBoard(board, pick -1);
            if (pickDoll == -1) continue;
            answer += pushDoll(stack,pickDoll);
        }
        return answer;
    }

    public int pickBoard(int[][] board, int x){
        for(int y=0; y<board[0].length; y++){
            if(board[y][x] != 0){
                int temp = board[y][x];
                board[y][x] = 0;
                return temp;
            }
        }
        return -1;
    }

    public int pushDoll(Stack<Integer> stack, int doll){
        if(stack.isEmpty()){
            stack.push(doll);
            return 0;
        }

        if(stack.peek() == doll){
            stack.pop();
            return 2;
        }else{
            stack.push(doll);
            return 0;
        }
    }
}