package org.example;

import java.util.concurrent.Semaphore;

public class PongTask implements Runnable {

    private Semaphore ping;

    private Semaphore pong;

    public PongTask(Semaphore ping, Semaphore pong) {
        this.ping = ping;
        this.pong = pong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                pong.acquire();
                System.out.println("Pong");
                Thread.sleep(10);
                pong.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
