package boj.prb159;

/*
https://www.acmicpc.net/problem/16165
걸그룹 마스터 준석이
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        HashMap<String, TreeSet<String>> membersByGroups = new HashMap<>();

        for(int t=0; t<N; t++){
            String group = br.readLine();
            membersByGroups.put(group, new TreeSet<>());
            int memberCount = Integer.parseInt(br.readLine());
            for(int i=0; i<memberCount; i++){
                String name = br.readLine();
                membersByGroups.get(group).add(name);
            }
        }

        for(int q=0; q<Q; q++){
            String query = br.readLine();
            int flag = Integer.parseInt(br.readLine());
            if(flag==0){
                TreeSet<String> strings = membersByGroups.get(query);
                for(String member : strings){
                    System.out.println(member);
                }
            }else{
                for(Map.Entry<String, TreeSet<String>> entry : membersByGroups.entrySet()){
                    if(entry.getValue().contains(query)){
                        System.out.println(entry.getKey());
                        break;
                    }
                }
            }
        }
    }

}