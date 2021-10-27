import java.util.Date;

public class CloqueThread extends Thread{

    digitalclock dc;
    String time;

    public CloqueThread (digitalclock dc){
        this.dc = dc;
        start();
    }
    public void run(){
        while (true) {
            time = ""+new Date();
            dc.jlabClock.setText(time);
        }
    }
}
