package Y2021M3D29_Thread;
/**
 * 	静态方法若使用synchronized修饰，那么该方法
 * 	一定具有同步效果
 * 
 * 	静态方法对应的同步监视器对象为当前类的类对象（Class实例）
 * @author Grant·Vranes
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				Foo.dosome();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class Foo{
	public synchronized static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在运行dosome");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":运行dosome方法完毕");
	}
}
