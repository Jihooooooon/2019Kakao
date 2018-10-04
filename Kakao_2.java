import java.util.ArrayList;
import java.util.HashMap;

public class Kakao_2 {
    static HashMap<String,Integer> dic = new HashMap<String, Integer>();
    public static int[] solution(String msg){
        init();
        int len=msg.length();
        int idx=1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<len;){
            while(true){
                if(i+idx>len){
                    String temp = msg.substring(i,len);
                    result.add(dic.get(temp));
                    i=len;
                    break;
                }
                String temp = msg.substring(i,i+idx);
                if(dic.containsKey(temp)){
                    idx++;
                    continue;
                }
                else{
                    dic.put(temp,dic.size()+1);
                    result.add(dic.get(temp.substring(0,temp.length()-1)));
                    idx--;
                    i=i+idx;
                    idx=1;
                    break;
                }
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=result.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        //String test="KAKAO";
        String test = "ABABABABABABABAB";
        for(int i:solution(test)){
            System.out.println(i);
        }
    }

    static void init(){
        dic.clear();
        dic.put("A",1);dic.put("J",10);dic.put("S",19);
        dic.put("B",2);dic.put("K",11);dic.put("T",20);
        dic.put("C",3);dic.put("L",12);dic.put("U",21);
        dic.put("D",4);dic.put("M",13);dic.put("V",22);
        dic.put("E",5);dic.put("N",14);dic.put("W",23);
        dic.put("F",6);dic.put("O",15);dic.put("X",24);
        dic.put("G",7);dic.put("P",16);dic.put("Y",25);
        dic.put("H",8);dic.put("Q",17);dic.put("Z",26);
        dic.put("I",9);dic.put("R",18);


    }


}
