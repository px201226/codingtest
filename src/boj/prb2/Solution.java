package boj.prb2;

/*
https://programmers.co.kr/learn/courses/30/lessons/49993
* */

class Solution {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] tress =  {"BACDE", "CBADF", "AECB", "BDA"};
        new Solution().solution(skill,tress);
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String seq : skill_trees){
            String replace = seq.replaceAll("[^" + skill + "]", "");
            if(skill.startsWith(replace)) answer++;
        }
        return answer;
    }
    /*public int solution(String skill, String[] skill_trees) {
        int answer = 0;


        for(String seq : skill_trees){
            boolean isOrder = true;
            char[] parent = new char[26];
            Arrays.fill(parent,'0');
            for(int i=1; i<skill.length(); i++){
                parent[skill.charAt(i) - 'A'] = (char) (skill.charAt(i-1) - 'A');
            }

            for(int i=0; i<seq.length(); i++){
                char c = (char) (seq.charAt(i) - 'A');
                if(parent[c] == '0' || parent[c] == '1'){
                    parent[c] = '1';
                    continue;
                }

                if(parent[parent[c]] == '1'){
                    parent[c] = '1';
                }else{
                    isOrder = false;
                    break;
                }
            }
            System.out.println(isOrder);
            if(isOrder) answer++;
        }

        return answer;
    }*/
}