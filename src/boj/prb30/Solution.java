package boj.prb30;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12951
  공백이 연속으로 되어있는 케이스를 고려할 수 있는지가 포인트
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("   acd ccd   "));
    }
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");

        Pattern pattern = Pattern.compile("([ ]*)([0-9a-zA-Z]+)([ ]*)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
           // System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            for(int i=1; i<=3; i++){
                String str = matcher.group(i);
                if (str.equals("")) continue;
                StringBuilder temp = new StringBuilder(str.toLowerCase());
                if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'z')
                    temp.setCharAt(0, (char) (temp.charAt(0) - 32));
                answer.append(temp);
            }
        }
        return answer.toString();
//
//        for(String str : split){
//            System.out.println(str);
//            if(str.equals("")){
//                answer.append(" ");
//                continue;
//            }
//            StringBuilder temp = new StringBuilder(str.toLowerCase());
//            if(temp.charAt(0) >= 'A' && temp.charAt(0) <= 'z')
//                temp.setCharAt(0, (char) (temp.charAt(0) - 32));
//            answer.append(temp + " ");
//        }
//        return answer.delete(answer.length()-1,answer.length()).toString();
    }
}