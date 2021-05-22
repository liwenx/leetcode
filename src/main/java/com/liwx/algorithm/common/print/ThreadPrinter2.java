package com.liwx.algorithm.common.print;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印ABC10次，打印结束后输出"finished"
 * https://blog.csdn.net/xiaokang123456kao/article/details/77331878
 *
 * @author liwenxing
 * @date 2021/5/9 14:29
 */
public class ThreadPrinter2 {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Printer(0));
        a.setName("A");
        a.start();

        Thread b = new Thread(new Printer(1));
        b.setName("B");
        b.start();

        Thread c = new Thread(new Printer(2));
        c.setName("C");
        c.start();

        countDownLatch.await();
        System.out.println("finished");
    }

    //三个线程都加这个锁
    private static Lock lock = new ReentrantLock();
    //判断当前对象是否应该打印
    private static int state = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(30);

    static class Printer implements Runnable {
        private int curr;
        public Printer(int curr) {
            this.curr = curr;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                lock.lock();
                try {
                    while (state % 3 == curr) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.println(Thread.currentThread().getName());
                        state++;
                        i++;
                        countDownLatch.countDown();
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

}
