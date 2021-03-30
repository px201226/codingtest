package boj.prb7;

import java.util.HashSet;
import java.util.Set;

/*
https://programmers.co.kr/learn/courses/30/lessons/60057#
분할 정복 기법..
* */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution("011");
        System.out.println(solution1);
    }
}

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation(set, numbers,new boolean[numbers.length()], "", 0);
        int max = set.stream().max(Integer::compareTo).get().intValue();
        boolean[] primaryCache1 = getPrimaryCache(max);
        for(Integer i : set){
            if(primaryCache1[i.intValue()] == false) answer++;
        }
        return answer;
    }
    public void permutation(Set<Integer> set, String number, boolean[] isSelect, String build, int depth){
        if(depth > number.length()){
            return;
        }

        for(int i=0; i<number.length(); i++){
            if(isSelect[i]) continue;
            isSelect[i] = true;
            String number1 = build + number.charAt(i);
            set.add(Integer.parseInt(number1));
            permutation(set,number,isSelect, number1, depth+1);
            isSelect[i] = false;
        }
    }

    public boolean[] getPrimaryCache(int N){
        boolean cache[] = new boolean[N+1];
        cache[0] = cache[1] = true;

        for(int i=2; i*i<=N; i++){
            if(cache[i] == true) continue;
            for(int j=2; i*j <= N; j++){
                cache[i*j] = true;
            }
        }
        return cache;
    }
}