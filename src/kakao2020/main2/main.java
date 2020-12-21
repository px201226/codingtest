package kakao2020.main2;

public class main {
    public static void main(String[] args) {

    }
}


class Solution {
    public String solution(String p) {
        if(p.equals("")) return "";
        int pivot = getPivot(p);
        String u = p.substring(0,pivot);
        String v = p.substring(pivot,p.length());

        if(isCollect(u)){
            return u + solution(v);
        }else{
            StringBuilder temp = new StringBuilder("(");
            temp.append(solution(v));
            temp.append(")");
            u = reverse(u);
            return temp.toString() + u;
        }

    }

    private String reverse(String u) {
        String result = u.substring(1,u.length()-1);
        return result.replace('(','}')
                        .replace(')','{')
                        .replace('{','(')
                        .replace('}',')');
    }

    private boolean isCollect(String u) {
        int count=0;
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '(')
                count++;
            else
                count--;

            if(count < 0) return false;
        }
        return count==0;
    }

    public int getPivot(String s){
        int open=0,close=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                open++;
            else
                close++;
            if(open == close)
                return i+1;
        }
        return s.length();
    }
}

