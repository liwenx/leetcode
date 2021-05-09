package com.liwx.algorithm.common.print;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 三个线程交替打印ABC10次，打印结束后输出"finished"
 *
 * @author liwenxing
 * @date 2021/5/9 14:06
 */
public class ThreadPrinter1 {
    private static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String[] args) throws InterruptedException {

        //三个对象锁
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Printer pa = new Printer("A", c,a);
        Printer pb = new Printer("B", a,b);
        Printer pc = new Printer("C", b,c);
        new Thread(pa).start();//c a加锁，a输出'A'，a唤醒pb，a解锁（synchronized (a){}同步块结束），c.wait()->该线程pa等待（c暂时解锁，直至其它线程执行c.notify()之后，该线程pa才能继续执行（即被唤醒）---可以理解为等待c的通知）
//        Thread.sleep(10);//在单线程下，Thread.sleep（10000）让你的线程“睡眠”10000ms，也就是不工作，因为是单线程，所以要等到过了10000ms之后，该子线程继续工作。
        //多线程下，睡眠的线程main先不工作，让其余的子线程先工作，等过了10000ms之后，它再重新回到线程的等待队伍中，开始工作。
        //main睡眠10ms结束后，执行下面的语句，即new Thread(pb).start();----pb线程启动后，main再睡眠10ms，接着启动pc。这样不让pb和pc相邻启动，避免pc和pb竞争（因为开始时pc和pb都符合条件）
        new Thread(pb).start();//a b加锁，b输出'B'，b唤醒pc，b解锁，a.wait()->该线程pb等待（c暂时解锁，直至其它线程执行a.notify()之后，该线程pb才能继续执行）
//        Thread.sleep(10);
        new Thread(pc).start();//b c加锁，c输出'C'，c唤醒pa，c解锁，b.wait()->该线程pc等待（b暂时解锁，直至其它线程执行b.notify()之后，该线程pc才能继续执行）
//        Thread.sleep(10);
        countDownLatch.await();
        System.out.println("finished");
    }


    public static class Printer implements Runnable {

        private String name;//当前打印
        private Object prev;//上一个线程锁
        private Object self;//自身锁

        public Printer(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (prev) {
                    synchronized (self) {
                        System.out.println(name);
                        count--;
                        countDownLatch.countDown();
                        self.notify();
                    }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
