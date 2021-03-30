package boj.prb70;

/*
https://www.acmicpc.net/problem/3197
구현
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main {

    private final static int[][] dirent = new int[][]{
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    private static int[] parent = new int[2250000];
    private static Queue<Point> queue = new LinkedList<>();
    private static List<Integer> swan = new ArrayList<>();
    private static char[][] map;
    private static int H, W;

    static {
        Arrays.fill(parent, -1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        for (int h = 0; h < H; h++) {
            String str = br.readLine();
            for (int w = 0; w < W; w++) {
                map[h][w] = str.charAt(w);
                if (map[h][w] != 'X') {
                    if (map[h][w] == 'L')
                        swan.add(f(w, h));
                    merge(w, h);
                }
            }
        }


        int ans = 0;
        while (!queue.isEmpty()) {
            if (find(swan.get(0)) == find(swan.get(1))) {
                System.out.println(ans);
                return;
            }
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point poll = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = poll.x + dirent[d][0], dy = poll.y + dirent[d][1];
                    if (dx < 0 || dx >= W || dy < 0 || dy >= H) continue;
                    if (map[dy][dx] == 'X') merge(dx, dy);
                }
            }
            ans++;
        }

    }

    public static int f(int x, int y) {
        return y * W + x;
    }

    public static int find(int u) {
        if (parent[u] == -1) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public static void merge(int x, int y) {
        map[y][x] = '.';
        queue.add(new Point(x, y));
        int pu = find(f(x, y)), pv = 0;
        for (int d = 0; d < 4; d++) {
            int dx = x + dirent[d][0], dy = y + dirent[d][1];
            if (dx < 0 || dx >= W || dy < 0 || dy >= H) continue;
            if (map[dy][dx] == '.') {
                pv = find(f(dx, dy));
                if (pu != pv)
                    parent[pv] = pu;
            }
        }
    }
}



