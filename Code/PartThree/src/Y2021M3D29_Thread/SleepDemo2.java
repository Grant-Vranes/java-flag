package Y2021M3D29_Thread;
/**
 * 	sleep方法要求必须处理中断异常，原因在于当一个线程调用了sleep方法
 * 	处于阻塞状态的过程中若被调用了它的interrupt()方法中断时，他就会
 * 	在sleep方法中抛出中断异常。这时并非时将这个线程直接中断，而是中断了
 * 	它的阻塞状态
 * @author Grant·Vranes
 *
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		/*
		 * 	JDK1.8之前，由于JVM内存分配的问题，有一个要求：
		 * 	当一个方法的局部变量被这个方法的其他局部内部类所引
		 * 	用时，这个变量声明那个必须是final的
		 * 
		 * 	所以有可能这句th1.interrupt();会报错
		 * 	因为在main方法中线程th1这个局部对象被main方法中的线程th2的内部类所引用
		 */
		final Thread th1 = new Thread() {
			public void run() {
				System.out.println("飞行器预计1000s后到达目的地~");
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("飞行器警报，遭遇飞来流星");
				}
			}
		};
		
		Thread th2 = new Thread() {
			public void run() {
				System.out.println("流星解体，碎成10个小流星");
				for(int i = 0; i < 10; i++) {
					System.out.println("飞来流星🌠");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("🌠击中飞行器");
				System.out.println("发生大爆炸");
				//中断飞行器线程，让飞行器直接被catch捕获
				th1.interrupt();//中断th1线程
			}
		};
		th1.start();
		th2.start();
	}
}
