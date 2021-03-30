package boj.prb60;

/*
https://www.acmicpc.net/problem/14719
구현
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] wall = new int[W];
        for (int i = 0; i < W; i++)
            wall[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++)
                left = Math.max(wall[j], left);
            for (int j = i + 1; j < W; j++)
                right = Math.max(wall[j], right);
            if (wall[i] < left && wall[i] < right)
                answer += Math.min(left, right) - wall[i];
        }
        System.out.println(answer);
    }

}