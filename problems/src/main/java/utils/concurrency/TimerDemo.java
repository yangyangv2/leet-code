package utils.concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();

        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                System.out.println("bomb!");
                new Timer().schedule(new MyTimerTask(), 1000);
            }
        }

        timer.schedule(new MyTimerTask(), 1000);
    }
}
