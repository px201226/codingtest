package kakao2019winter.main3;

import java.util.HashSet;

public class main {

    public static void main(String[] args) {

        String[] userId = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banId = new String[]{"*rodo", "*rodo", "******"};
        Solution solution = new Solution();
        System.out.println(solution.solution(userId,banId));
    }
}


class Solution {;
    private HashSet<Integer> subset = new HashSet<>();
    public int solution(String[] user_ids, String[] banned_ids) {
        DFS(user_ids,banned_ids,0,banned_ids.length,0);
        return subset.size();
    }

    public void DFS(String[] userList, String[] bannedList, int idx, int N, int visit){
        if(N == idx){
            subset.add(visit);
            return;
        }

        for(int i=0; i<userList.length; i++){
            int j;
            if(userList[i].length() != bannedList[idx].length()) continue;
            if((visit & (1<<i)) != 0) continue;
            for(j=0; j<userList[i].length(); j++){
                if(bannedList[idx].charAt(j) == '*') continue;
                if(userList[i].charAt(j) != bannedList[idx].charAt(j)) break;
            }

            if(j == userList[i].length() ){
                DFS(userList,bannedList,idx+1,N,  visit | (1<<i));
            }
        }

    }
}
