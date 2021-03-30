package boj.prb58;

/*
https://www.acmicpc.net/problem/14888
수식 만들기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int[] opts = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            opts[i] = Integer.parseInt(st.nextToken());
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        divide(nums,nums[0],1,opts[0],opts[1],opts[2],opts[3],answer);
        System.out.printf("%d\n%d", answer[1], answer[0]);
    }

    public static void divide(int[] nums, int result, int index, int op1, int op2, int op3, int op4, int[] resultArr){
        if(index == nums.length){

            resultArr[0] = Math.min(resultArr[0], result);
            resultArr[1] = Math.max(resultArr[1], result);
            return;
        }

        if(op1 > 0) {
            divide(nums, result + nums[index], index + 1, op1-1,op2,op3,op4, resultArr);

        }
        if(op2 > 0) {
            divide(nums, result - nums[index], index + 1,  op1,op2-1,op3,op4, resultArr);
        }
        if(op3 > 0) {
            divide(nums, result * nums[index], index + 1,  op1,op2,op3-1,op4, resultArr);
        }
        if(op4 >0) {
            divide(nums, result / nums[index], index + 1,  op1,op2,op3,op4-1, resultArr);
        }
    }

}