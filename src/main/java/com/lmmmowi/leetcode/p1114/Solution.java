package com.lmmmowi.leetcode.p1114;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/14
 * @Description: 1114.按序打印[https://leetcode-cn.com/problems/print-in-order/]
 */
public class Solution {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Arrays.asList(1, 2, 3).forEach(i -> new TestThread(foo, i).start());
    }

}

class TestThread extends Thread {
    private Foo foo;
    private int index;

    public TestThread(Foo foo, int index) {
        this.foo = foo;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            switch (index) {
                case 1:
                    foo.first(() -> System.out.println("one"));
                    break;
                case 2:
                    foo.second(() -> System.out.println("two"));
                    break;
                case 3:
                    foo.third(() -> System.out.println("three"));
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Foo {

    private Semaphore lockA = new Semaphore(1);
    private Semaphore lockB = new Semaphore(1);

    public Foo() {
        try {
            lockA.acquire();
            lockB.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        lockA.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lockA.acquire();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        lockB.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lockB.acquire();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

