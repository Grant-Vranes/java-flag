package Y2021M5D17_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 	线程池
 * 	线程池主要有两个作用：
 * 	1：控制线程数量
 * 	2：重用线程
 * @author Grant·Vranes
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			Runnable runn = new Runnable() {//匿名内部类
				public void run() {
					Thread t = Thread.currentThread();
					try {
						System.out.println(t.getName()+"正在运行任务。。。");
						Thread.sleep(5000);
						System.out.println(t.getName()+"运行任务结束");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			//将任务指派给线程池
			threadPool.execute(runn);
			System.out.println("指派了一个任务给线程池");
			/*
			 * 	此时我有5个线程任务，但是我线程池中只可以同时运行两个线程，所以运行会是2-2-1的模式
			 * 	先运行2个，这两个运行结束后又会接收两个线程任务来运行，最后谁先运行完谁去运行最后一个
			 * 	线程任务
			 * 
			 * 	但是所有线程任务运行完毕后，这个程序并不会停止，（程序中，当所有前台线程运行结束时，进程才会结束）
			 * 	但这个程序仍在运行，说明仍有前台线程或者，就是线程池中的这两个线程。
			 * 
			 * 	当线程池中任务执行完毕后，他不会运行结束，而是仍然等着你给他分配任务
			 */
		}//此时for循环结束
		
		/*
		 * 	停止线程池
		 * 	shutdown()方法调用后，线程池不再接受新任务，并且会将线程池中所有的任务执行后自动停止
		 * 	shutdownNow()方法调用后，线程池会强制中断所有线程立即停止
		 */
		threadPool.shutdown();
		System.out.println("线程池停止了！");
		
	}
}
