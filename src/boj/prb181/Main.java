package boj.prb181;

/*
https://www.acmicpc.net/problem/14425
문자열 집합
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N; i++) set.add(br.readLine());

        int ans = 0;
        for(int i=0;i<M; i++) {
            if(set.contains(br.readLine())) ans++;
        }
        System.out.print(ans);

    }
}