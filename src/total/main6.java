package total;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class main6 {
}

class Solution{
    public int solution(String[][] relation) {

        final int row = relation.length;
        final int col = relation[0].length;
        ArrayList<Integer> keyArray = new ArrayList<>();

        for(int i=1; i<(1<<col); i++){
            Set<String> keySet = new HashSet<>();

            for(int r=0; r<row; r++){
                StringBuilder keyEntry = new StringBuilder();
                for(int k=0; k<col; k++){
                    if((i & (1<<k)) > 0){
                        keyEntry.append(relation[r][k]);
                    }
                }
                keySet.add(keyEntry.toString());
            }

            if(keySet.size() == row && isNotDuplicate(keyArray, i) ){
                keyArray.add(i);
            }
        }

        return keyArray.size();
    }

    private boolean isNotDuplicate(ArrayList<Integer> keyArray, int i) {
        for(Integer key : keyArray){
            if((key & i) == key) return false;
        }
        return true;
    }
}
