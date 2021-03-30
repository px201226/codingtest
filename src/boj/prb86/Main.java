package boj.prb86;

/*
https://www.acmicpc.net/problem/17413
단어뒤집기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder answer = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        boolean isTags = false;
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '<'){
                while(!stack.isEmpty()) answer.append(stack.pop());
                isTags = true;
            }

            if(isTags) {
                answer.append(ch);
                if(ch == '>') isTags = false;
            }else if(ch == ' '){
                while(!stack.isEmpty()) answer.append(stack.pop());
                answer.append(" ");
            }else
                stack.push(ch);
        }
        while(!stack.isEmpty()) answer.append(stack.pop());
        System.out.println(answer);
    }
}



