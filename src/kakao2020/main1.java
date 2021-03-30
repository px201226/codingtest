package kakao2020;

public class main1 {

    public static void main(String[] args) {


        Solution solution = new Solution();
        System.out.println(solution.solution("ababcdcdababcdcd"));
    }


}

class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder result = new StringBuilder();
        for(int i=1; i<=s.length()/2; i++){
            String prefix = s.substring(0,i);
            int count=1;
            for(int j=i; j<s.length(); j+=i){

                String compare = s.substring(j,j+i>s.length() ? s.length() : j+i);
                if(compare.equals(prefix)){
                    count++;
                }else{
                    if(count!=1){
                        result.append(count);
                    }
                    result.append(prefix);
                    count = 1;
                    prefix = compare;
                }
            }

            if(count!=1){
                result.append(count);
            }
            result.append(prefix);
            System.out.println(result);
            answer = Math.min(answer,result.length());
            result.delete(0,result.length());

        }
        return answer;
    }
}