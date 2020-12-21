package kakao2019.main1;

import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ans = solution.solution(new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        });

        System.out.println(Arrays.toString(ans));
    }
}
class Solution {
    class History{
        public String uid;
        public boolean isLeave;

        public History(String uid, boolean isLeave) {
            this.uid = uid;
            this.isLeave = isLeave;
        }
    }
    public String[] solution(String[] records) {

        HashMap<String,String> table = new HashMap<>();
        ArrayList<History> historys = new ArrayList<>();

        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String uid = st.nextToken();
            if(command.equals("Enter")){
                table.put(uid, st.nextToken());
                historys.add(new History(uid,false));
            }else if(command.equals("Leave")){
                historys.add(new History(uid,true));
            }else {
                table.put(uid,st.nextToken());
            }
        }

        String[] answer = new String[historys.size()];
        for(int i=0; i<historys.size(); i++){
            StringBuilder sb = new StringBuilder(table.get(historys.get(i).uid));
            sb.append("님이 ");
            if(!historys.get(i).isLeave)
                sb.append("들어왔습니다.");
            else
                sb.append("나갔습니다.");
            answer[i] = sb.toString();
        }
        return answer;
    }
}
