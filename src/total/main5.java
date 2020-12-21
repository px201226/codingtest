package total;

import java.util.Arrays;

public class main5 {
    public static void main(String[] args) {
        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};
        Solution5 solutio5 = new Solution5();
        solutio5.solution(words,queries);

    }
}

class Solution5 {
    public int[] solution(String[] words, String[] queries) {

        int[] answer = new int[queries.length];
        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int[] indexTable = new int[10000];
        int maxLength = 0;
        for(int i=0; i<words.length; i++){
            if(words[i].length() > maxLength){
                maxLength = words[i].length();
                indexTable[maxLength] = i;
            }
        }
        int idx=0;
        for(String query : queries){
            String reg = query.replace("?",".");
            int index = indexTable[reg.length()];
            int count = 0;
            for(int i=index; i<words.length; i++){
                if(words[i].length() > reg.length()) break;
                if(words[i].matches(reg)) count++;
            }
            answer[idx++]=count;
        }
        return answer;
    }
}