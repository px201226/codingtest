package boj.prb166;

/*
https://programmers.co.kr/learn/courses/30/lessons/72411
메뉴리뉴얼
 * */
import java.util.*;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] orders =  new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = new int[]{1,2,3};
        System.out.println(Arrays.toString(solution.solution(orders,course)));
    }
    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();
        int[] countByLen = new int[100];
        Map<String,Integer> map = new HashMap<>();
        for(String order : orders){
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for(int i=2; i<=order.length(); i++)
                combination(chars,i,0,map,"");
        }

        for(String key : map.keySet()){
            if(map.get(key) > countByLen[key.length()]){
                countByLen[key.length()] = map.get(key);
            }
        }

        for(String key : map.keySet()){
            if(map.get(key) == countByLen[key.length()] && countByLen[key.length()] >= 2){
                answer.add(key);
            }
        }

        Collections.sort(answer);
        return answer.stream().map(String::new).toArray(String[]::new);
    }

    public void combination(char[] chars, int r, int idx, Map<String, Integer> map, String result){
        if(r == 0){
            map.put(result, map.getOrDefault(result,0)+1);
            return;
        }

        for(int i=idx; i<chars.length; i++){
            combination(chars,r-1,i+1,map,result+chars[i]);
        }

    }
}