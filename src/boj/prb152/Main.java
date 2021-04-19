package boj.prb152;

/*
https://www.acmicpc.net/problem/9012
괄호
 * */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String cmd = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<cmd.length(); j++){
                if(cmd.charAt(j) == '(') stack.push('(');
                else if(cmd.charAt(j) == ')' && !stack.isEmpty())
                    stack.pop();
                else{
                    stack.push('(');
                    break;
                }
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }

}