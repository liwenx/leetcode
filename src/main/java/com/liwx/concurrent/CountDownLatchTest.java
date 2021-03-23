package com.liwx.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author liwenxing
 * @date 2019/3/19 17:01
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有人都到齐了，开会吧...");
        }
    }

    /**
     * 员工线程，到达会议室
     */
    static class EmployeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",到达会议室...");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        //
        new BossThread().start();

        for (int i = 0; i < countDownLatch.getCount(); i ++) {
            new EmployeeThread().start();
        }
    }

}
