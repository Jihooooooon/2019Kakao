package serverclient;


import java.io.*;

import java.net.*;

import java.util.*;



/**

 * 클라이언트에게 자신의 이름을 알려주는 서버입니다.

 * 8988 TCP 포트를 Listen합니다. 클라이언트가 TCP 연결을 하면 자신의 이름을

 * 클라이언트에게 보냅니다.

 */

public class server {



    public static void main(String[] args) {



        ServerSocket ss = null;

        Socket s = null;

        OutputStream os = null;

        PrintStream ps = null;

        try {

            ss = new ServerSocket(8988);// NameServer의 Listen Socket - ServerSocket



                                        /* 클라이언트로부터 TCP 연결을 기다립니다. TCP 연결이 되면

                                        Socket객체를 리턴합니다.*/

            s = ss.accept();                                            // NameServer와 클라이언트의 Socket - 통신채널

            os = s.getOutputStream();    // Socket으로부터 얻은 OutputStream

            ps = new PrintStream(os);

            ps.println("안녕, 내 이름은 귀염둥이 \"크로커다일이야\"");

            ps.flush();

        }

        catch(IOException ie) {

            ie.printStackTrace();

        }

        finally {

                                        /*

                                        시스템 자원을 해제합니다.(네트워크 자원을 해제합니다.

                                        */

            try {

                if (ss != null)

                    ss.close();

                if (os != null)

                    os.close();

                if (ps != null)

                    ps.close();

                if (s != null)

                    s.close();

            }

            catch(Exception e) {

                e.printStackTrace();

            }

        }

    }

}


