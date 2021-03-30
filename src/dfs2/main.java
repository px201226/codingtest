package dfs2;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}


class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = DFS(words, target, begin, new boolean[words.length], 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public int DFS(final String[] words, final String target, String begin, boolean[] isSelect, int depth){

        int ret = Integer.MAX_VALUE;
        if(depth > words.length)
            return depth;

        if(begin.equals(target))
            return depth;

        for(int i=0; i<words.length; i++){
            if(!isSelect[i] && isOneChange(begin, words[i])){
                isSelect[i] = true;
                ret = Math.min(ret, DFS(words,target,words[i],isSelect,depth+1));
                isSelect[i] = false;
            }
        }

        return ret;
    }


    public boolean isOneChange(final String target, final String compare){
        int ret = 0;
        for(int i=0; i<target.length(); i++){
            if(target.charAt(i) != compare.charAt(i))
                ret++;
            if(ret >= 2) return false;
        }

        return true;
    }
}