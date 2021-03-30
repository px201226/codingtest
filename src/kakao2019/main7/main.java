package kakao2019.main7;

public class main {

    public static void main(String[] args) {

        int[][] board = new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};

        Solution4 solution = new Solution4();
        System.out.println(solution.solution(board));
    }
}


class Solution4 {

    private int[][] board;
    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        int N = board.length;
        int cnt = 0;
        do {
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i <= N - 3 && j <= N - 2 && fill(j, i, 2, 3)) cnt++;
                    else if (i <= N - 2 && j <= N - 3 && fill(j, i, 3, 2)) cnt++;
                }
            }
            answer += cnt;
        }while (cnt !=0 );
        return answer;
    }

    private boolean fill(int x, int y, int dx, int dy) {

        int preview = -1;
        int emptyCount = 0;
        for(int r=y; r<y+dy; r++){
            for(int c=x; c<x+dx; c++){
                if(board[r][c] == 0){
                    emptyCount++;
                    if(!canDrop(c,r)) return false;
                    if(emptyCount > 2) return false;
                }else{

                    if(preview != -1 && board[r][c] != preview) return false;
                    preview = board[r][c];
                }
            }
        }
        if(emptyCount != 2) return false;
        for(int r=y; r<y+dy; r++) {
            for (int c = x; c < x + dx; c++) {
                board[r][c] = 0;
            }
        }
        return true;
    }

    private boolean canDrop(int c, int r) {
        for (int i = 0; i < r; i++)
            if (board[i][c] != 0) return false;
        return true;
    }
}
