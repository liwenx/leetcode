package com.liwx.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liwenxing
 * @date 2019/3/19 16:41
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("人到齐了，开会吧......");
            }
        });
        //不传线程进去也可以
//        cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 5; i ++) {
            new CyclicBarrierThread().start();
        }
    }

}
