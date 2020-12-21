package kakao2020intership.main3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

       Solution solution = new Solution();
       solution.solution("100-200*300-500+20");
    }
}
class Solution {
    public static final String OPTRATIONS = "+-*";
    LinkedList<Long> opd = new LinkedList<>();
    ArrayList<int[]> opt = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            opd.add(Long.parseLong(matcher.group(0)));;
        }

        pattern = Pattern.compile("[*+-]+");
        matcher = pattern.matcher(expression);
        int idx =0;
        while (matcher.find()){
            int[] temp = new int[]{OPTRATIONS.indexOf(matcher.group(0)), idx++};
            opt.add(temp);
        }
        DFS(new int[3],0,0,3);
        System.out.println();
        return answer;
    }

    public long DFS(int[] priority, int chk, int idx, int n){
        long ret = 0;
        if(idx == n){

            for(int i=0; i<3; i++){
                for(int j=0; j<opt.size(); j++){
                    if(priority[i] == opt.get(j)[0]){
                        Long result = calc(opd.remove(j), opd.remove(j), opt.get(j)[0]);
                        opd.add(j, result);
                        opt.remove(j);
                        j--;
                    }
                }
            }
            return opd.remove(0);
        }

        for(int i=0; i<3; i++){
            if((chk & (1 << i)) == 0){
                priority[idx] = i;
                ret = Math.max(ret,DFS(priority,chk | (1 << i), idx+1, n));
            }
        }
        return ret;
    }

    public long calc(long num1, long num2, int opt) {
        switch (opt) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
        }
        return 0;
    }

}