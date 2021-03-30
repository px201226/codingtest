package boj.prb11;


import java.util.*;

public class Main {

    private final int[][] shape = new int[][]{
            {0,1},
            {1,0}
    };
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
        System.out.println(args.length);

    }
}

class Solution {
    public int solution(String[][] relation) {

        List<Integer> cadidateKeys = new ArrayList<>();
        combination(relation,  cadidateKeys);
        System.out.println(Arrays.toString(cadidateKeys.toArray()));
        return cadidateKeys.size();
    }

    public void combination(String[][] relation, List<Integer> candidateKey) {

        for(int select=1; select < (1 << relation[0].length); select++) {

            System.out.println(select);
            Set<String> set = new HashSet<>();
            boolean isDuplicate = false;
            for (int candidate : candidateKey) {
                if ((candidate & select) == candidate) {
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate) continue;
            for (int j = 0; j < relation.length; j++) {
                StringBuilder str = new StringBuilder("");
                for (int i = 0; i < relation[0].length; i++) {
                    if ((select & (1 << i)) > 0) {
                        str.append(relation[j][i] + ",");
                    }
                }
                set.add(str.toString());
            }

            if (set.size() == relation.length) {
                candidateKey.add(select);
            }

        }

    }
}