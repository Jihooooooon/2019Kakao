import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao6 {

    public int solution(String[] pages, String word) {
        StringBuilder sb = new StringBuilder();
        String x="(?i)";
        sb.append(x);
        sb.append(word);
        Pattern p = Pattern.compile(sb.toString());
        List<Set<String>> linkName = new ArrayList<Set<String>>();
        int len = pages.length;
        int[] basicScore = new int[len];
        int[] linkScore = new int[len];

        double[] result = new double[len];
        String[] linkAddress = new String[len];
        String link1="(meta\\sproperty=\"[\\S]*\"\\scontent=\"https?):\\/\\/([a-zA-z])+(.)(com\")";
        String link2="(a\\shref=\"https?)://([a-zA-Z]+)(.)(com\")";
        for(int i=0; i<len; ++i){
            Matcher m = p.matcher(pages[i]);
            int count=0;
            for(int j=0; m.find(j);j=m.end())
                count++;
            basicScore[i]=count;


        }
        //링크주소
        for(int i=0; i<len; ++i){
            p=Pattern.compile(link1);
            Matcher m=p.matcher(pages[i]);
            if(m.find()){
                linkAddress[i]=m.group(2);
            }
        }
        //외부링크 카운트 점수
        for(int i=0; i<len; ++i){
            Set<String> tempAddress = new HashSet<String>();
            int count=0;
            p=Pattern.compile(link2);
            Matcher m=p.matcher(pages[i]);
            for(int j=0; m.find(j);j=m.end()){
                tempAddress.add(m.group(2));
                count++;
            }
            linkScore[i]=count;
            linkName.add(tempAddress);
            result[i]=basicScore[i];
        }

        for(int i=0; i<len;++i) {
            for (int j = 0; j < len; ++j) {
                if (i == j) continue;
                Set temp=linkName.get(j);
                if(temp.contains(linkAddress[i])){
                    result[i]+=(double)basicScore[j]/(double)linkScore[j];
                }
            }

        }
        double min=Integer.MAX_VALUE;
        int finalResult=0;
        for(int i=0; i<len;i++){
            if(min>result[i]){
                min=result[i];
                finalResult=i;
            }
        }
        return finalResult;
    }


    public static void main(String[] args) {
        String[] pages={"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String word = "blind";
        System.out.println(new Kakao6().solution(pages,word));

    }
}
