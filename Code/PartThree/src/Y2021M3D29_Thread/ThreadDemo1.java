package Y2021M3D29_Thread;
/**
 * 	�߳��ǲ������д���ġ�
 * 	�����ִ����̵߳ķ�ʽ��
 * 	��ʽһ���̳�Thread����дrun������run�����о���ϣ���߳�ִ�е��߼�
 * 		��һ�ִ����̵߳ķ�ʽ�Ƚϼ�ֱ�ӣ�����ȱ����Ҫ��������
 * 		1��������Ҫ�̳��̣߳��⵼�²����ټ̳������࣬ʵ�ʿ����о���Ҫ ����
 * 		  ĳ������Ĺ��ܣ���ô�ڼ̳��̺߳����ټ̳������࣬����ֺܶ಻��
 * 		2�������߳����ͬʱ��д��run��������ص����߳����߳�Ҫִ�е�����
 * 		  ��һ����Ȼ����Ϲ�ϵ���������̵߳����á�
 * 
 * @author Grant��Vranes
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 	�����߳�Ҫ����start������������ֱ�ӵ���run������
		 * 	��start����������Ϻ�run�����ܿ�ᱻ�߳����е��á�
		 */
		t1.start();
		t2.start();
	}
}

class MyThread1 extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("�߳�1");
		}
	}
}

class MyThread2 extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("�߳�2");
		}
	}
}