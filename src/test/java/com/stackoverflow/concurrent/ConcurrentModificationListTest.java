package com.stackoverflow.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonasd on 2017-06-05.
 */
public class ConcurrentModificationListTest {

    public static final String SOME_NAME = "Some Name";

    @Test
    public void addToList() throws Exception {
        ConcurrentModificationList concurrentList = new ConcurrentModificationList();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                concurrentList.addToList(SOME_NAME + i);
            }
            latch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1_000_00; i++) {
                concurrentList.removeFromList(10);
            }
            latch.countDown();
        }).start();
        try {
            latch.await(10l, TimeUnit.SECONDS);
        } catch (InterruptedException iex) {

        }
        System.out.println(concurrentList.getSize());
        assertEquals("There should be no elements left", 0, concurrentList.getSize());
    }

}