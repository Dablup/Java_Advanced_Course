package Multithreading;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread.shutDown();
    }
}



class MyThread extends Thread{

    // volatile means that variable will not be saved to the caches of cpu's
    private volatile boolean running = true;

    public void run(){
        while(running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutDown(){
        this.running = false;
    }
}