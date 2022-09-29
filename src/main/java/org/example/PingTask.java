package org.example;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable{

    private Semaphore ping;

    private Semaphore pong;

    public PingTask(Semaphore ping, Semaphore pong) {
        this.ping = ping;
        this.pong = pong;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                ping.acquire();
                System.out.println("Ping");
                Thread.sleep(10);
                ping.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
