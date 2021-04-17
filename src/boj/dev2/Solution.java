package boj.dev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] solution1 = solution.solution(6,6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});

    }


    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        int count = 1 ;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++)
                array[i][j] = count++;
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<array.length; i++) System.out.println(Arrays.toString(array[i]));

        int idx = 0;
        for(int[] query : queries){
            List<Integer> outLineInArray = getOutLineInArray(array, query[1]-1, query[0]-1, query[3] - query[1]+1 , query[2] - query[0] );
            System.out.println(Arrays.toString(outLineInArray.toArray()));
            answer[idx++] = outLineInArray.stream().mapToInt(i->i).min().getAsInt();
            outLineInArray.add(0, outLineInArray.remove(outLineInArray.size()-1));
            fill(array, query[1]-1, query[0]-1, query[3] - query[1]+1 , query[2] - query[0],outLineInArray);
            for(int i=0; i<array.length; i++) System.out.println(Arrays.toString(array[i]));
            System.out.println("==");

        }
        System.out.println(Arrays.toString(answer));
        return null;

    }
    public List<Integer> fill(int[][] array, int x, int y, int width, int height, List<Integer> list){
        int increase = 1;
        int N = (width + height) * 2 -2;
        int idx = 0;
        x--;
        List<Integer> result = new ArrayList<>();

        while (true){
            for(int repeat=0; repeat<width; repeat++){
                x = x + increase;
                array[y][x] = list.get(idx++);
            }
            width--;
            if(idx >= list.size()) break;
            for(int repeat=0; repeat<height; repeat++){
                y = y + increase;
                array[y][x] = list.get(idx++);
            }
            height--;
            if(idx >= list.size()) break;
            increase *= -1;
        }

        return result;
    }
    public List<Integer> getOutLineInArray(int[][] array, int x, int y, int width, int height){
        int increase = 1;
        int N = (width + height) * 2 -2;
        x--;
        List<Integer> result = new ArrayList<>();

        while (true){
            for(int repeat=0; repeat<width; repeat++){
                x = x + increase;
                result.add(array[y][x]);
            }
            width--;
            if(result.size() >= N) break;
            for(int repeat=0; repeat<height; repeat++){
                y = y + increase;
                result.add(array[y][x]);
            }
            height--;
            if(result.size() >= N) break;
            increase *= -1;
        }

        return result;
    }
}