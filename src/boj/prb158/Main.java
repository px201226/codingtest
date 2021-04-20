package boj.prb158;

/*
https://www.acmicpc.net/problem/2841
외계인의 기타 연주
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack = new Stack[7];
        for(int i=0;i<=6; i++) {
            stack[i] = new Stack<>();
            stack[i].push(0);
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());
            while (stack[idx].peek() > flat){
                stack[idx].pop();
                answer++;
            }
            if(stack[idx].peek() < flat){
                stack[idx].push(flat);
                answer++;
            }
        }
        System.out.println(answer);
    }

}