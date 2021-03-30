package boj.prb6;
/*
https://programmers.co.kr/learn/courses/30/lessons/60057#
분할 정복 기법..
* */
public class Main {
    public int solution(String s) {
        int answer = 0;
        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = divide(s,i,1).length();
            answer = i ==1 ? result : (answer > result? result : answer);
        }
        return answer;
    }

    public String divide(String str, int slice, int repeat){
        if(str.length() < slice) return str;
        String result = "";
        String prefix = str.substring(0,slice);
        String postfix = str.substring(slice,str.length());

        if(!postfix.startsWith(prefix)){
            if(repeat == 1) return prefix + divide(postfix,slice,1);
            return Integer.toString(repeat) + prefix + divide(postfix,slice,1);
        }

        return divide(postfix,slice,repeat+1);
    }
}