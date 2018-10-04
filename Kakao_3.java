import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao_3 {

    public static String[] solution(String[] arr){
        String[] sortArr = new String[arr.length];
        kakaoSort(arr,0,arr.length-1,sortArr);
        return arr;

    }

    public static void kakaoSort(String[] arr,int start, int end,String[] sortArr){
        int mid;
        if(start<end){
            mid=(start+end)/2;
            kakaoSort(arr,start,mid,sortArr);
            kakaoSort(arr,mid+1,end,sortArr);
            merge(arr,start,mid,end,sortArr);
        }

    }

    public static void  merge(String[] arr, int start, int mid, int end,String[] sortArr){
        int i,j,k,t;
        i=start;
        j=mid+1;
        k=start;
        String pattern="([a-zA-z\\-]+)\\s*([0-9]*)";
        Pattern p= Pattern.compile(pattern);
        Matcher m1,m2;
        while(i<=mid && j <=end){
            m1=p.matcher(arr[i]);
            m2=p.matcher(arr[j]);
            String head1=null,head2=null;
            int num1=0,num2=0;
            if(m1.find()&&m2.find()){
                head1=m1.group(1);
                head2=m2.group(1);
                num1=Integer.parseInt(m1.group(2));
                num2=Integer.parseInt(m2.group(2));

            }
            if(head1.compareToIgnoreCase(head2)>0){
                sortArr[k++]=arr[j++];
            }
            else if(head1.compareToIgnoreCase(head2)<0){
                sortArr[k++]=arr[i++];
            }
            else{
                if(num1<=num2){
                    sortArr[k++]=arr[i++];
                }
                else{
                    sortArr[k++]=arr[j++];
                }
            }
        }
        while (i<=mid)
            sortArr[k++]=arr[i++];
        while(j<=end)
            sortArr[k++]=arr[j++];
        for(t=start;t<=end;t++){
            arr[t]=sortArr[t];
        }
    }
    public static void main(String[] args) {
        String[] test = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        for(String temp:solution(test)){
            System.out.print(temp+" ");
        }
    }
}
