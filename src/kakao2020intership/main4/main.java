package kakao2020intership.main4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new String[]{"A","A","A","B","C","A","D"}));
    }
}


class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1,gems.length};
        int minDistance = gems.length-1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(String gem : gems)
            set.add(gem);

        int start=0, end=0;
        while(end <= gems.length && start < gems.length){
            if(hashMap.size() < set.size()) {
                if(end >= gems.length) break;
                hashMap.put(gems[end], hashMap.getOrDefault(gems[end], 0) + 1);
                end++;
            }else{
                if(end - start < minDistance){
                    minDistance = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                hashMap.put(gems[start], hashMap.get(gems[start]) - 1);
                if(hashMap.get(gems[start]) == 0 )
                    hashMap.remove(gems[start]);
                start++;
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }


}
