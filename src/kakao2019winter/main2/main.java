package kakao2019winter.main2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();
       // solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        //solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution.solution("{{20,111},{111}}");
    }
}

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        for(String str:arr){
            System.out.println(str);
        }
        Pattern subSetReg = Pattern.compile("\\{.*?(\\d).*?}");
        Pattern numReg = Pattern.compile("([\\d]{1,6})");
        Matcher subMatcher = subSetReg.matcher(s);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        ArrayList<ArrayList<Integer>> subSetList = new ArrayList<>();

        while(subMatcher.find()){
            ArrayList<Integer> subset = new ArrayList<>();
            Matcher numMatcher = numReg.matcher(subMatcher.group(0));
            while (numMatcher.find()){
               subset.add(Integer.parseInt(numMatcher.group(0)));
            }
            subSetList.add(subset);
        }

        subSetList.sort( (a,b) -> a.size() - b.size());
        for(ArrayList<Integer> sub : subSetList){
            for(int num : sub){
                set.add(num);
            }
        }

        answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
