package boj.line04;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String[] table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] lang = new String[]{"PYTHON", "C++", "SQL"};
        int[] pre = new int[]{7,5,5};
        Solution solution = new Solution();
        System.out.println(solution.solution(table,lang,pre));
    }
    class TableOfScore implements Comparable<TableOfScore>{
        public String name;
        public int score;

        public TableOfScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("[%s,%d] ",name,score);
        }

        @Override
        public int compareTo(TableOfScore o) {
            return score == o.score ? name.compareTo(o.name) : o.score  - score;
        }
    }
    public String solution(String[] table, String[] languages, int[] preference) {

        ArrayList<TableOfScore> result = new ArrayList<>();

        for(String row : table){
            HashMap<String, Integer> map = new HashMap<>();
            int index = 1;
            String[] s = row.split(" ");
            String name = s[0];
            for(int i=1; i<s.length; i++){
                map.put(s[i], 6-i);
            }

            int score = 0;
            for(int i=0; i<languages.length; i++){
                Integer matchIndex = map.getOrDefault(languages[i], 0);
                score += matchIndex * preference[i];
            }

            result.add(new TableOfScore(name,score));
        }

        Collections.sort(result);
        return result.get(0).name;
    }
}

