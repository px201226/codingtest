package boj.prb90;

/*
https://www.acmicpc.net/problem/2504
괄호의 값
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int temp = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
                temp *= 2;
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println("0");
                    return;
                }
                if (stack.peek() == '(') stack.pop();
                if (str.charAt(i - 1) == '(') answer += temp;
                temp /= 2;
            } else if (c == '[') {
                stack.push('[');
                temp *= 3;
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    System.out.println("0");
                    return;
                }
                if (stack.peek() == '[') stack.pop();
                if (str.charAt(i - 1) == '[') answer += temp;
                temp /= 3;
            }
        }
        System.out.println(stack.isEmpty() ? answer : "0");
    }
}



