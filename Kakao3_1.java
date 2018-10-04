import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Kakao3_1 {
    public int solution(String[][] relation) {
        int len = (1<<relation[0].length);
        Set<Integer> keys = new HashSet<Integer>();

        for(int i=1; i<len; i++){
            boolean isMinimal = true;
            for(int uniqueKey : keys){
                if((i&uniqueKey)==uniqueKey){
                    isMinimal =false;
                    break;
                }
            }
            if(!isMinimal) continue;

            int t=i;
            int col=0;
            StringBuilder[] strs = new StringBuilder[relation.length];
            for(int k=0; k<strs.length; k++){
                strs[k]= new StringBuilder();
            }
            while(t>0){
                if((t&1)==1){
                    for(int k=0; k<strs.length;k++){
                        strs[k].append(relation[k][col]);
                    }
                }
                col++;
                t>>=1;
            }

            Set<String> set = new HashSet<String>();
            for(StringBuilder sb:strs){
                set.add(sb.toString());
            }
            if(set.size()==strs.length){
                keys.add(i);
            }
        }

        return keys.size();
    }
    public static void main(String[] args) {
        String[][] x = {{"100","ryan","music","4"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        // new Kakao3().solution(x);
        System.out.println(new Kakao3().solution(x));


    }
}
