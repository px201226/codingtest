package boj.prb47;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 * */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    public int solution(int n) {
        return queens(new int[n+1],0);
    }
    public int queens(int col[], int index){
        int answer = 0;
        if(promising(col, index)){
            if(index == col.length-1)
                return 1;
            else{
                for(int i=1; i<col.length; i++){
                    col[index+1] = i;
                    answer+= queens(col,index+1);
                }
            }
        }
        return answer;
    }
    public boolean promising(int col[], int index){
        boolean flag = true;
        int i=1;
        while(i<index && flag){
            if(col[i] == col[index] || Math.abs(col[i] - col[index]) == index - i){
                flag = false;
            }
            i++;
        }
        return flag;
    }

}