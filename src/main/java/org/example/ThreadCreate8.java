package org.example;

public class ThreadCreate8 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread thread1 = new Thread(sharedData::setFlagTrue);
        Thread thread2 = new Thread(sharedData::checkFlag);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SharedData {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        flag = true;
    }

    public void checkFlag() {
        while (!flag) {
            // Flag'in true'ya dönmesi için bekliyoruz
        }
        System.out.println("Flag is set to: " + flag);
    }
}