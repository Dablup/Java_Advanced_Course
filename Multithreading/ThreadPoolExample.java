/*
        Метафора:
        executorService - количество работников, которые могут выполнять работу
        executorService.submit() - передаем работу, которую нужно выполнить работникам
        executorService.shutdown() - больше никаких работ передавать не будем, работники могут начинать работу
 */


package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        // pool for 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            // take some jobs for the executorService
            executorService.submit(new Work(i));
        }
        // no more jobs for executorService
        executorService.shutdown();
        System.out.println("All task were submitted");
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable{
    private int id;

    public Work(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed");
    }
}