package boj.line03;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    class Pair extends Point {
        public Pair(int x, int y) {
            super(x, y);
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", x, y);
        }

    }

    private HashSet<Pair> pairs = new HashSet<>();
    private int[][] cache = new int[6][6];

    public static void main(String[] args) {
        int[] enter = new int[]{1,4,2,3};
        int[] leave = new int[]{2,1,4,3};
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(enter, leave)));
    }

    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];


        HashSet<Pair> dfs = DFS(enter, leave, 0, 0, new ArrayList<Integer>(), new HashSet<Pair>());
        for(Pair pair : dfs){
            answer[pair.x-1]++;
            answer[pair.y-1]++;
        }
        return answer;
    }

    public HashSet<Pair> DFS(final int[] enter, final int[] leave, int E, int L, List<Integer> entered, HashSet<Pair> comb) {
        if (L == leave.length) {
            return comb;
        }

        HashSet<Pair> union = new HashSet<>();
        HashSet<Pair> union1 = new HashSet<>();
        HashSet<Pair> tempComb = new HashSet<>(comb);
        ArrayList<Integer> tempEntered = new ArrayList<>(entered);

        if (tempEntered.size() >= 2) {
            for(int i=tempEntered.size()-2 ; i>=0; i--){
                tempComb.add(new Pair(tempEntered.get(entered.size()-1), tempEntered.get(i)));
            }
        }

        if (E < enter.length) {
            tempEntered.add(enter[E]);
            union =DFS(enter, leave, E + 1, L, tempEntered,tempComb);
        }


        tempEntered = new ArrayList<>(entered);
        if (tempEntered.contains(leave[L])) {
            tempEntered.remove(tempEntered.indexOf(leave[L]));
            union1 =(DFS(enter, leave, E , L + 1, tempEntered,tempComb));
        }

        if(union.isEmpty()) return union1;
        if(union1.isEmpty()) return union;
        union.retainAll(union1);
        return union;
    }

}

