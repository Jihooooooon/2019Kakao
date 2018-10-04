import java.util.Stack;

public class Kakao_1 {
    public static String solution(int n, int t, int m, int p){
        String result =Proposition(n);
        StringBuilder sb = new StringBuilder();
        // a = (p-1)+(m)*i
        for(int i=0;i<t;i++){
            sb.append(result.charAt((p-1)+m*i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(2,4,2,1));
    }

    public static String Proposition(int n){
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<1000;i++ ){
            sb.append(cal(i,n));
        }
        return sb.toString();
    }


    public static String cal(int i, int n){
        Stack<String> st = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        int temp=i;
        if(temp==0)st.push(String.valueOf(0));
       while(temp!=0){
           st.push(String.valueOf(temp%n));
           temp /=n;
       }
       while(!st.isEmpty()){
           //10이상 검색
           String s = st.pop();

           sb.append(aboveTen(s));
       }
       return sb.toString();
    }

    public static String aboveTen(String s){
        if(s.equals("10")){
            return "A";
        }
        if(s.equals("11")){
            return "B";
        }
        if(s.equals("12")){
            return "C";
        }
        if(s.equals("13")){
            return "D";
        }
        if(s.equals("14")){
            return "E";
        }
        if(s.equals("15")){
            return "F";
        }
        else
            return s;
    }
}
