package Y2021M4D6_List;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 	java.util.Queue
 * 	Queue接口继承自Collection
 * 	队列也可以保存一组元素，但是存取元素必须遵循先进先出模式
 * 	常用实现类：LinkedList
 * @author Grant·Vranes
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		/*
		 * 	offer是入队操作，向队列末尾追加元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		System.out.println(queue);//[one, two, three]
		
		/*
		 * 	poll方法时出队操作
		 * 	获取队首元素后，该元素即从队列中被删除
		 */
		String str = queue.poll();
		System.out.println(str);//one
		System.out.println(queue);//[two, three]
		
		/*
		 * 	peek是引用队首元素，元素不做出队操作
		 */
		str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);//[two, three]
		
		/*
		 * 	遍历队列
		 * 	使用迭代器遍历，元素不会因此被队列删除，因为一般的for循环
		 * 	遍历都是要一个个出队，然后输出，并且for循环中的i<queue.size()
		 * 	条件也是一直在变的，所以队列中元素不对完全遍历完
		 * 	for(int i=0; i<queue.size(); i++){
		 * 		String s = queue.poll();
		 * 		System.out.println(s);
		 * 	}
		 * 	当然也不是说不能用，
		 * 	for(int i=queue.size(); i>0; i--)
		 * 	while(queue.size()>0)
		 */
		for(String s : queue) {
			System.out.println(s);
		}
		System.out.println(queue);
	}
}
