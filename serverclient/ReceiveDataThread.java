package serverclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReceiveDataThread implements Runnable {
    Socket client;
    ObjectInputStream ois;
    String receiveData;
    public ReceiveDataThread(Socket s, ObjectInputStream ois){
        client=s;
        this.ois=ois;

    }
    public void run(){
        try {
            while((receiveData=(String)(ois.readObject()))!=null){
                System.out.println(receiveData);
            }
        }
        catch (ClassNotFoundException e){

        }
        catch (IOException e){

        }
        finally {
            try {
                ois.close();
                client.close();
            }catch (IOException e2){

            }
        }
    }
}
