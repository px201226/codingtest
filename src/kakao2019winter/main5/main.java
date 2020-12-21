package kakao2019winter.main5;

public class main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
}


class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int[] sum = new int[stones.length];

        for (int i = 0; i < stones.length; i++){
            if (i == 0)
                sum[i] = stones[i];
            else
                sum[i] = sum[i-1] + stones[i];
        }

        int min = Integer.MAX_VALUE;
        int index=0;
        for(int i=0; i<=stones.length-k; i++){
            int sumValue = sum[i+k-1] - (i==0 ? 0 : sum[i-1]);
            if(sumValue < min){
                min = sumValue;
                index = i;
            }
        }
        for(int i=index; i<index+k; i++){
            answer = Math.max(answer, stones[i]);
        }
        return answer;
    }
}