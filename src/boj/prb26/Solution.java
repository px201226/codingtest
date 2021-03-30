package boj.prb26;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/72412/

 * */


import java.util.*;

public class Solution {
    Map<String, String> map = new HashMap<>() {
        {
            put("cpp", "0");
            put("java", "1");
            put("python", "2");
            put("backend", "0");
            put("frontend", "1");
            put("junior", "0");
            put("senior", "1");
            put("chicken", "0");
            put("pizza", "1");
            put("-", ".");
        }
    };

    public static void main(String[] args) {
        String[] info = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        Solution solution = new Solution();
        System.out.println( solution.upperBound(new ArrayList<Integer>(Arrays.asList(2)),1));
        System.out.println(Arrays.toString(solution.solution(info,query)));

    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, ArrayList<Integer>> cache = new HashMap<>();

        for(String inf : info){
            String[] arr = inf.split(" ");
            String key = map.get(arr[0]) + map.get(arr[1]) + map.get(arr[2]) + map.get(arr[3]);
            ArrayList<Integer> list = cache.getOrDefault(key, new ArrayList<Integer>());
            list.add(Integer.parseInt(arr[4]));
            cache.put(key,list);
        }
        for(ArrayList<Integer> list : cache.values()){
            Collections.sort(list);
        }

        int index = 0;
        for(String que : query){
            String[] arr = que.split(" ");
            String keyReg = map.get(arr[0]) + map.get(arr[2]) +map.get(arr[4]) + map.get(arr[6]);
            int score = Integer.parseInt(arr[7]);
            int count = 0;
            for(String key : cache.keySet()){
                if(!key.matches(keyReg)) continue;
                ArrayList<Integer> list = cache.get(key);
                int i = list.size() - upperBound(list, score);
                count += i;
            }
            answer[index++] = count;
        }
        return answer;
    }

    private  int upperBound(List<Integer> data, int target) {
        int begin = 0;
        int end = data.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data.get(mid) < target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}