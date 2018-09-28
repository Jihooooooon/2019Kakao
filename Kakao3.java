import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Kakao3 {

    static ArrayList<ArrayList<Integer>> set_Key = new ArrayList<ArrayList<Integer>>();
    public int solution(String[][] relation) {
        int answer = 0;
        int row = relation.length;
        int col = relation[0].length;
        ArrayList<ArrayList<Integer>> powerset = new ArrayList<ArrayList<Integer>>();
        boolean[] isUse = new boolean[col];
        powerSet(0,col,powerset,isUse);
        sortList(powerset);
        for(int i=0;i<powerset.size();i++){
            String[] tempRow = new String[row];
            for(int j=0; j<row;j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < powerset.get(i).size(); k++) {
                    sb.append(relation[j][powerset.get(i).get(k)]);
                }
                tempRow[j]=sb.toString();
            }
            boolean isnotSame=true;
            for(int t=0; t<row-1&&isnotSame;t++){
                String tempStr = tempRow[t];
                for(int k=t+1; k<row;k++){
                    if(tempStr.equals(tempRow[k])){
                        isnotSame=false;
                        break;
                    }
                }
            }
            if(isnotSame){
                answer++;
                ArrayList<Integer> temp2 = powerset.get(i);
                for(int y=0; y<temp2.size();y++) {
                    int tempint = temp2.get(y);
                    for (int k = powerset.size() - 1; k >= 0; k--) {
                        for(int m = 0; m<powerset.get(k).size();m++){
                            if(powerset.get(k).get(m)==tempint){
                                powerset.remove(k);

                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public void sortList(ArrayList<ArrayList<Integer>> powerset){
        int n=powerset.size();
        int index1=-1;
        int index2=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            min=powerset.get(i).size();
            index1=i;
            for(int k=i+1;k<n;k++){
                if(min>powerset.get(k).size()){
                    min=powerset.get(k).size();
                    index2=k;
                }
            }
            if(index2!=-1){
                ArrayList<Integer> temp = powerset.get(index1);
                powerset.remove(index1);
                powerset.add(index1,powerset.get(index2-1));
                powerset.remove(index2);
                powerset.add(index2,temp);
            }
            index1=-1;
            index2=-1;
        }
    }

    public void powerSet(int index,int col,ArrayList<ArrayList<Integer>> powerset, boolean[] isUse){
        if(index==col){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<col;i++){
                if(isUse[i]){
                    temp.add(i);
                }
            }
            if(temp.size()==0) return;
            powerset.add(temp);



            return;
        }

        isUse[index]=true;
        powerSet(index+1,col,powerset,isUse);
        isUse[index]=false;
        powerSet(index+1,col,powerset,isUse);
    }

    public static void main(String[] args) {
        String[][] x = {{"100","ryan","music","4"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
       // new Kakao3().solution(x);
        System.out.println(new Kakao3().solution(x));


    }


}
