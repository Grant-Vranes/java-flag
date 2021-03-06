package Y2021M3D29_Thread;
/**
 * 	线程提供了一个静态方法：
 * 	static void sleep(long ms)
 * 	使运行这个方法的线程阻塞指定毫秒。超时后该线程会自动回到RUNNABLE
 * 	状态，等待再次并发运行。
 * @author Grant·Vranes
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		
		try {
			Thread.sleep(5000);//停顿5000ms=5s
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("程序结束了");
	}
}
