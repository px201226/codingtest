package boj.prb5;

/*
https://programmers.co.kr/learn/courses/30/lessons/68645
그냥 구현문제라 알고리즘이 필요없다,
* */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solutsion solutsion = new Solutsion();
        System.out.println(Arrays.toString(solutsion.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}})));
       }
}

class Solutsion {
    private final int dirent[][] = new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };

    public int[] solution(int m, int n, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(picture[y][x] == 0) continue;
                q.add(new int[]{y,x});
                numberOfArea++;
                int base = picture[y][x];
                int count = 0;
                System.out.println("mm");
                while(!q.isEmpty()){
                    int[] p = q.poll();
                    System.out.println(Arrays.toString(p));
                    maxSizeOfOneArea = Math.max(++count,maxSizeOfOneArea);
                    picture[p[0]][p[1]] = 0;
                    for(int d=0; d<4; d++){
                        int dy = p[0] + dirent[d][0];
                        int dx = p[1] + dirent[d][1];
                        if(dx<0 || dx >= n || dy < 0 || dy >= m || picture[dy][dx] != base || picture[dy][dx] == 0) continue;

                        q.add(new int[]{dy,dx});
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}