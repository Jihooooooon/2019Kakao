public class Kakao4 {

    public int solution(int[] food_times, long k) {
        int answer = 0;

        int zeroFood=0;
        int time=0;
        while(zeroFood !=food_times.length){
            for(int i=0; i<food_times.length; i++){
               if(food_times[i]!=0){
                   if(time==k){

                       return i+1;
                   }
                   else {
                       time++;
                       food_times[i]--;
                       if(food_times[i]==0){
                          zeroFood++;
                       }
                   }
                }
                else{

                    continue;
                }
            }
        }
        answer=-1;
     return answer;
    }
}
