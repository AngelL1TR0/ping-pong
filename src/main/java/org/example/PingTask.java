package org.example;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable{

    Semaphore semaphorePing = new Semaphore(2);

    @Override
    public void run() {

    }
}
