package boj.prb131;

/*
https://www.acmicpc.net/problem/2304
창고 다각형, 스택
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[1001];
        int left = 1001, right = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            heights[idx] = height;
            left = Math.min(left,idx);
            right = Math.max(right,idx);
        }

        Stack<Integer> stack = new Stack<>();
        int pivot = heights[left];
        for(int i=left+1; i<=right; i++){
            if(pivot > heights[i]) stack.push(i);
            else{
                while (!stack.isEmpty()){
                    heights[stack.pop()] = pivot;
                }
                pivot = heights[i];
            }
        }
        stack.clear();
        pivot = heights[right];
        for(int i=right-1; i>=left; i--){
            if(pivot > heights[i]) stack.push(i);
            else{
                while (!stack.isEmpty()){
                    heights[stack.pop()] = pivot;
                }
                pivot = heights[i];
            }
        }
        System.out.println(Arrays.stream(heights).sum());
    }

}
