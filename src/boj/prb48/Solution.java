package boj.prb48;

/*
https://www.acmicpc.net/problem/2493
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                int[] peek = stack.peek();
                if(peek[0] < num){
                    stack.pop();
                }else{
                    System.out.print(peek[1] + " ");
                    break;
                }
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(new int[]{num,i+1});
        }
    }
}

