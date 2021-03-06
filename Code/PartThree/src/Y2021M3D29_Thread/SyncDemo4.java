package Y2021M3D29_Thread;
/**
 * 	互斥锁
 * 	当多个代码片段被synchronized块修饰后，这些同步块的
 * 	同步监听器对象又是同一个时，这些代码片段就是互斥的。多
 * 	个线程不能同时在这些方法中运行。
 * @author Grant·Vranes
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Boo boo1 = new Boo();
		Boo boo2 = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				boo1.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				boo2.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在运行方法A");
			Thread.sleep(5000);
			System.out.println(t.getName()+":运行方法A完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在运行方法B");
			Thread.sleep(5000);
			System.out.println(t.getName()+":运行方法B完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}