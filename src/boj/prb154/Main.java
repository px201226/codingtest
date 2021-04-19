package boj.prb154;

/*
https://www.acmicpc.net/problem/1874
스택 수열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 1;
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(stack.peek() != num){
                if(stack.peek() > num){
                    System.out.println("NO");
                    return;
                }
                while (stack.peek() != num){
                    stack.push(count++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else if(stack.peek() == num){
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }

}