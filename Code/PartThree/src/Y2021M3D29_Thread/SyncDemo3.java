package Y2021M3D29_Thread;
/**
 * 	��̬������ʹ��synchronized���Σ���ô�÷���
 * 	һ������ͬ��Ч��
 * 
 * 	��̬������Ӧ��ͬ������������Ϊ��ǰ��������Classʵ����
 * @author Grant��Vranes
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
		System.out.println(t.getName()+":��������dosome");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":����dosome�������");
	}
}