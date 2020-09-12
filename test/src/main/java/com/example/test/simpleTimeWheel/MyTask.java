package com.example.test.simpleTimeWheel;

import java.time.LocalDateTime;

public class MyTask implements TimerTask {
    int index;
    MyTask(int ix) {
        index = ix;
    }
    @Override
    public void run() throws Exception {
        System.out.println(LocalDateTime.now());
        System.out.println("当前任务序号是：" + index);
    }
}
