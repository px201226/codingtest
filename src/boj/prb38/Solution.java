package boj.prb38;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/17686

 * */
class Solution {
    public static void main(String[] args) {

        String[] files = new String[] {"img000012345", "i mg1.p123ng","img2","IMG02"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(files)));
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] split = new String[files.length][3];

        Pattern pattern = Pattern.compile("([a-z-.]+)([0-9]+)(.*)");
        for(int i=0; i<files.length; i++) {
            Matcher matcher = pattern.matcher(files[i].toLowerCase());
            while(matcher.find()){
                split[i][0] = matcher.group(1);
                split[i][1] = matcher.group(2);
                split[i][2] = String.valueOf(i);
                System.out.println(Arrays.toString(split[i]));
            }
        }
        Arrays.sort(split, (a,b) ->
                a[0].equals(b[0]) ? Integer.parseInt(a[1]) - Integer.parseInt(b[1]) : a[0].compareTo(b[0])
        );

        for(int i=0; i<split.length; i++){
            answer[i] = files[Integer.parseInt(split[i][2])];
        }
        return answer;
    }

}