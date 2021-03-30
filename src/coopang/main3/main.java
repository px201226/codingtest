package coopang.main3;

import java.util.ArrayList;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {

        String[][] road = new String[][]{{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};
        Solution solution = new Solution();
        System.out.println(solution.solution("SEOUL", "DAEGU","YEOSU",road));
    }
}

class Solution{

    public int solution(String depar, String hub, String dest,String[][] roads){

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(int i=0; i<roads.length; i++){
            ArrayList roadList = hashMap.getOrDefault(roads[i][0], new ArrayList<String>());
            roadList.add(roads[i][1]);
            hashMap.put(roads[i][0], roadList);
        }

        return DFS(depar,hub,dest,depar, hashMap);
    }

    public int DFS(String depar, String hub, String dest, String path,  HashMap<String, ArrayList<String>> roads){
        int answer = 0;
        System.out.println(depar);
        if(depar.equals(dest)){
            if (path.contains(hub))
                return 1;
        }

        ArrayList<String> roadList = roads.get(depar);
        if(roadList == null) return 0;
        for(int i=0; i<roadList.size(); i++){
            answer += DFS(roadList.get(i), hub,dest, path + roadList.get(i), roads);
        }
        return answer;
    }
}
