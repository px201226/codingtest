package boj.prb100;

/*
https://www.acmicpc.net/problem/2608
로마숫자
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static HashMap<String,Integer> romaNumbers = new HashMap<String, Integer>(){
        {
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
            put("IV",4);
            put("IX",9);
            put("XL",40);
            put("XC",90);
            put("CD",400);
            put("CM",900);
        }
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i=0; i<2; i++){
            String str = br.readLine();
            int pointer = 0;
            while (pointer < str.length()){
                for(int len=2; len>=1; len--){
                    if(pointer+len > str.length()) continue;
                    String sub = str.substring(pointer, pointer+len);
                    if(romaNumbers.containsKey(sub)){
                        pointer+=len;
                        answer += romaNumbers.get(sub);
                        break;
                    }
                }
            }
        }

            System.out.println(answer);
            StringBuilder builder = new StringBuilder("");

            for (int i = 1, idx = String.valueOf(answer).length() - 1; 1 <= 1000 && idx >= 0; i = i * 10, idx--) {
                int c = String.valueOf(answer).charAt(idx) - '0';
                int num = (String.valueOf(answer).charAt(idx) - '0') * i;
                String key = getKeyFromValue(romaNumbers, Integer.valueOf(num));
                if (!key.equals("null")) {
                    builder.insert(0, key);
                    continue;
                }
                int repeat = c > 5 ? c - 5 : c;

                String newKey = getKeyFromValue(romaNumbers, Integer.valueOf(1 * i));
                for (int j = 0; j < repeat; j++) {
                    builder.insert(0, newKey);
                }

                if(c>5){
                    String aa = getKeyFromValue(romaNumbers, Integer.valueOf(5 * i));
                    builder.insert(0, aa);
                    repeat = c -5;
                }
            }
            System.out.println(builder);

    }

    public static String getKeyFromValue(HashMap<String,Integer> map, Integer value){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(value)){
                return entry.getKey();
            }
        }
        return "null";
    }
}



