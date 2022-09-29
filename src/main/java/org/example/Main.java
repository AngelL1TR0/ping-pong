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
    }
}