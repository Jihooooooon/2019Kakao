package JSONREST;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test01 {
    public static void main(String[] args) {
        BufferedReader in;
        in = null;
     try {
        URL obj = new URL("http://swapi.co/api");
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
       con.setRequestMethod("GET");
       in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
         JSONParser jp = new JSONParser();
        String tempstr="";
       String line; while((line = in.readLine()) != null) {
           System.out.println(line);
          tempstr += line;
       }
        // JSONObject temp = (JSONObject) jp.parse(tempstr);
       //  System.out.println(temp.get("origin"));

     }
       catch(Exception e)
    { e.printStackTrace(); }
       finally {
        if(in != null)
            try { in.close(); }
            catch(Exception e) { e.printStackTrace(); } } } }

