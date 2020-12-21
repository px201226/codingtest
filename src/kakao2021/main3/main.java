package kakao2021.main3;

import java.awt.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        String[] infos = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString( solution.solution(infos,query)));
    }
}

class Solution {
    public int[] solution(String[] infos, String[] querys) {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        int idx = 0;
        for(String info : infos){
            String[] splitInfo = info.split(" ");
            for(int i=0; i<=5; i++){
                ArrayList<Integer> row = map.get(splitInfo[i]);
                if(row == null) {
                    row = new ArrayList<>();
                    map.put(splitInfo[i],row);
                }
                row.add(idx);
            }
            idx++;
        }

        for(String query : querys){
            String[] splitQuery = query.split(" and ");
            System.out.println(Arrays.toString(splitQuery));
        }

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            ArrayList<Integer> list = map.get(key);
            System.out.println(key);
            System.out.println(Arrays.toString(list.toArray()));
        }

        return new int[]{2};
    }
}