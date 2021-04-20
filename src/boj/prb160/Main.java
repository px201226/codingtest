package boj.prb160;

/*
https://www.acmicpc.net/problem/1327
소트게임
 * */

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine().replace(" ", "");
        String answer = sort(input);
        System.out.println(BFS(input,answer,K));
    }

    public static int BFS(String input, String answer, int k){
        Map<String,Boolean> isVisited = new HashMap<>();
        Queue<Map.Entry<String,Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(input,0));

        while (!queue.isEmpty()){
            Map.Entry<String, Integer> poll = queue.poll();
            if(poll.getKey().equals(answer)){
                return poll.getValue();
            }

            if(!isVisited.getOrDefault(poll.getKey(),false)){
                isVisited.put(poll.getKey(),true);
                for (int i = 0; i <= input.length() - k; i++) {
                    queue.add(Map.entry(reverse(poll.getKey(),i,i+k),poll.getValue()+1));
                }
            }

        }

        return -1;
    }

    public static String sort(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String reverse(String original, int begin, int end){
        StringBuilder answer = new StringBuilder("");
        answer.append(original.substring(0,begin));
        for(int i=end-1; i>=begin; i--)
            answer.append(original.charAt(i));
        answer.append(original.substring(end,original.length()));
        return answer.toString();
    }

}