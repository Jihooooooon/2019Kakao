import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kakao_4 {
    public static int timeCal(String startTime, String endTime){
        int startH,endH;
        int startM,endM;
        String[] temp= startTime.split(":");
        startH=Integer.parseInt(temp[0]);
        startM=Integer.parseInt(temp[1]);
        String[] temp2=endTime.split(":");
        endH=Integer.parseInt(temp2[0]);
        endM=Integer.parseInt(temp2[1]);
        return Math.abs((startH*60+startM)-(endH*60-endM));
    }

    public static String solution(String m,String[] information){
        m=m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
        ArrayList<String> result = new ArrayList<String>();
        for(String str:information){
            String[] info = str.split(",");
            int time=timeCal(info[0],info[1]);
            String orgMel=info[3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
            String reaMel="";
            for(int i=0; i<time;i++){
                reaMel+=orgMel.charAt(i%(orgMel.length()));
            }
            if(reaMel.contains(m)){
                result.add(str);
            }

        }
        Collections.sort(result, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String arr[]= o1.split(",");
                String arr2[] = o2.split(",");
                int len1 = timeCal(arr[0],arr[1]);
                int len2 = timeCal(arr2[0],arr2[1]);
                return len2-len1;
            }
        });
        return result.size() !=0 ?result.get(0).split(",")[2]:"(none)";
    }

    public static void main(String[] args) {
        String[] temp={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution("ABC",temp));
    }
}
