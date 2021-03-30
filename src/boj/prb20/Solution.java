package boj.prb20;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12939/solution_groups?language=java&type=my
 * 완전탐색
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        List<Integer> list = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());

        return String.format("%d %d", Collections.min(list),Collections.max(list));
    }
}