package com.jacken.nexuscommons.utils;

/**
 * synchronized  锁的是对象  this 临界资源对象（多线程都能访问的对象），class对象
 *
 * 静态同步方法 锁的是当前类型的类对象，在本类中是synchronizedTest.classs
 * 加锁的目的是为了保证原子性
 *
 */
public class synchronizedTest {
    private  int count=0;
    private Object o=new Object();
    public static void main(String[] args) {

    }

    public  void testSync01(){
        synchronized (o){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
