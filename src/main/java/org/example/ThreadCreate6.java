package org.example;

public class ThreadCreate6 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        //Çeşitli işlemler için 2 thread tanımlıyoruz
        Thread thread1 = new Thread(() -> {
            account.deposit(100);
            account.withdraw(50);
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            account.deposit(200);
            account.withdraw(150);
        }, "Thread2");

        thread1.start();
        thread2.start();
    }
}

class BankAccount {
    private int balance = 0;

    //Bakiyeyi arttırmak için synchronized metod
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + "Tutar yatırıldı: " + amount + " , Kalan bakiye " + balance);
    }

    //Bakiyeden para çekmek için synchronized metod
    public synchronized void withdraw(int amount) {
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "Tutar çekildi: " + amount + " , Kalan bakiye " + balance);
    }
}
