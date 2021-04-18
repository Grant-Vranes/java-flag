package Y2021M4D6_List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 	˫�˶���
 * 	java.util.Deque�ӿ�
 * 	Deque�̳���Queue�ӿ�
 * 	˫�˶�����ָ�������˶������������Ӳ���
 * 	����ʵ���ࣺLinkedList
 * @author Grant��Vranes
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
		deque.offerFirst("three");
		deque.offerLast("four");
		System.out.println(deque);//[three, one, two, four]
		
		String str = deque.pollFirst();
		System.out.println(str);//three
		System.out.println(deque);//[one, two, four]
		
		str = deque.pollLast();
		System.out.println(str);//four
		System.out.println(deque);//[one, two]
		
		//��Ȼ����peekFirst()��peekLast()
	}
}