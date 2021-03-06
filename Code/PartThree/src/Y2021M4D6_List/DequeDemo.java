package Y2021M4D6_List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 	双端队列
 * 	java.util.Deque接口
 * 	Deque继承自Queue接口
 * 	双端队列是指队列两端都可以做进出队操作
 * 	常用实现类：LinkedList
 * @author Grant·Vranes
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
		
		//当然还有peekFirst()和peekLast()
	}
}
