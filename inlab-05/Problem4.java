import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// TimerTask implements Runnable
public class Problem4 extends TimerTask{
    public void run(){
        final DateFormat date = new SimpleDateFormat("HH:mm:ss");
        Calendar temp = Calendar.getInstance();
        System.out.println(date.format(temp.getTime()));
    }

    public static void main(String a[]){
        Timer t = new Timer();
        TimerTask tt = new Problem4();
        t.scheduleAtFixedRate(tt, 0, 1000);
    }
}