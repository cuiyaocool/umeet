package com.example.test.timer;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface Timer {
    Timeout newTimeOut(TimerTask task, long delay, TimeUnit unit, String argv);

    Set<Timeout> stop();

}
