package org.example;

public class ThreadCreate9 {
    public static void main(String[] args) {
        Data data = new Data();

        Thread producer = new Thread(() -> {
            String[] messages = {"message1", "message2", "message3", "message4"};
            for (String message : messages) {
                data.produce(message);
                try {
                    Thread.sleep(500); // Üretici 500ms. bekler
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                data.consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

class Data {
    private String message;
    private boolean hasMessage = false;

    public synchronized void produce(String message) {
        while (hasMessage) {
            try {
                wait(); // mesaj varsa bekler
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer thread interrupted");
            }
        }
        this.message = message;
        hasMessage = true;
        System.out.println("Producer thread produced " + message);
        notify(); // Tüketiciyi uyandırır
    }

    public synchronized void consume() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer thread interrupted");
            }
        }
        System.out.println("Consumer thread consumed");
        hasMessage = false;
        notify(); // Üreticiyi uyandırır
    }
}
