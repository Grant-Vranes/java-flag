package Y2021M3D29_Thread;
/**
 * 线程提供了一个方法：
 * void join()
 * 该方法可以协调线程之间的同步运行
 * 
 * 同步与异步：
 * 同步运行：运行有顺序
 * 异步运行：运行代码无顺序，多线程并发运行就是异步运行
 * @author Grant·Vranes
 *	
 *	这个程序的需求是，我想让download线程执行完毕后，再执行
 *	show线程（图片下载完毕后，再进行图片展示）
 */
public class JoinDemo {
	//标识图片是否下载完毕
	private static boolean isFinish = false;
	/*
	 * 解惑：isFinish变量只在main方法中使用，为什么不放在main方法中呢？
	 * 因为isFinish如果放在main方法中，当一个方法的局部变量被这个方法的其
	 * 他局部内部类所引用时，这个变量声明那个必须是final的，然后声明成final
	 * 发现，final的值是不可修改的，这就有悖。所以直接将他设置为一个成员属性。
	 */
	
	public static void main(String[] args) {
		Thread download = new Thread() {
			public void run() {
				System.out.println("down:开始下载图片...");
				for (int i = 0; i <= 100; i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(20);
					}catch(InterruptedException e) {
					}
				}
				System.out.println("down:图片下载完毕");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			public void run() {
				System.out.println("show:开始显示图片");
				//加载图片前应该先等待下载线程将图片下载
				//让show等着download把活先干完，所以我们要阻塞show
				
				try {
					/*
					 * show线程在调用download.join()方法后，表明自己跟在了download后面，
					 * 就进入了阻塞状态，直到download线程的run方法执行完毕才会解除阻塞
					 */
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!isFinish) {
					//自定义异常
					throw new RuntimeException("加载图片失败");
				}
				System.out.println("show:显示图片完毕");
			}
		};
		
		download.start();
		show.start();
	}
}
