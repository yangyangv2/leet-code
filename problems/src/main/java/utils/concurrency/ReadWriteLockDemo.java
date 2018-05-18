package utils.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();

        // read luck must be released before lock the write lock
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();
        // while writeLock is locked, it can down grade with read lock
        readWriteLock.readLock().lock();
        readWriteLock.writeLock().unlock();
        readWriteLock.readLock().unlock();

    }
}
