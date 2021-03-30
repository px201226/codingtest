package boj.prb77;

/*
https://www.acmicpc.net/problem/10773
제로
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(num);
            }
        }
        System.out.println(stack.stream().mapToInt(i->i).sum());
    }

}



