package boj.prb68;

/*
https://www.acmicpc.net/problem/8911
구현
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static int[][] dirent = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++) {
            String command = br.readLine();
            int minX = 0, maxX = 0, minY = 0, maxY = 0;
            int curX = 0, curY = 0, curDir = 0;
            for(int i=0; i<command.length(); i++){
                char ch = command.charAt(i);
                if(ch=='F'){
                    int[] go = go(curX, curY, curDir);
                    curX = go[0];
                    curY = go[1];
                }else if(ch=='B'){
                    int[] back = back(curX, curY, curDir);
                    curX = back[0];
                    curY = back[1];
                }else if(ch=='L'){
                    curDir = curDir -1 < 0 ? 3 : curDir-1;
                }else{
                    curDir = curDir + 1 > 3 ? 0 : curDir+1;
                }
                maxX = Math.max(maxX,curX);
                maxY = Math.max(maxY,curY);
                minX = Math.min(minX,curX);
                minY = Math.min(minY,curY);
            }
            int x = Math.abs(maxX - minX);
            int y = Math.abs(maxY - minY);
            System.out.println(x*y);
        }
    }

    public static int[] go(int x, int y,int curDir){
        return new int[]{x+dirent[curDir][0], y+dirent[curDir][1]};
    }
    public static int[] back(int x, int y, int curDir){
        return new int[]{x+dirent[reverseDirent(curDir)][0], y+dirent[reverseDirent(curDir)][1]};
    }
    public static int reverseDirent(int dir){
        return (dir+2) % 4;
    }

}



