package boj.prb37;


import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 * */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5,5));
    }
    public int solution(int N, int number) {

        Set<Long>[] cache = new HashSet[9];
        for(int i=1; i<=8; i++) cache[i] = new HashSet<>();


        for(int i=1; i<=8; i++){
            StringBuilder repeatNumber = new StringBuilder();
            for(int n=0; n<i; n++) repeatNumber.append(N);
            cache[i].add(Long.valueOf(repeatNumber.toString()));

            for(int j=1; j<i; j++){
                for(Long num1 : cache[j]){
                    for(Long num2 : cache[i-j]){
                        cache[i].add(num1+num2);
                        cache[i].add(num1-num2);
                        cache[i].add(num1*num2);
                        if(num2 !=0 ) cache[i].add(num1/num2);
                    }
                }
            }
            System.out.println(Arrays.toString(cache[i].toArray()));
            if(cache[i].contains(Long.valueOf(number))){
                return i;
            }
        }

        Queue<int[]> queue = new LinkedList<>();


        return -1;
    }
}