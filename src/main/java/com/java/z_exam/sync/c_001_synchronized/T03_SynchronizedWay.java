package com.java.z_exam.sync.c_001_synchronized;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-29 9:15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */


public class T03_SynchronizedWay {

    private int count = 10;

    public synchronized void m() { // 等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}


/*

如果你要是锁定当前对象，你也可以写成synchronized 方法名()，这个和synchronized(this)是等值的。

我明知道静态方法 static 是没有 this 对象的，你不需要 new 出一个对象来就能执行这个方法，
但是如果这个上面加一个 synchronized 的话就表示 synchronized(T.class)，这里这个 synchronized(T.class) 锁的就是T类的对象。

 */