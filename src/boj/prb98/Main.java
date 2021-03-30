package boj.prb98;

/*
https://www.acmicpc.net/problem/17609
회문
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            String str = br.readLine();
            System.out.println(isPalindrome(str,0,str.length()-1,false));
        }
    }

    public static int isPalindrome(String str, int left, int right, boolean isSkip){

        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                if(isSkip == false){
                    int answer = isPalindrome(str,left+1,right,true) + isPalindrome(str,left,right-1,true);
                    return answer == 4 ? 2 : 1;
                }else{
                    return 2;
                }
            }
            left++;right--;
        }
        return 0;
    }

}



