package kakao2020.main4;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {


        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        Solution solution = new Solution();
        String[] strings = {"frozz", "frozen"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(solution.solution(words, queries)));
    }
}


class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Arrays.sort(words, (s1, s2) -> compareTo(s1, s2));
        String[] rwords = Arrays.stream(words).map((a) -> new StringBuilder(a).reverse().toString()).toArray(String[]::new);
        Arrays.sort(rwords, (s1, s2) -> compareTo(s1,s2));

        int idx=0, lo,hi, first;

        for(String query : queries){
            if(query.charAt(0) == '?'){

                StringBuilder newQuery = new StringBuilder(query).reverse();
                first = newQuery.indexOf("?");
                for(int i=first; i<newQuery.length(); i++) newQuery.setCharAt(i, 'a');
                lo = lowerBound(rwords, newQuery.toString());
                for(int i=first; i<newQuery.length(); i++) newQuery.setCharAt(i, 'z');
                hi = upperBound(rwords, newQuery.toString());

            }else{
                StringBuilder newQuery = new StringBuilder(query);
                first = newQuery.indexOf("?");
                for(int i=first; i<newQuery.length(); i++) newQuery.setCharAt(i, 'a');
                lo = lowerBound(words, newQuery.toString());
                for(int i=first; i<newQuery.length(); i++) newQuery.setCharAt(i, 'z');
                hi = upperBound(words, newQuery.toString());

            }
            answer[idx++] = hi-lo;
        }
        return answer;
    }

    public int lowerBound(String[] array, String value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (compareTo(array[mid], value) >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int upperBound(String[] array, String value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(compareTo(array[mid], value) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int compareTo(String s1, String s2){
        return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
    }
}