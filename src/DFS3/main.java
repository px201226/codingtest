package DFS3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        String[][] str = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(
                solution.solution(str)));
    }
}

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[0];;
        Arrays.sort(tickets, (t1,t2) -> {
            if(t1[0].equals(t2[0])){
                return t1[1].compareTo(t2[1]);
            }
            return t1[0].compareTo(t2[0]);
        });
        List<String> seq = new ArrayList<>();
        seq.add("ICN");
        return DFS(tickets,seq,"ICN", new boolean[tickets.length],0).toArray(answer);
    }

    public List<String> DFS(final String[][] tickects, List<String> seq, String start, boolean[] isUsed,int depth){

        List<String> ret = null;

        if(depth >= isUsed.length){
            return new ArrayList<>(seq);
        }

        for(int i=0; i<tickects.length; i++){
            if(!isUsed[i] && tickects[i][0].equals(start)){
                seq.add(tickects[i][1]);
                isUsed[i] = true;
                List<String> temp = DFS(tickects,seq,tickects[i][1],isUsed, depth+1);
                if(temp != null && temp.size() >= 1) {
                    return temp;
                }
                isUsed[i] = false;
                seq.remove(seq.size()-1);
            }
        }

        return ret;
    }
}

