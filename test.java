import JSONREST.Data;

public class test {
    public static void main(String[] args) {
/*
        String link="(meta\\sproperty=\"[\\S]*\"\\scontent=\"https?):\\/\\/([a-zA-z])+(.)(com\")";
        String x ="<meta property=\"og:url\" content=\"https://a.com\"/>";
        StringBuilder sb = new StringBuilder();

        String t = "HTTP";
        String y="(?i)";
        sb.append(y);
        sb.append(t);
        //Pattern p = Pattern.compile(sb.toString());
        //Matcher m = p.matcher(x);
        String s="foo010bar020.zip";
        String pattern="([a-zA-z]+)([0-9]*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
       // for(int i=0; m.find(i);i=m.end()){
      //  if(m.find())
       //     System.out.println(m.group(2));
     //   }
       // String temp = s.toUpperCase();
        /*

        for(int i=0; m.find(i);i=m.end()) {

                System.out.println(m.group(0));

        }*/
        //System.out.println(temp);
        /*
        ArrayList<String> a = new ArrayList<String>();
        a.add("333");
        a.add("22");
        a.add("1");
      Collections.sort(a, new Comparator<String>() {
          public int compare(String o1, String o2) {
            if(o1.length()-o2.length()>0){
                return -1;
            }
            else return 1;
          }
      });
        System.out.println(a.toString());*/



        /*
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        t2.start();
*/
        Data x=new Data(10,20);
        Thread t1 = new Thread(new Thread3(x,2));
        Thread t2 = new Thread(new Thread3(x,1));
        t1.start();
        t2.start();
    }

}
