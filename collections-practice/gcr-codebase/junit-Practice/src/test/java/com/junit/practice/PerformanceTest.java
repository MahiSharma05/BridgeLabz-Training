package com.junit.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PerformanceTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {

        Performance task = new Performance();

        try {
            task.longRunningTask();
        } catch (InterruptedException e) {
            // handling exception
        }
    }
}
