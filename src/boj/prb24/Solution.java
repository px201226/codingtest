package boj.prb24;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public String solution(String new_id) {
        String s = new_id.toLowerCase()
                .replaceAll("[^a-z0-9\\-_\\.]", "")
                .replaceAll("\\.{2,}", ".")
                .replaceAll("^\\.","")
                .replaceAll("\\.$","");

        if(s.length() == 0) s = "a";
        if(s.length() > 15)
            s = s.substring(0,15).replaceAll("\\.$","");
        if(s.length() == 2)
            s = s + s.charAt(1);
        if(s.length() == 1)
            s = s + s + s;
        return s;
    }

}