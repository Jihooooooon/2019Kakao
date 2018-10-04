package serverclient;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    String ipAddress;
    static final int port=6000;
    Socket client =null;
    BufferedReader read;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String sendData;
    String receiveData;

    String user_id;
    ReceiveDataThread rt;
    boolean endflag=false;

    public ChatClient(String id, String ip){
        user_id=id;
        ipAddress=ip;
        try {
            System.out.println("클라이언트");
            client = new Socket(ipAddress,port);

            read = new BufferedReader(new InputStreamReader(System.in));
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());

            oos.writeObject(user_id);
            oos.flush();

            rt= new ReceiveDataThread(client,ois);
            Thread t = new Thread(rt);
            t.start();

            while (true){
                sendData = read.readLine();

                oos.writeObject(sendData);
                oos.flush();
                if(sendData.equals("/quit")){
                    endflag=true;
                    break;
                }
            }
            System.out.println("접속종료");
        }
        catch (Exception e){

        }
        finally {
            try {
                ois.close();
                oos.close();
                client.close();
                System.exit(0);
            }
            catch (IOException e2){

            }
        }
    }

    public static void main(String[] args) {
        if(args.length<2){
            System.exit(0);
        }
        new ChatClient(args[0],args[1]);
    }
}
