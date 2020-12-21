package total;

import java.util.Arrays;

public class main4 {
}

class Solution4 {
    public boolean solution(final int[][] key, final int[][] lock) {
        boolean answer = false;

        int padding = (key.length-1);
        int[][] expandArray = new int[lock.length+padding*2][lock.length+padding*2];
        int[][] rotateKey= key;

        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                expandArray[i+padding][j+padding] = lock[i][j];
            }
        }

        if (isCompact(expandArray, padding)) {
            return true;
        }

        for(int r=0; r<4; r++) {
            rotateKey = rotate2DArray(rotateKey);
            for (int i = 0; i < expandArray.length - padding; i++) {
                for (int j = 0; j < expandArray.length - padding; j++) {
                    int[][] temp = Arrays.stream(expandArray).map(int[]::clone).toArray(int[][]::new);
                    pushKey(rotateKey, temp, i, j);
                    if (isCompact(temp, padding)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
    private void pushKey(int[][] key, int[][] board, int x, int y){
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                board[y+i][x+j] += key[i][j];
            }
        }
    }

    private boolean isCompact(int[][] board, int padding){
        for(int i=padding; i<board.length-padding; i++){
            for(int j=padding; j<board.length-padding; j++){
                if(board[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    public int[][] rotate2DArray(int[][] array){
        int[][] rotateArray = new int[array.length][array.length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                rotateArray[i][j] = array[array.length-1-j][i];
            }
        }
        return rotateArray;
    }
}