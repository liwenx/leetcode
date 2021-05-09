package com.liwx.algorithm.common.producer;

/**
 * 生产者和消费者
 * https://juejin.cn/post/6844903486895865864
 * @author liwenxing
 * @date 2021/5/8 16:55
 */
public class ProducerThread {
    private static Integer count = 0;
    private static  final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void main(String[] args) {
        ProducerThread test1 = new ProducerThread();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }



    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            /**
                             * 使用wait(),notify()和notifyAll()需要先对调用对象加锁
                             */
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有" + count);
                    /**
                     * notify()或者notifyAll()方法调用后，等待线程依旧不会从wait（）返回，需要
                     * notify()或者notifyAll()的线程释放锁之后，等待线程才有机会从wait()返回
                     */
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

}
