package boj.prb19;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * 완전탐색
 * */


import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString( solution.solution("01110")));
    }

    public int[] solution(String s) {
        return DFS(s,0,0);
    }

    public int[] DFS(String s, int depth, int removeZero){
        if(s.equals("1")){
            return new int[]{depth,removeZero};
        }

        int zero = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') zero++;
        }
        String[] s1 = "dd".split(" ");
        Arrays.stream(s1).map(Integer::parseInt).collect(Collectors.toList());
        int length = s.replaceAll("0", "").length();
        String s2 = Integer.toBinaryString(length);
        return DFS(s2,depth+1,removeZero + zero);
    }
}