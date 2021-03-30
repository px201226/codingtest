package boj.prb8;

import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/42746
비교 알고리즘이 핵심
* */


class Solution {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();

        Integer[] wrapNumbers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(wrapNumbers, (a,b) -> {
            String x = a.toString() + b.toString();
            String y = b.toString() + a.toString();
            return -x.compareTo(y);
        });

        for(Integer a : wrapNumbers)
            answer.append(a);

        return answer.charAt(0) =='0' ? "0" : answer.toString();
    }
}