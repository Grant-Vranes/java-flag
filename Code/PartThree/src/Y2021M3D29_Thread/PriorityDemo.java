package Y2021M3D29_Thread;
/**
 * 	�̵߳����ȼ�
 * 	���ã������������̵߳�����������
 * 
 * 	�߳����ȼ�Խ�ߵģ���ȡcpu���������Ͼ�Խ��
 * 	���ȼ���10���ȼ���1~10��10�����ȼ���ߣ�Ĭ����5
 * 
 * 	�̲߳���������ȡCPUʱ��Ƭ��ֻ�ܱ����ı��̵߳���������
 * 	�����̵߳����ȼ��������̶ȵĸ���ĳ���̻߳�ȡCPUʱ��Ƭ�Ĵ���
 * 	
 * @author Grant��Vranes
 *
 */
public class PriorityDemo {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("min");
				}
			}
		};
		
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("max");
				}
			}
		};
		
		Thread nor = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("nor");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		min.start();
		nor.start();
		max.start();
		//���еĽ��������max��ʾ����ǰ�棬���Ҵ󲿷�������ʾ��
	}
}