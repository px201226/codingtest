package boj.dev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] solution1 = solution.solution(6,6, new int[][]{{2,2,2,2},{3,3,6,6},{5,1,6,3}});
         System.out.println(Arrays.toString(solution1));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] maps = new int[rows][columns];

        int count =1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                maps[i][j] = count++;
            }
        }
        int[] answer = new int[queries.length];
        int idx =0;
        for(int[] query : queries){
            int min = rotate(maps,query[0],query[1],query[2],query[3]);
            answer[idx++]=min;
        }
        return answer;

    }

    public int rotate(int[][] maps, int x1, int y1, int x2, int y2){
        x1--;y1--;x2--;y2--;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for(int w=y1; w<=y2; w++){
            list.add(maps[x1][w]);
        }

        for(int h=x1+1; h<=x2; h++){
            list.add(maps[h][y2]);
        }

        for(int w=y2-1; w>=y1; w--){
            list.add(maps[x2][w]);
        }

        for(int h=x2-1; h>=x1+1; h--){
            list.add(maps[h][x1]);
        }

        int temp = list.get(list.size()-1);
        for(int i=list.size()-1; i>=1; i--) {
            list.set(i, list.get(i-1));
        }
        list.set(0,temp);
        int answer = list.stream().mapToInt(i->i).min().getAsInt();
        for(int w=y1; w<=y2; w++){
            maps[x1][w] = list.remove(0);
        }
        for(int h=x1+1; h<=x2; h++){
            maps[h][y2] = list.remove(0);
        }

        for(int w=y2-1; w>=y1; w--){
            maps[x2][w] = list.remove(0);
        }

        for(int h=x2-1; h>=x1+1; h--){
            maps[h][x1] = list.remove(0);
        }
        return answer;
    }
}