package JSONREST;

public class Data {
    private int x,y;

    public Data(int x, int y){
        this.x=x;
        this.y=y;
    }
    public synchronized int getX(){
        return this.x;
    }
    public synchronized int getY(){
        return this.x;
    }

    public synchronized void setX(int t){
        this.x+=t;
    }
    public void setY(int t){
        synchronized (this){
            this.y+=t;
        }
    }
}
