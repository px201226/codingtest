package greedy2;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution("00000000",2));
    }
}

class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);

        int i;

        for (int j = 0; j < k; j ++)
        {
            for (i = 0; i < builder.length() - 1; i++)
            {
                if ((builder.charAt(i) - '0') < builder.charAt(i + 1) - '0')
                {
                    break;
                }
            }

            builder.deleteCharAt(i);
        }

        return builder.toString();
    }

    private int DFS(StringBuilder Numbers, int K, int count, int idx){

        int ret = 0;
        if(count == K){
            String value = Numbers.toString().replaceAll("-","");
            System.out.println(Numbers);
            return Integer.valueOf(value);
        }

        for(int i=idx; i<Numbers.length(); i++){
            char temp = Numbers.charAt(i);
            Numbers.replace(i,i+1, "-");
            ret = Math.max(ret, DFS(Numbers,K,count+1,i+1));
            Numbers.replace(i,i+1, String.valueOf(temp));
        }

        return ret;
    }
}

