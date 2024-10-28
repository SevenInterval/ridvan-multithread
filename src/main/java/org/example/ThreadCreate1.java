package org.example;

public class ThreadCreate1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread is running");
    }
}
