package boj.kakao1;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */

import java.util.HashMap;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{5, 4, 5, 4, 5}, new int[]{1, 2, 3, 5, 4});
        System.out.printf("%d,%d\n", solution1,3);

        int solution2 = solution.solution(new int[]{1, 2, 3, 4, 5}, new int[]{2,2,1,1,1});
        System.out.printf("%d,%d\n", solution2,4);

        int solution3 = solution.solution(new int[]{1,1,1,1,1,1}, new int[]{0,0,0,0,0,0});
        System.out.printf("%d,%d\n", solution3,0);

    }
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        HashMap<Integer,Integer> cards = new HashMap<>();

        for(int num : gift_cards){
            cards.put(num,cards.getOrDefault(num,0)+1);
        }

        for(int num : wants){
            cards.put(num,cards.getOrDefault(num,0)-1);
        }

        for(int num: cards.values()){
           if(num < 0) answer+=Math.abs(num);
        }
        System.out.println(cards.toString());

        return answer;
    }

}