package boj.line02;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("CaCbCgCdC888834A")));
    }
    public int[] solution(String inp_str) {
        ArrayList<Integer> list = new ArrayList<>();

        if(!isCorrectLength(inp_str))
            list.add(1);
        if(!isCorrectLetter(inp_str))
            list.add(2);
        if(!isContain3Patterns(inp_str))
            list.add(3);
        if(!isNotExceed4Repeat(inp_str))
            list.add(4);
        if(!isEqualLetter5Count(inp_str))
            list.add(5);
        if(list.isEmpty()){
            return new int[]{0};
        }
        return  list.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean isCorrectLength(String str){
        return 8 <= str.length()  && str.length() <= 15;
    }

    public boolean isCorrectLetter(String str){
        Pattern pattern = Pattern.compile("([^a-zA-Z0-9~!@#$%^&*])");
        Matcher matcher = pattern.matcher(str);
        return !matcher.find();
    }

    public boolean isContain3Patterns(String str){
        int corret = 0;
        Pattern pattern1 = Pattern.compile("([a-z])");
        Pattern pattern2 = Pattern.compile("([A-Z])");
        Pattern pattern3 = Pattern.compile("([0-9])");
        Pattern pattern4 = Pattern.compile("([~!@#$%^&*])");

        if(pattern1.matcher(str).find()) corret++;
        if(pattern2.matcher(str).find()) corret++;
        if(pattern3.matcher(str).find()) corret++;
        if(pattern4.matcher(str).find()) corret++;

        return corret >= 3;
    }
    public boolean isNotExceed4Repeat(String str){
        int max = 0;
        int repeat = 1;
        char prev = str.charAt(0);
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == prev){
                repeat++;
            }else{
                repeat=1;
            }
            prev = str.charAt(i);
            max = Math.max(repeat, max);
        }
        return max < 4;
    }
    public boolean isEqualLetter5Count(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) +1);
        }
        Collection<Integer> values = map.values();
        for(Integer repeat : values){
            if(repeat>=5) return false;
        }
        return true;
    }
}

