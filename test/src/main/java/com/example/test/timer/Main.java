package com.example.test.timer;

import java.util.concurrent.TimeUnit;

public class Main implements TimerTask{

    final static Timer timer = new TimerWheel();


    public static void main(String[] args) {
        TimerTask timerTask = (TimerTask) new Main();
        for (int i = 0; i < 10; i++) {
            timer.newTimeOut(timerTask, 10, TimeUnit.SECONDS, "" + i );
        }
    }
    @Override
    public void run(Timeout timeout, String argv) throws Exception {
        System.out.println("timeout, argv = " + argv );
    }
}
