package kakao2018.main3;

public class main {

    public static void main(String[] args) {

        int[] a = new int[]{46, 33, 33 ,22, 31, 50};
        int[] b= new int[]{27 ,56, 19, 14, 14, 10};
        Solution solution = new Solution();
        solution.solution(5,a,b);
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0; i<arr1.length; i++){
            int and = arr1[i] | arr2[i];
            answer[i] = String.format("%" +n +"s", Integer.toBinaryString(and))
                    .replace("0", " ")
                    .replace("1","#");
        }

        return answer;
    }
}
