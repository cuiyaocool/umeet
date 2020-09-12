package com.example.test.simpleTimeWheel;

public class TimeMain {
    public static void main(String[] args) throws Exception {
        TimeWheel timeWheel = new TimeWheel(10, 1000);
        long delayTime[] = {9000, 3000, 5000, 1000, 25000, 12000};
        for (int i = 0; i < delayTime.length; i++) {
            MyTask task = new MyTask(i);
            timeWheel.newTimeOut(task, delayTime[i], "");
        }
    }
}
