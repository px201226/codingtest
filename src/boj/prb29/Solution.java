package boj.prb29;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/72413
  Floyd 알고리즘을 이용해 A,B 탑승자의 K 지점을 구해
  * cost(s,k) + cost(k,a) + cost(k,b)가 최소가 되는 점을 구한다.
 * */

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2,new String[]{"abc","cde","efg","aa"});
    }
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        Set<String> set = new HashSet<>();

        int index=0, rotation=1;
        String prev = String.valueOf(words[0].charAt(0));
        for(String word : words){
            if(set.contains(word)) return new int[]{index+1,rotation};
            if(prev.charAt(prev.length()-1) != word.charAt(0)) return new int[]{index+1,rotation};
            prev = word;
            index++;
            set.add(word);
            if(index == n){
                index = 0;
                rotation++;
            }
        }

        return new int[]{0,0};
    }
}