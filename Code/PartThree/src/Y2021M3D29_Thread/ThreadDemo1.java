package Y2021M3D29_Thread;
/**
 * 	线程是并发运行代码的。
 * 	有两种创建线程的方式：
 * 	方式一：继承Thread并重写run方法。run方法中就是希望线程执行的逻辑
 * 		第一种创建线程的方式比较简单直接，但是缺点主要有两个：
 * 		1：由于需要继承线程，这导致不能再继承其他类，实际开发中经常要 复用
 * 		  某个超类的功能，那么在继承线程后不能再继承其他类，这会又很多不便
 * 		2：定义线程类的同时重写了run方法，这回导致线程与线程要执行的任务
 * 		  有一个必然的耦合关系，不利于线程的重用。
 * 
 * @author Grant·Vranes
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 	启动线程要调用start方法，而不是直接调用run方法。
		 * 	当start方法调用完毕后，run方法很快会被线程自行调用。
		 */
		t1.start();
		t2.start();
	}
}

class MyThread1 extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("线程1");
		}
	}
}

class MyThread2 extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("线程2");
		}
	}
}