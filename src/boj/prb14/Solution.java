package boj.prb14;

/*
* https://programmers.co.kr/learn/courses/30/lessons/12905#
* DP
* arr[y][x] = [y][x] 지점에서 만들 수 있는 정사각형의 크기
* arr[y][x] = min(arr[y-1][x], arr[y][x-1], arr[y-1][x-1]) + 1;
* */
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        for(int y=1; y<board.length; y++){
            for(int x=1; x<board[0].length; x++){
                if(board[y][x] == 0) continue;
                int min = Math.min(Math.min(board[y][x-1],board[y-1][x]), board[y-1][x-1]);

                board[y][x] = min + 1;
                answer = Math.max(answer, board[y][x]);
            }
        }

        if(answer == 0){
            for(int i=0; i<board.length; i++)
                if(board[i][0] == 1) return 1;
            for(int i=0; i<board[0].length; i++)
                if(board[0][i] == 1) return 1;
        }

        return answer * answer;
    }
}