package coopang.main2;

import java.util.*;

public class main2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2,new int[]{1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100});
    }
}

class Difference{
    public int index;
    public int differnce;

}
class Solution{

    public int solution(int k, int score[]){

        Difference[] differceScores = new Difference[score.length-1];
        for(int i=1; i<score.length; i++){
            int previewScore = score[i-1];
            int nowScore = score[i];
            int difference = previewScore - nowScore;
            differceScores[i-1] = new Difference();
            differceScores[i-1].index = i;
            differceScores[i-1].differnce = difference;
        }

        Arrays.sort(differceScores, (a,b) -> a.differnce == b.differnce ? a.index - b.index : a.differnce - b.differnce);

        int count = 0;
        int preview = differceScores[0].differnce;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> removeIndexSet = new HashSet<>();
        for(int i=0; i<differceScores.length; i++){
            if(preview == differceScores[i].differnce){
                count++;
                set.add(differceScores[i].index-1); set.add(differceScores[i].index);
            }else{
                if(count >= k)
                    removeIndexSet.addAll(set);

                count = 1;
                preview = differceScores[i].differnce;
                set.clear();
                set.add(differceScores[i].index-1); set.add(differceScores[i].index);
            }
        }

        if(count >= k)
            removeIndexSet.addAll(set);

        return score.length - removeIndexSet.size();
    }
}