package total;

public class main3 {
}
class Solution3 {
    public String solution(String p) {
        if(p.equals("")) return "";
        StringBuilder result = new StringBuilder("");

        int pivot = getPivot(p);
        String u = p.substring(0,pivot);
        String v = p.substring(pivot, p.length());
        if(isCollect(u)){
            return u+ solution(v);
        }else{
            result.append("(");
            result.append(solution(v));
            result.append(")");
            return result + reverse(u);
        }

    }

    public String reverse(String str){
        String result = str.substring(1, str.length()-1);
        return result.replace("(","}")
                        .replace(")", "{")
                        .replace("{", "(")
                        .replace("}",")");
    }
    public boolean isCollect(String str){
        int match=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                match++;
            }else{
                match--;
            }
            if(match < 0)
                return false;
        }
        return match == 0;
    }

    public int getPivot(String str){
        int open=0, close=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                open++;
            }else{
                close++;
            }

            if(open == close) return i+1;
        }
        return str.length();
    }
}