package Y2021M3D29_Thread;
/**
 * 	线程的优先级
 * 	作用：是用来干涉线程调度器工作的
 * 
 * 	线程优先级越高的，获取cpu次数理论上就越多
 * 	优先级分10个等级，1~10，10的优先级最高，默认是5
 * 
 * 	线程不能主动获取CPU时间片，只能被动的被线程调度器分配
 * 	调整线程的优先级可以最大程度的改善某个线程获取CPU时间片的次数
 * 	
 * @author Grant·Vranes
 *
 */
public class PriorityDemo extends Thread{
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("min");
				}
			}
		};
		
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("max");
				}
			}
		};
		
		Thread nor = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("nor");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		min.start();
		nor.start();
		max.start();
		//运行的结果就是max最大几率先显示完，但也会后min或者nor抢占先机，但那也是极小概率
	}
}
