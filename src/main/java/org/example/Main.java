package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){

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