package kakao2021.main1;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("12345678901234567"));
        //System.out.println(solution.solution("......1..............-.!@#"));
    }
}


class Solution {
    public String solution(String new_id) {
        String transId = new_id.toLowerCase();                                  //1단계 소문자

        transId = transId.replaceAll("[^a-z0-9._\\-]", "");       //2단계 특수문자 제거
        System.out.println(transId);
        transId = transId.replaceAll("[.]+", ".");             //3단게 연속된 . 제거

        if(transId.length() != 0 && transId.charAt(0) == '.') transId = transId.substring(1,transId.length());
        if(transId.length() != 0 && transId.charAt(transId.length()-1) == '.') transId = transId.substring(0,transId.length()-1);

        if(transId.length() == 0) transId = "a";
        if(transId.length() >= 16) transId = transId.substring(0,15);
        if(transId.length() != 0 && transId.charAt(transId.length()-1) == '.') transId = transId.substring(0,transId.length()-1);

        if(transId.length() <= 2){
            while(transId.length() <= 2){
                transId = transId + transId.charAt(transId.length()-1);
            }
        }

        return transId;
    }
}