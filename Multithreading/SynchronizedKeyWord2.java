package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedKeyWord2 {
    public static void main(String[] args) {
        new Worker().main();

    }
}

class Worker{
    Random random = new Random();
    private List<Integer> list = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    //Creating locks to use them to synchronize threads
    Object lock1 = new Object();
    Object lock2 = new Object();


    // we should not use synchronized in method here because it synchronized on the whole object
    // when first thread is in the method 'addToList1' it takes the monitor of the whole object 'new Worker'
    // and therefore not allow other threads to work
    // so other thread can not start working(even with method addToList2 until first thread will come out from the method addToList1
    //
    // That is why I created 2 fields 'lock1' and 'lock2'
    // Now we can synchronize on this 2 objects:
    // If one thread takes monitor of the lock1(and do the 'addToList1') then other thread in the same time can take monitor of the
    // lock2(and do the 'addToList2').
    // We could not do this without lock1 and lock2 because we had only one object and therefore only one monitor.
    public void addToList1(){
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(random.nextInt(100));
        }
    }

    public synchronized void addToList2(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }

    }

    public void work(){
        for (int i = 0; i < 1000 ; i++) {
            addToList1();
            addToList2();
        }
    }
    public void main(){
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took this amount of time");
        System.out.println(after - before);
        System.out.println(list.size());
        System.out.println(list2.size());
    }
}
