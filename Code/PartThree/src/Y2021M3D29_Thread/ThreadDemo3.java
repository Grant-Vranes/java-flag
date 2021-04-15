package Y2021M3D29_Thread;
/**
 * 	线程提供了获取相关信息的方法
 * @author Grant·Vranes
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		/*
		 * 	线程提供了一个静态方法：
		 * 	static Thread currentThread()
		 * 	该方法用来获取运行这个方法的线程
		 * 	
		 * 	main方法也是靠一个线程运行的，当JVM启动后会自动创建
		 * 	一个线程来执行main方法。而这个线程的名字叫做main，
		 * 	我们称它为主线程
		 * 
		 * 
		 */
		Thread main = Thread.currentThread();
		System.out.println("运行main方法的线程：" + main);
		dosome();
		
		Thread t = new Thread() {//匿名内部类
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("自定义线程:"+t);
				dosome();
			}
		};
		t.start();
	}
	
	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程：" + t);
	}
	
}
