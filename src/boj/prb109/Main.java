package boj.prb109;

/*
https://www.acmicpc.net/problem/16197
두동전
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int[][] dir = new int[][]{ {0,-1},{1,0},{0,1},{-1,0}};
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        List<int []> balls = new ArrayList<>();
        for(int h=0;h<H;h++){
            String temp = br.readLine();
            for(int w=0; w<W; w++){
                map[h][w] = temp.charAt(w);
                if(map[h][w] == 'o') balls.add(new int[]{w,h});
            }
        }
        int answer = DFS(map,balls,0,-1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static int DFS(char[][] map, List<int[]> balls, int depth, int exceptionDir){
        if(depth > 10){
            return Integer.MAX_VALUE;
        }
        if(balls.size() == 1){
            return depth;
        }

        if(balls.size() == 0){
            return Integer.MAX_VALUE;
        }


        int answer = Integer.MAX_VALUE;
        for(int d=0; d<4; d++){
            if(d == exceptionDir) continue;
            boolean isMoved = false;
            List<int []> copyBalls = new ArrayList<>();
            for(int[] point : balls) copyBalls.add(new int[]{point[0],point[1]});
            Iterator<int[]> iterator = copyBalls.iterator();

            while (iterator.hasNext()){
                int[] point = iterator.next();
                int dx = point[0] + dir[d][0]; int dy = point[1] + dir[d][1];
//                System.out.println(Arrays.toString(point) + "가 " + d + "방향으로 가서");

                if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length){
                    iterator.remove();
//                    System.out.println("삭제되었");
                    isMoved = true;
                }else if (map[dy][dx] == '.' || map[dy][dx] == 'o'){
                    point[0] = dx; point[1] = dy;
//                    System.out.println("이동");
                    isMoved = true;
                }else {
//                    System.out.println("벽");
                }
            }

            if(isMoved){
//                System.out.println("isMoved");
                answer = Math.min(answer,DFS(map, copyBalls,depth+1,(d+2)%4));
            }else{
//                System.out.println("안움직임");
            }
        }
        return answer;
    }


}
