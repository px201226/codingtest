package boj.prb13;

/*
*https://programmers.co.kr/learn/courses/30/lessons/68936
* 분할정복xx
* */
class Solution {
    public int[] solution(int[][] arr) {
        int zero = 0;
        int one = 0;

        String str = quard(arr,0,0, arr.length);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                zero++;
            }else{
                one++;
            }
        }
        int[] answer = {zero, one};

        return answer;
    }

    public String quard(int[][] arr, int x, int y, int N){
        if(N == 1) return String.valueOf(arr[y][x]);
        if(isAllEquals(arr,x,y,N)) return String.valueOf(arr[y][x]);
        StringBuilder str = new StringBuilder("");
        int n = N/2;

        for(int yk=0; yk<2; yk++){
            for(int xk=0; xk<2; xk++){
                int nx = x + (n * xk);
                int ny = y + (n * yk);

                str.append(quard(arr,nx,ny,n));
            }
        }
        return str.toString();
    }

    public boolean isAllEquals(int[][] arr, int x, int y, int N){
        int prev = arr[y][x];
        for(int i=y; i<y+N; i++){
            for(int j=x; j<x+N; j++){
                if(prev != arr[i][j]) return false;
            }
        }
        return true;
    }
}