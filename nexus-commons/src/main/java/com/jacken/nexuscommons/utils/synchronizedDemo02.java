package com.jacken.nexuscommons.utils;

import java.util.concurrent.TimeUnit;

/**
 * 锁与异常  当同步方法中发生异常的时候  会自动释放锁
 *
 * 不会影响其他线程的执行
 *
 * synchronized 在发生异常的时候回自动释放锁  发生异常后在catch中应该处理的事情
 *
 * volatile  保证线程的可见性
 *
 * thread.join  连接多线程  使多线程 连成一条线执行
 */
public class synchronizedDemo02 {
    int i=0;
    synchronized  void m(){
        System.out.println(Thread.currentThread().getName()+"--starat");
        while (true){
            i++;
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i==5){
                try {
                    i=1/0;
                }catch (Exception e){
                    i=0;
                }

            }

        }
    }

    public static void main(String[] args) {
        synchronizedDemo02 synchronizedDemo02 = new synchronizedDemo02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo02.m();
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo02.m();
            }
        },"t2").start();
    }
}
