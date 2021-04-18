package Y2021M4D6_List;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 	java.util.Queue
 * 	Queue�ӿڼ̳���Collection
 * 	����Ҳ���Ա���һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ�Ƚ��ȳ�ģʽ
 * 	����ʵ���ࣺLinkedList
 * @author Grant��Vranes
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		/*
		 * 	offer����Ӳ����������ĩβ׷��Ԫ��
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		System.out.println(queue);//[one, two, three]
		
		/*
		 * 	poll����ʱ���Ӳ���
		 * 	��ȡ����Ԫ�غ󣬸�Ԫ�ؼ��Ӷ����б�ɾ��
		 */
		String str = queue.poll();
		System.out.println(str);//one
		System.out.println(queue);//[two, three]
		
		/*
		 * 	peek�����ö���Ԫ�أ�Ԫ�ز������Ӳ���
		 */
		str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);//[two, three]
		
		/*
		 * 	��������
		 * 	ʹ�õ�����������Ԫ�ز�����˱�����ɾ������Ϊһ���forѭ��
		 * 	��������Ҫһ�������ӣ�Ȼ�����������forѭ���е�i<queue.size()
		 * 	����Ҳ��һֱ�ڱ�ģ����Զ�����Ԫ�ز�����ȫ������
		 * 	for(int i=0; i<queue.size(); i++){
		 * 		String s = queue.poll();
		 * 		System.out.println(s);
		 * 	}
		 * 	��ȻҲ����˵�����ã�
		 * 	for(int i=queue.size(); i>0; i--)
		 * 	while(queue.size()>0)
		 */
		for(String s : queue) {
			System.out.println(s);
		}
		System.out.println(queue);
	}
}