package com.jacken.nexuscommons.utils;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类型
 */
public class synchronizedDemo03 {

    AtomicInteger atomicInteger=new AtomicInteger(0);
    void  m(){
        for (int i = 0; i < 10000; i++) {
            //count++
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        final  synchronizedDemo03 t=new synchronizedDemo03();
        ArrayList<Thread> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }));

        }
        for (Thread thread : arrayList) {
            thread.start();
        }

        for (Thread thread : arrayList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(t.atomicInteger.intValue());
    }
}
