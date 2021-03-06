package Y2021M3D29_Thread;
/**
 * 	守护线程
 * 	守护线程又称为后台线程，默认创建的线程都是普通线程或称为
 * 	前台线程，线程提供了一个方法：
 * 	void setDaemon(boolean on)
 * 	只有调用该方法并传入参数true时，该线程才会被设置为守护线程
 * 
 * 	守护线程在使用上与普通线程没有差别，但是在结束时机上有一个区别，
 * 	即：线程结束时所有正在运行的守护线程都会被强制停止。
 * 	
 * 	而线程的结束是指：当一个进程中所有的普通线程都结束时，进程即结束。
 * 
 * 	所以守护线程的工作情况一般是：该线程一直存在，不会自动关闭，全程都需要使用，但进程结束后就不需要。
 * @author Grant·Vranes
 *
 *	这个程序的需求是rose线程执行完后，jack线程也执行完毕
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		//模拟杰克和rose的跳船场景，杰克守护rose
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);//1秒钟喊一次
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:aaaaaaaaaaaa");
				System.out.println("落水声");
			}
		};
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump , i jump");
					try {
						Thread.sleep(1000);//1秒钟喊一次，一旦rose落水，jack也不喊了
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		rose.start();
		
		/*
		 * 设置jack为守护线程
		 * 注意，必须在线程启动前进行设置
		 * 普通线程都结束的时候，运行中的守护线程都会被强制停止，rose就是一个普通线程
		 */
		jack.setDaemon(true);
		jack.start();
		
		/*
		 * 注意：mian方法本身也是一个普通线程（前台线程），执行完main方法中所有代码
		 * 就会自动结束，但如果main中有一个死循环，main就一直结束不了，守护线程就一直存在
		 */
	}
}
