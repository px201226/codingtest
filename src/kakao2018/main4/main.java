package kakao2018.main4;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("1S2D*3T");
    }
}


class Solution {
    class Log{
        public int point;
        public String bonus;
        public boolean isOption;
        public String option;
    }

    public int solution(String dartResult) {
        String powerTable = " SDT";
        int answer = 0;
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        ArrayList<Log> logs = new ArrayList<>();
        Stack<Integer> points = new Stack<>();
        while (matcher.find()){
            Log log = new Log();
            log.point = Integer.parseInt(matcher.group(1));
            log.bonus = matcher.group(2);
            if(!matcher.group(3).equals("")){
                log.isOption =true;
                log.option = matcher.group(3);
            }
            logs.add(log);

        }

        for(Log log : logs){

            int total = (int) Math.pow(log.point, powerTable.indexOf(log.bonus));
            if(log.isOption){
                if(log.option.equals("*")){
                    if(!points.isEmpty()){
                        points.add(points.pop() * 2);
                    }
                    total *=2;
                }else{
                    total *=-1;
                }
            }

            points.add(total);

        }

        for(int p : points)
            answer+=p;

        return answer;
    }
}