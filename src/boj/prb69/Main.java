package boj.prb69;

/*
https://www.acmicpc.net/problem/11559
구현
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private final static int[][] dirent = new int[][]{
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[12][6];

        for (int r = 0; r < 12; r++) {
            String s = br.readLine();
            for (int c = 0; c < 6; c++) {
                map[r][c] = s.charAt(c);
            }
        }

        int count = 0;
        while (true) {
            boolean isDelete = false;
            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 6; x++) {
                    if(map[y][x] == '.') continue;
                    if (BFS(map, x, y)) {
                        isDelete = true;

                    }
                }
            }

            if (isDelete) {
                count++;
                gravity(map);
            }

            if (!isDelete) {
                System.out.println(count);
                return;
            }
        }

    }

    public static boolean BFS(char[][] map, int x, int y) {

        List<int[]> deleteList = new ArrayList<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        isVisited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0], ny = poll[1];
            char color = map[ny][nx];
            deleteList.add(new int[]{nx, ny});

            for (int d = 0; d < 4; d++) {
                int dx = nx + dirent[d][0];
                int dy = ny + dirent[d][1];
                if (dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length)
                    continue;
                if (isVisited[dy][dx])
                    continue;
                if (map[dy][dx] == color) {
                    queue.add(new int[]{dx, dy});
                    isVisited[dy][dx] = true;
                }
            }
        }

        if (deleteList.size() >= 4) {
            for (int[] point : deleteList) {
                map[point[1]][point[0]] = '.';
            }
            return true;
        }
        return false;
    }

    public static void gravity(char[][] map) {
        for (int c = 0; c < 6; c++) {
            for (int r = map.length-1; r >= 1; r--) {
                if (map[r][c] == '.') {
                    for (int i = r-1; i >= 0; i--) {
                        if(map[i][c] == '.') continue;
                        map[r][c] = map[i][c];
                        map[i][c] = '.';
                        break;
                    }
                }
            }
        }
    }

}



