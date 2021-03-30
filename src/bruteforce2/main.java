package bruteforce2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println( solution.solution("011"));
    }
}


class Solution {

    Integer[] nums;
    boolean[] isPrime;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        nums = new Integer[numbers.length()];

        for(int i=0; i<numbers.length(); i++)
            nums[i] = Character.getNumericValue(numbers.charAt(i));

        Arrays.sort(nums,(i,j) -> j - i);
        int num = Integer.parseInt(Arrays.toString(nums).replaceAll("[^0-9]",""));
        isPrime = getCachePrimeList(num);
        permutation("", numbers, set,isPrime);
        return set.size();
    }

    public void permutation(String prefix, String str, HashSet<Integer> set, boolean[] isPrime) {
        int n = str.length();
        if (!prefix.equals("")){
            if(isPrime[Integer.valueOf(prefix)]){
                set.add(Integer.valueOf(prefix));
            }
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set, isPrime);
    }

    public boolean[] getCachePrimeList(int num){

        boolean[] primeList = new boolean[num+1];
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;
        for(int i=2; i<primeList.length; i++){

            if(primeList[i] == false)
                continue;

            for(int j=i+i; j<primeList.length; j=j+i){
                primeList[j] = false;
            }
        }

        return primeList;
    }
}

