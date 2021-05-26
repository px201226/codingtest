package boj.sixshop02;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{4,3,2,2,2,1,1,1})));
    }

    public int[] solution(int[] grades) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> countByGrade = new HashMap<>();
        for(int grade : grades){
            list.add(grade);
        }
        Collections.sort(list, Collections.reverseOrder());

        int prev = list.get(0)+1;

        for(int i=0; i<grades.length; i++){
            if(prev != list.get(i)){
                countByGrade.put(list.get(i), i+1);
                prev = list.get(i);
            }
        }

        int[] answer = new int[grades.length];
        for(int i=0; i<grades.length; i++) {
            int grade = grades[i];
            answer[i] = countByGrade.get(grade);
        }

        return answer;
    }
}

