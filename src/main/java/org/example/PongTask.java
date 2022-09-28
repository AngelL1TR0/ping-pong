package org.example;

import java.util.concurrent.Semaphore;

public class PongTask implements Runnable{

    Semaphore semaphorePong = new Semaphore(2);

    @Override
    public void run() {

    }
}
