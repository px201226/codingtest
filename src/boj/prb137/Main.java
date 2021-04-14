package boj.prb137;

/*
https://www.acmicpc.net/problem/1342
행운의 문자열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] frequency = new int[26];
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i) - 'a']++;
        }
        System.out.println(DFS(frequency, 0, -1, str.length()));

    }

    public static int DFS(int[] frequency, int depth, int prev, int N) {
        if (depth == N) {
            return 1;
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (i == prev) continue;
            if (frequency[i] == 0) continue;
            frequency[i]--;
            answer += DFS(frequency, depth + 1, i, N);
            frequency[i]++;
        }

        return answer;

    }
}
