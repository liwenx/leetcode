package com.liwx.algorithm.common.producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java实现一个阻塞队列
 * https://blog.csdn.net/w535921917/article/details/87922910
 * @author liwenxing
 * @date 2021/5/11 上午10:12
 */
public class BlockQueue<T> {
    //阻塞队列大小
    private int size;
    //阻塞队列
    private Object[] queue;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    //push index
    private int index;
    //pop index
    private int removeIndex;
    //当前队列长度
    private int currLen;

    public BlockQueue() {
        this(10);
    }

    public BlockQueue(int size) {
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        this.size = size;
        queue = new Object[size];
    }

    public void  push(T element) throws InterruptedException {
        lock.lock();
        try {
            while (currLen == size) {
                full.await();
            }
            queue[index] = element;
            if (++index == size) {
                index = 0;
            }
            currLen++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();
        try {
            while (currLen == 0) {
                //队列长度为0就一直阻塞，直到被pop唤醒
                empty.await();
            }
            Object obj = queue[removeIndex];
            if (++removeIndex == size) {
                removeIndex = 0;
            }
            currLen--;
            full.signal();
            return (T) obj;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> blockQueue = new BlockQueue<>(3);
        blockQueue.push(1);
        System.out.println(blockQueue.pop());
        blockQueue.push(2);
        System.out.println(blockQueue.pop());
        blockQueue.push(3);
        System.out.println(blockQueue.pop());
        blockQueue.push(4);
        blockQueue.push(5);
        blockQueue.push(6);
        System.out.println(blockQueue.pop());
    }
}
