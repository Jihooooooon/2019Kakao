import java.util.ArrayList;

public class Kakao2 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        ArrayList<Integer> failNum = new ArrayList<Integer>();
        ArrayList<Integer> totalNum = new ArrayList<Integer>();
        int sumcount=0;
        for(int i=1; i<=N; i++){
            int count=0;
            for(int j=0; j<stages.length; j++){
                if(stages[j]<=i){
                    count++;
                }
            }
            if(i==1){
                failNum.add(count);
            }
            else{
                sumcount +=failNum.get(i-2);
                failNum.add(count-sumcount);
            }

            if(i==1){
                totalNum.add(stages.length);
            }
            else{
                totalNum.add(totalNum.get(i-2)-failNum.get(i-2));
            }

        }
        double[][] failRate = new double[totalNum.size()][2];
        double failR;
        for(int i=0; i<totalNum.size();i++){

            if(failNum.get(i)==0 || totalNum.get(i)==0){
                failR=0;
            }
            else{
                failR = (double)failNum.get(i)/(double)totalNum.get(i);
            }
            failRate[i][0]=failR;
            failRate[i][1]= i+1;
        }

        sort(failRate);

        answer = new int[failRate.length];
        for(int i=0; i<answer.length; i++){
            answer[i]=(int)failRate[i][1];
        }
        return answer;
    }

    public static void sort(double[][] failRate){
        for(int i=0; i<failRate.length; i++){
            double max = failRate[i][0];
            for(int j=i+1; j<failRate.length; j++){

                if(max<=failRate[j][0]){
                    double temp,temp2;
                    if(max==failRate[j][0]){
                        if(failRate[i][1]<failRate[j][1]){
                            continue;
                        }
                        else{
                            temp = failRate[i][0];
                            temp2 = failRate[i][1];
                            failRate[i][0]=failRate[j][0];
                            failRate[i][1]=failRate[j][1];
                            failRate[j][0]= temp;
                            failRate[j][1]=temp2;

                        }
                    }
                    else{
                        temp = failRate[i][0];
                        temp2 = failRate[i][1];
                        failRate[i][0]=failRate[j][0];
                        failRate[i][1]=failRate[j][1];
                        failRate[j][0]= temp;
                        failRate[j][1]=temp2;
                    }
                    max=failRate[i][0];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] test2 = {4,4,4,4,4};
        int[] result = Kakao2.solution(5,test1);
        for(int i: result){
            System.out.println(i);
        }
    }
}
