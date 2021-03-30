package boj.prb46;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 * */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ABCCBA"));
    }

    public int solution(String s) {
        int answer = 1;

        for (int left = 0; left < s.length() - 1; left++) {
            for (int right = s.length(); right > left; right--) {
                int strLength = right - left;
                if (strLength < answer) break;
                boolean flag = true;
                for (int i = 0; i < strLength / 2; i++) {
                    if (s.charAt(left + i) != s.charAt(right - i - 1)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) answer = Math.max(answer, strLength);
            }
        }


        return answer;
    }


}