import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kakao1 {

    public static String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> answer1 = new ArrayList<String>();
        ArrayList<String> answerId = new ArrayList<String>();
        StringTokenizer st;
        HashMap<String,String> nickName = new HashMap<String, String>();
        for(int i=0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String userId;
            String nick;
            if(command.equals("Enter")){
                userId = st.nextToken();
                nick = st.nextToken();
                nickName.put(userId,nick);
                answer1.add("님이 들어왔습니다.");
                answerId.add(userId);
            }
            else if(command.equals("Leave")){
                userId=st.nextToken();
                answer1.add("님이 나갔습니다.");
                answerId.add(userId);
            }
            else if(command.equals("Change")){
                userId = st.nextToken();
                nick = st.nextToken();
                nickName.put(userId,nick);
            }

        }
        answer = new String[answer1.size()];
        for(int i=0; i<answer.length;i++){
            String temp = nickName.get(answerId.get(i));
            answer[i]=temp+answer1.get(i);
        }

            return answer;


    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] temp= kakao1.solution(record);
        for(String i:temp){
            System.out.println(i);
        }
    }
}
