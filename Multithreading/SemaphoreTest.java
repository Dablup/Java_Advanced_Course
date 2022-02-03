package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        // we are creating 200 threads
        // but in Connection class we have semaphore that allows only 10 threads work in a time
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200 ; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionCount;

    //number in constructor means: how many threads can work at the same time with some resource
    private Semaphore semaphore = new Semaphore(10);

    private Connection(){

    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        // we are taking one permit
        semaphore.acquire();
        try {
            doWork();
        } finally {
            // we are releasing one permit
            semaphore.release();
        }
    }


    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionCount++;
            System.out.println(connectionCount);
        }

        Thread.sleep(500);

        synchronized (this){
            connectionCount--;
        }
    }
}
