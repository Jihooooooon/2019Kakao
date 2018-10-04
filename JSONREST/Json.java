package JSONREST;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Scanner;

public class Json {
    /*
    public static void geocoding(String addr) throws Exception
    {
        // build a URL
        String s = "http://maps.google.com/maps/api/geocode/json?" +
                "sensor=false&address=";
        s += URLEncoder.encode(addr, "UTF-8");
        URL url = new URL(s);

        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object

        JSONObject obj = new JSONObject().toJSONString(str);
        if (! obj.getString("status").equals("OK"))
            return;

        // get the first result
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("formatted_address"));
        JSONObject loc =
                res.getJSONObject("geometry").getJSONObject("location");
        System.out.println("lat: " + loc.getDouble("lat") +
                ", lng: " + loc.getDouble("lng"));
    }*/
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        //person의 JSON정보를 담을 Array 선언
        JSONArray personArray = new JSONArray();

        //person의 한명 정보가 들어갈 JSONObject 선언
        JSONObject personInfo = new JSONObject();

        //정보 입력
        personInfo.put("name", "송강호");
        personInfo.put("age", "25");
        personInfo.put("gender", "남자");
        personInfo.put("nickname", "남궁민수");
        //Array에 입력
        personArray.add(personInfo);

        personInfo = new JSONObject();
        personInfo.put("name", "전지현");
        personInfo.put("age", "21");
        personInfo.put("gender", "여자");
        personInfo.put("nickname", "예니콜");
        personArray.add(personInfo);

        //전체의 JSONObject에 사람이란 name으로 JSON의 정보로 구성된 Array의 value를 입력
        jsonObject.put("persons", personArray);


        JSONArray bookArray = new JSONArray();

        JSONObject bookInfo = new JSONObject();

        bookInfo.put("name", "사람은 무엇으로 사는가?");
        bookInfo.put("writer", "톨스토이");
        bookInfo.put("price", "100");
        bookInfo.put("genre", "소설");
        bookInfo.put("publisher", "톨스토이 출판사");
        bookArray.add(bookInfo);

        bookInfo = new JSONObject();
        bookInfo.put("name", "홍길동전");
        bookInfo.put("writer", "허균");
        bookInfo.put("price", "300");
        bookInfo.put("genre", "소설");
        bookInfo.put("publisher", "허균 출판사");
        bookArray.add(bookInfo);

        bookInfo = new JSONObject();
        bookInfo.put("name", "레미제라블");
        bookInfo.put("writer", "빅토르 위고");
        bookInfo.put("price", "900");
        bookInfo.put("genre", "소설");
        bookInfo.put("publisher", "빅토르 위고 출판사");
        bookArray.add(bookInfo);

        jsonObject.put("books", bookArray);

        //JSONObject를 String 객체에 할당
        String jsonInfo = jsonObject.toJSONString();

        System.out.print(jsonInfo);
        String jsonStr = "{\"members\":["
                + "{\"name\":\"홍길동\","
                + "\"email\":\"gildong@hong.com\","
                + "\"age\":\"25\""
                + "},"
                + "{\"name\":\"홍길서\","
                + "\"email\":\"gilseo@hong.com\","
                + "\"age\":\"23\""
                + "}]}";
        String jsonstr ="{\"jihoon\" : \"handsome\"}";
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonStr);
            JSONArray memberArray = (JSONArray) jsonObj.get("members");

            System.out.println("=====Members=====");
            for(int i=0 ; i<memberArray.size() ; i++){
                JSONObject tempObj = (JSONObject) memberArray.get(i);
                System.out.println(""+(i+1)+"번째 멤버의 이름 : "+tempObj.get("name"));
                System.out.println(""+(i+1)+"번째 멤버의 이메일 : "+tempObj.get("email"));
                System.out.println(""+(i+1)+"번째 멤버의 나이 : "+tempObj.get("age"));
                System.out.println("----------------------------");
            }
            JSONObject jsonobj = (JSONObject) jsonParser.parse(jsonstr);
            System.out.println(jsonobj.get("jihoon"));

        }
        catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }
}
