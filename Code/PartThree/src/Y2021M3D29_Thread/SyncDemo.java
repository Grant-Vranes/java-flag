package Y2021M3D29_Thread;
/**
 * 	多线程并发的安全问题
 *	 产生：当多个线程并发操作同一资源时，由于线程切换实际的不确定性，会导致执行
 * 	操作资源的代码顺序未按照设计顺序执行，出现操作混乱的情况，严重时可能导致设计瘫痪
 * 
 * 	举个栗子：一个人去银行柜台取钱，他兄弟去提款机取钱，都从同一个账户取钱，假设银行
 * 	系统中这两个线程同时进行，同时对于同一账户余额操作，可能就会出现意想不到的事情。
 * 
 * 	解决：将并发操作同一资源改为同步操作，即：有先后顺序的操作
 * 
 * @author Grant·Vranes
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Table{
	//现在桌子上有20个豆子
	private int beans = 20;
	/*
	 * 
	 * 	当一个方法被synchronized修饰后，该方法称为“同步方法”，即：多线程
	 * 	不能同时在方法内部运行。即当有一个线程执行方法的时候，其他线程都在方法外候着
	 * 
	 * 	强制让多个线程在执行同一方法时变为同步操作就解决了并发安全问题
	 * 
	 * 	在方法上使用synchronized，那么同步监视器对象就是当前方法所属对象，即：
	 * 	方法内部看到的this
	 */
	public synchronized int getBean() {//拿豆子方法
		if(beans == 0) {
			throw new RuntimeException("没有豆子");
		}
		//模拟线程执行到这里没有时间了
		Thread.yield();
		return beans--;
	}
}