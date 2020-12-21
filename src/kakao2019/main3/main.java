package kakao2019.main3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        String[][] args1 = new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(args1));
    }
}


class Solution {
    public ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer=0;
        DFS(relation, new ArrayList<Integer>(), 0,0);
        seq.sort( (a,b) -> a.size() - b.size());

        boolean[] isSelect = new boolean[seq.size()];
        Iterator<ArrayList<Integer>> iterator = seq.iterator();

        for(int i=0; i<seq.size(); i++){
            if(isSelect[i]) continue;
            ArrayList<Integer> cols = seq.get(i);
            if(isCandidateKey(relation,cols)){
                for(int j=i+1; j<seq.size(); j++){
                    if(seq.get(j).containsAll(cols)){
                        isSelect[j] = true;
                    }
                }
                answer++;
            }

        }
        return answer;
    }

    public void DFS(final String[][] relation, ArrayList<Integer> cols, int idx, int depth){

        if (depth > relation[0].length)
            return ;

        if (depth >= 1){
            seq.add(new ArrayList<>(cols));
        }

        for(int i=idx; i<relation[0].length; i++){
            cols.add(i);
            DFS(relation,cols, i+1, depth+1);
            cols.remove(cols.size()-1);
        }
    }

    public boolean isCandidateKey(final String[][] relation, ArrayList<Integer> cols){
        HashSet<String> hashSet = new HashSet<>();

        for(int i=0; i<relation.length; i++){

            StringBuilder temp = new StringBuilder();
            for(int c=0; c<cols.size(); c++){
                temp.append(relation[i][cols.get(c)]);
                temp.append(",");
            }
            String strTemp = temp.toString();
            if(hashSet.contains(strTemp))
                return false;
            else
                hashSet.add(strTemp);
        }
        return true;
    }
}