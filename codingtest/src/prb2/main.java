package prb2;


import java.util.stream.IntStream;

public class main {

	
	public static void maint(String[] args) {
		Solution abc = new Solution();
		System.out.println("dd");
		abc.solution(10);
		
	}
}

class Solution {
    private final static int[][] dirent = new int[][]{
        {0,1},{1,0},{-1,-1}
    };
    
    public int[] solution(int n) {
        int[] answer = {};
        int sum = IntStream.range(1,5).reduce((a,b) -> a+b).getAsInt();
        System.out.println(sum);
        return answer;
    }
}