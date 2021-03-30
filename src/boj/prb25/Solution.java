package boj.prb25;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */


import java.util.*;

public class Solution {
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,4,5})));
    }

    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();
        int[] lens = new int[course[course.length-1] + 1];

        for(String order : orders){
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for(int cour : course)
                combination(chars,chars.length,cour,0,"");
        }

        for(String key : map.keySet())
            lens[key.length()] = lens[key.length()] < map.get(key) ? map.get(key) : lens[key.length()];

        System.out.println(Arrays.toString(lens));

        for(String key : map.keySet())
            if(map.get(key) == lens[key.length()] && lens[key.length()] >=2 )
                answer.add(key);

        Collections.sort(answer);
        return answer.stream().map(String::new).toArray(String[]::new);
    }

    public void combination(char[] chars, int n, int r, int start, String result) {
        if(r == 0){
            map.put(result, map.getOrDefault(result,0)+1);
            return;
        }

        for(int i=start; i<n; i++){
            combination(chars,n,r-1,i+1, result + chars[i]);
        }
    }

}