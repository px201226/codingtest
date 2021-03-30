package kakao2020intership.main5;

import java.util.LinkedList;
import java.util.Queue;

public class main {

    public static void main(String[] args) {
        int[][] board1 = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board3 = new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};

        Solution solution = new Solution();
        System.out.println(solution.solution(board1));
        System.out.println(solution.solution(board2));
        System.out.println(solution.solution(board3));

    }
}

class Solution {

    private static final int[][] DIRENT = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] board) {
        int answer = getMinimumPayment(board);
        return answer;
    }

    public int getMinimumPayment(int[][] board) {
        int ret = Integer.MAX_VALUE;
        //[x,y,dir,cost]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, -1, 0,0,0});

        while (!queue.isEmpty()) {

            int[] item = queue.poll();
            int x = item[0]; int y = item[1]; int dir = item[2]; int cost = item[3];

            if (x == board.length - 1 && y == board.length - 1) {
                ret = Math.min(ret, cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DIRENT[i][0];
                int ny = y + DIRENT[i][1];
                if (nx < board.length && ny < board.length && nx >= 0 && ny >= 0 && board[ny][nx] != 1) {
                    int addCost = (dir != -1 && dir != i) ? 600 : 100;
                    if(board[ny][nx] == 0 || board[ny][nx] >= cost + addCost){
                        board[ny][nx] = cost + addCost;
                        queue.add(new int[]{nx,ny,i,cost + addCost, item[4] + 1, item[5] + (addCost == 600 ? 1 : 0)});
                    }
                }
            }
        }
        return ret;
    }
}


