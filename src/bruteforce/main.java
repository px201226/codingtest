package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class main {
}


class Solution {

    public static final int[][] answerList = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    public int[] solution(int[] answers) {
        int[] answer = {};

        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<answerList.length; i++){
            int count = 0;
            for(int j=0; j<answers.length; j++){
                if(answers[j] == answerList[i][j % answerList[i].length ])
                    count++;
            }
            list.add(new int[]{i+1,count});
        }

        list.sort((item1, item2) -> item2[1] - item1[1] );
        int max = list.get(0)[1];
        Iterator<int[]> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next()[1] != max){
                iterator.remove();
            }
        }

        return list.stream().mapToInt( i -> i[0]).toArray();
    }
}