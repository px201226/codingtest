package boj.wanted02;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dir = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };

    public static void main(String[] args) throws Exception {
        System.out.println(-123%10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for(int y=0; y<N; y++){
            String temp = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = temp.charAt(x);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] units = new int[2][2];
        units[0][1] = Integer.parseInt(st.nextToken());
        units[0][0] = Integer.parseInt(st.nextToken());
        units[1][1] = Integer.parseInt(st.nextToken());
        units[1][0] = Integer.parseInt(st.nextToken());
    }
//
//    private static int BFS(char[][] map, int[][] unit){
//
//        boolean[][] isVisited = new boolean[map.length][map.length];
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{unit[0][0],unit[0][1],unit[1][0],unit[1][1],0});
//
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            int[] poll = queue.poll();
//
//            for(int d=0; d<4; d++){
//                int dx1, dy1, dx2,dy2;
//                dx1 = move(poll[0], dir[d][0], map.length);
//                dy1 = move(poll[1], dir[d][1], map.length);
//                dx2 = move(poll[2], dir[d][0], map.length);
//                dy2 = move(poll[3], dir[d][1], map.length);
//
//                if(map[dy1][dx1] == 'X'){
//                    dx1 = poll[0]; dy1 = poll[1];
//                }
//                if(map[dy2][dx2] == 'X'){
//                    dx2 = poll[2]; dy2 = poll[3];
//                }
//                if(dx1 == poll[0] && dy1 == poll[1] && dx2 == poll[2] && dy2 == poll[3]) continue;
//
//                queue.add(new int[]{dx1,dy1,dx2,dy2,poll[4]+1});
//            }
//        }
//    }

    private static int move(int u, int d, int len){
        if(u+d < 0) return 0;
        else if(u+d >= len) return len-1;
        else return u+d;
    }
}

