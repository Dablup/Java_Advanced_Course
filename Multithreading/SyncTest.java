package Multithreading;

public class SyncTest {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        SyncTest test = new SyncTest();
        test.doWork();
    }


    // synchronized не дает нескольким потокам выполнять данный метод
    public synchronized void increment(){
        counter++;
    }
    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000 ; i++) {
                 increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000 ; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}
