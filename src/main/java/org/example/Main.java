package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){

        Semaphore semaphorePing = new Semaphore(2);
        Semaphore semaphorePong = new Semaphore(2);

        Thread hiloPing = new Thread(new PingTask(semaphorePing, semaphorePong));
        Thread hiloPong = new Thread(new PongTask(semaphorePing, semaphorePong));


        hiloPing.start();
        hiloPong.start();
        try {
            Semaphore pingSemaphore = new Semaphore(1);
            Semaphore pongSemaphore = new Semaphore(1);

            pongSemaphore.acquire();

            Thread pingThread = new Thread(new PingTask(pingSemaphore, pongSemaphore));
            Thread pongThread = new Thread(new PongTask(pingSemaphore, pongSemaphore));

            pingThread.start();
            pongThread.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}