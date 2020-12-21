package greedy4;

public class main {

    public static void main(String[] args) {
        String[] names = { "CANAAAAANAN", "AAAAACANAAAAANANAAAAAA", "JAN", "JEROEN", "BBAAAAA", "JJAJAAAAAAAAAJ",
                "AJAJAA", "BBABA", "BBBAAB", "BBAABAA", "BBAABBB", "BBAABAAAA", "BBAABAAAAB", "ABAAAAAAABA", "AAB",
                "AABAAAAAAABBB", "ZZZ", "BBBBAAAAAB", "BBBBAAAABA", "ABABAAAAAAABA", "BBBBBBBABB" };

        int[] answers = { 48, 56, 23, 56, 3, 41, 21, 6, 8, 7, 10, 7, 10, 6, 2, 11, 5, 10, 12, 10, 18 };
        Solution solution = new Solution();
        for (int i = 0; i < names.length; i++) {
            int ret = solution.solution(names[i]);  // 여기는 각자 코드에 맞게 수정하면 됩니다.
            if (ret != answers[i]){
                System.out.println("names[i]: " + names[i]);
                System.out.println("answers[i]: " + answers[i]);
                System.out.println("ret: " + ret + "\n");
            }
        }
        System.out.println(solution.solution("AAA"));
    }
}


class Solution {

    private final static String alpabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int solution(String name) {
        int answer = 0;
        int left = 0, right = 0, dirent=-1, base=name.length()-1;

        for(right=1; right < name.length(); right++){
            if(name.charAt(right) != 'A') break;
        }

        for(left=1; left < name.length(); left++){
            if(name.charAt(name.length()-left) != 'A') break;
        }

        if(right >= left){
            answer -= right -1;
            dirent = 1;
            base = 0;
        }else{
            answer -= left-1;
        }

        for(int i=base; i<name.length() && i >= 0; i += (dirent)){
            char c = name.charAt(i);
            if( c <= 'N'){
                answer += alpabets.indexOf(String.valueOf(c));
            }else{
                answer += alpabets.length() - alpabets.indexOf(String.valueOf(c));
            }
            answer++;
        }

        return answer-1;
    }
}