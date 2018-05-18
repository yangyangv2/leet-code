package utils.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();

        lock.tryLock();

        lock.unlock();


    }
}
