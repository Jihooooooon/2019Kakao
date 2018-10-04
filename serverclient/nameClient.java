package serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class nameClient {

    public static void main(String[] args) throws Exception {



        Socket s = null;

        InputStream is = null;

        BufferedReader br = null;

        try {

                                        /* NameServer의 Listen Socket으로 TCP 연결

                                           TCP 연결이 되면 Socket 객체를 리턴합니다. Socket - 통신채널

                                        */

            s = new Socket("localhost", 8988);



            is = s.getInputStream();       // Socket으로부터 얻은 InputStream

            br = new BufferedReader(new InputStreamReader(is));



            /*

             * NameServer로부터 한 줄(newline)을 읽습니다.

             */

            String msg = br.readLine();

            System.out.println(msg);

        }

        catch(IOException ie) {

            ie.printStackTrace();

        }

        finally {

                                        /*

                                        시스템 자원을 해제합니다.네트워크 자원을 해제합니다.

                                        */

            try {

                if (is != null)

                    is.close();

                if (br != null)

                    br.close();

                if (s != null)

                    s.close();

            }

            catch(Exception e) {

                e.printStackTrace();

            }

        }

    }

}

