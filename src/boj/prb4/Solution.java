package boj.prb4;

/*
https://programmers.co.kr/learn/courses/30/lessons/68645
그냥 구현문제라 알고리즘이 필요없다,
* */

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    private final static int[][] dirent = new int[][]{
            {0,1},{1,0},{-1,-1}
    };

    public int[] solution(int n) {

        int sum = IntStream.range(1,n+1).reduce((a,b) -> a+b).getAsInt();
        int[][] map = new int[n][n];
        int nx=0,ny=0,dx=0,dy=0;
        int dir=0, count=0;
        for(int i=0; i<sum; i++){
            map[ny][nx] = ++count;
            dx = nx + dirent[dir][0];
            dy = ny + dirent[dir][1];
            if(dx >= n || dy >= n || map[dy][dx] != 0){
                dir = (dir + 1) % 3;
                dx = nx + dirent[dir][0];
                dy = ny + dirent[dir][1];
            }
            nx = dx; ny = dy;
        }

        return  Arrays.stream(map).flatMapToInt(Arrays::stream).filter(a->a!=0).toArray();
    }
}