package boj.kakao2;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {

        int[][] need = new int[][]{ {1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1} };

        Solution solution = new Solution();
        solution.solution(need,13);
    }
    public int solution(int[][] needs, int r) {
        int answer = comb(new ArrayList<>(),needs, needs[0].length, r,0);
        System.out.println(answer);
        return answer;
    }
    public int comb(List<Integer> list, int[][] needs, int N, int r, int begin){
        if(r==0){
            System.out.println(Arrays.toString(list.toArray()));
            int answer = 0;
            for(int i=0; i<needs.length; i++){
                boolean isSuccess = true;
                for(int j=0; j<needs[0].length; j++){
                    if(needs[i][j] == 1){
                        if(!list.contains(j)){
                            isSuccess = false;
                            break;
                        }
                    }
                }
                if(isSuccess) answer++;
            }
            System.out.println(answer);
            return answer;
        }

        int answer = Integer.MIN_VALUE;
        for(int i=begin; i<N; i++){
            list.add(i);
            answer = Math.max(answer,comb(list,needs,N,r-1,i+1));
            list.remove(list.size()-1);
        }

        return answer;
    }


}