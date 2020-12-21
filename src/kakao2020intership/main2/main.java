package kakao2020intership.main2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("3*2*2*2");
    }
}

class Solution {
    public long solution(String expression) {
        long answer = 0;
        Pattern reg = Pattern.compile("[0-9]+\\*[0-9]+");
        System.out.println(        expression.replaceAll(reg.toString(),"5"));
        Matcher matcher = reg.matcher(expression);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
        return answer;
    }
}
