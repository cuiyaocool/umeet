package com.example.test.simpleTimeWheel;

import java.util.concurrent.TimeUnit;

public interface Timer {
    Timeout newTimeOut(TimerTask task, long delay, String argv);
}
