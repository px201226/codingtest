package boj.prb15;

/*
* https://programmers.co.kr/learn/courses/30/lessons/12909
* */
class Solution {
    boolean solution(String s) {
        int open = 0;

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(ch == '(') open++;
            else open--;
            if(open < 0) return false;
        }

        return open == 0;
    }
}