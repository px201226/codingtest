package boj.sixshop04;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("xyZA","xyZA"));
    }

    public String solution(String s1, String s2) {
        int len1 = 0, len2 = 0;
        String smaller = s1.length() < s2.length() ? s1 : s2;
        String larger = smaller.equals(s1) ? s2 : s1;

        for(int i=1; i<=smaller.length(); i++){
            String rear = smaller.substring(smaller.length()-i,smaller.length());
            String front = larger.substring(0,i);
            if(rear.equals(front)) len1=i;

            rear = larger.substring(larger.length()-i,larger.length());
            front = smaller.substring(0,i);
            if(rear.equals(front)) len2=i;
        }

        if(len1 > len2){
            return smaller + larger.substring(len1);
        }else if(len2 > len1){
            return larger + smaller.substring(len2);
        }else{
            String answer1 = smaller + larger.substring(len1);
            String answer2 = larger + smaller.substring(len2);
            return answer1.compareTo(answer2) < 0 ? answer1 : answer2;
        }
    }

}

