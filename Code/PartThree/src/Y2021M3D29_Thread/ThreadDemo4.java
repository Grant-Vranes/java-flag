package Y2021M3D29_Thread;
/**
 * 	�߳��ṩ�˻�ȡ������Ϣ����ط���
 * @author Grant��Vranes
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		//��ȡ�̵߳�����
		String name = main.getName();
		System.out.println("name:"+name);
		
		//��ȡ�̵߳�Ψһ��ʶ(id)
		long id = main.getId();
		System.out.println("id:"+id);
		
		//��ȡ�̵߳����ȼ�
		int priority = main.getPriority();
		System.out.println("���ȼ���"+priority);
		
		//�߳��Ƿ񻹴��ڻ״̬
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		//�߳��Ƿ��ж���
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
		//�߳��Ƿ�Ϊ�ػ��߳�
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon"+isDaemon);
	
	}
}
