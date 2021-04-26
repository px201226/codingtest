package boj.prb171;

/*
https://www.acmicpc.net/problem/4949
균형잡힌 세상
 * */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty() && stack.peek()[0] < num){
                while(!stack.isEmpty() && stack.peek()[0] < num){
                    answer[stack.pop()[1]] = num;
                }
            }
            stack.push(new int[]{num,i});
        }

        while(!stack.isEmpty()){
            answer[stack.pop()[1]] = -1;
        }
        StringBuilder sb = new StringBuilder("");
        for(int num : answer) sb.append(num + " ");
        System.out.println(sb);
    }
}