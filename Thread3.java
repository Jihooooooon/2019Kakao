import JSONREST.Data;

public class Thread3 implements Runnable {
    Data data;
    int x;
    public Thread3(Data inputData,int x){
        this.data=inputData;
        this.x=x;
    }
    public void  run(){
        for(int i=1;i<5;i++){
            int temp =data.getX();
            this.data.setX(x);
            System.out.println("가져온거"+temp+"더한거"+data.getX());
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
