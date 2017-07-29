package by.epam.makarevich.entity;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VanQueue {
    private static Lock lock = new ReentrantLock();
    private final int QUEUE_CAPACITY = 20;
    private Queue<Van> vans;

    public VanQueue() {
        vans = new PriorityQueue<>(QUEUE_CAPACITY, Comparator.comparingInt(Van::getStateUrgent));
    }

    public void addVan(Van van) {
        lock.lock();
        this.vans.add(van);
        lock.unlock();
    }
}
