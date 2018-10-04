package serverclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ChatThread implements Runnable {
    Socket child;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    String user_id;
    HashMap<String, ObjectOutputStream> hm;//스레드간 정보공유

    public ChatThread(Socket s, HashMap hm){
        child=s;
        this.hm=hm;
        try {
            System.out.println(child.getInetAddress()+"로부터 연결요청을 받음");
            ois = new ObjectInputStream(child.getInputStream());
            oos = new ObjectOutputStream(child.getOutputStream());

            user_id=(String)ois.readObject();
            broadcast(user_id+"님이 접속하셨습니다");
            System.out.println("아이디는"+user_id+"입니다");

            synchronized (hm){
                hm.put(user_id,oos);
            }
        }
        catch (Exception e){

        }
    }
    public void run(){
        String receiveData;
        try{
            while (true) {
                receiveData = (String) ois.readObject();
                if (receiveData.equals("/quit"))
                    break;
                else if(receiveData.indexOf("/to")>-1)
                    sendMsg(receiveData);
                else
                    broadcast(user_id+":"+receiveData);
            }
        }
        catch (Exception e){

        }
        finally {
            synchronized (hm){
                hm.remove(user_id);
            }
            broadcast(user_id+"나감");
            System.out.println(user_id+"나감");
            try {
                if(child!=null){
                    child.close();
                }
            }
            catch (Exception e){

            }
        }
    }

    public void broadcast(String message){
        synchronized (hm){
            try {
                for(ObjectOutputStream oos:hm.values()){
                    oos.writeObject(message);
                    oos.flush();
                }
            }
            catch (IOException e){

            }
        }
    }

    public void sendMsg(String message){
        int begin = message.indexOf("")+1;
        int end = message.indexOf("",begin);

        if(end!=-1){
            String id = message.substring(begin,end);
            String msg = message.substring(end+1);
            ObjectOutputStream oos = hm.get(id);
            try{
                if(oos!=null){
                    oos.writeObject(id+"귓속말햇다"+msg);
                    oos.flush();
                }
            }
            catch (IOException e){

            }
        }
    }
}
