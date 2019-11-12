package com.jacken.nexuscommons.utils;

import java.util.concurrent.TimeUnit;

/**
 *
 * 底层相当于一个map  在多线程中为每个线程存储数据的  不同线程之间的变量
 * ThreadLocal.set(value) ->map.put(Thread.getCurrentThread,value)
 * 内存问题：在并发量高的情况下  可能有内存溢出
 *
 * 使用ThreadLocal 的时候，一定要注意回收资源问题，每个线程结束之前，将每个线程保存的变量给删除
 * ThreadLocal.remove();
 * T1线程睡眠2秒中  T2 线程睡眠1秒钟
 *
 */
public class ThreadLocalTest {



    volatile  static  String name="zhangsan";
    static  ThreadLocal<String > tl=new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
            System.out.println(tl.get());
        },"T1").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            name="list";
            tl.set("WANGQIANG");
        },"T2").start();
    }
}
