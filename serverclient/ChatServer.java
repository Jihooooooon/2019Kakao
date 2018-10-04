package serverclient;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(100001);
            HashMap<String, ObjectOutputStream> hm = new HashMap<String, ObjectOutputStream>();
            while(true){
                System.out.println("접속을 기다립니다");
                Socket sock = server.accept();
                ChatThread childThread = new ChatThread(sock,hm);
                Thread t = new Thread(childThread);
                t.start();

            }
        }
        catch (Exception e){

        }
    }


}
