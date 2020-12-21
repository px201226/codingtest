package kakao2020.main3;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        int[][] key = new int[][]{{1, 1,1}, {0, 0,0},{0,0,0}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1,0}};
        Solution solution = new Solution();
        System.out.println(solution.solution(key,lock));
    }
}

class Solution {
    public boolean solution(final int[][] key, final int[][] lock) {
        boolean answer = true;
        int padding = (key.length-1);
        int[][] expandArray = new int[lock.length+padding*2][lock.length+padding*2];
        int[][] rotateKey= key;

        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                expandArray[i+padding][j+padding] = lock[i][j];
            }
        }
    /*    for(int[] obj : expandArray)
            System.out.println(Arrays.toString(obj));
*/
        if (isSuccess(expandArray, padding, lock.length)) {
            return true;
        }

        for(int r=0; r<4; r++) {
            rotateKey = rotate2DArray(rotateKey);
            for (int i = 0; i < expandArray.length - padding; i++) {
                for (int j = 0; j < expandArray.length - padding; j++) {
                    int[][] temp = Arrays.stream(expandArray).map(int[]::clone).toArray(int[][]::new);
                    pushKey(rotateKey, temp, i, j);
                    System.out.println("");
                    if (isSuccess(temp, padding, lock.length)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public void pushKey(int[][] key, int[][] lock, int y, int x){

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                lock[y+i][x+j] += key[i][j];
            }
        }

   /*     for(int[] obj : lock)
            System.out.println(Arrays.toString(obj));*/

    }

    public boolean isSuccess(int[][] temp, int padding, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(temp[i+padding][j+padding]!=1)
                    return false;
            }
        }
        return true;
    }

    public int[][] rotate2DArray(int[][] array){
        int[][] rotateArray = new int[array.length][array.length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                rotateArray[i][j] = array[j][array.length-1-i];
            }
        }
        return rotateArray;
    }
}

