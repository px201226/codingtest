package boj.prb180;

/*
https://www.acmicpc.net/problem/1431
시리얼번호
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(Arrays.toString(stack.toArray()));

        reverseStack(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int data = stack.pop();
        reverseStack(stack);
        insertStack(stack,data);
    }

    public static void insertStack(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertStack(stack,data);
        stack.push(temp);
    }
}
