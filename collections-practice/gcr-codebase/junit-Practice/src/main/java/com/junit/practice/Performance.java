package com.junit.practice;

public class Performance {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);   // 3 seconds
        return "Task Completed";
    }
}
