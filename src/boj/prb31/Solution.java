package boj.prb31;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 스택 활용
 * */

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("accadd"));
    }

    public int solution(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}