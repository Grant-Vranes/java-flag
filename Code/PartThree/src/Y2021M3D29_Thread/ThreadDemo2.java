package Y2021M3D29_Thread;
/**
 * 	第二种创建线程的方式
 * 	实现Runnable接口，单独定义线程任务
 * @author Grant·Vranes
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//实例化两个任务
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		//创建两个线程并指派任务
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("线程1");
		}
	}
}

class MyRunnable2 implements Runnable{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("线程2");
		}
	}
}
