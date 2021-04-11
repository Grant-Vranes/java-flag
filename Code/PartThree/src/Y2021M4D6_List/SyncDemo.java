package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 	集合有线程安全的实现。
 * 	我们可以借助Collections将现有集合转换为一个线程安全的。
 * @author Grant·Vranes
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		/*
		 * 	List中常用的实现类：
		 * 	ArrayList，LinkedList他们都不是线程安全的
		 */
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		
		/*
		 * 	将给定的集合转换为一个线程安全的
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		/*
		 * 	HashSet同样也不是线程安全的
		 */
		Set<String> set = new HashSet<String>(list);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		/*
		 * 	文档上有注明一个事情：
		 * 	即使是一个线程安全的集合，他也要不同的迭代器遍历做互斥，
		 * 	所以这个操作要自行维护。
		 */
		
		/*
		 * 	队列也有并发安全的实现
		 * 	阻塞队列
		 * 	BlockingQueue，BlockingDeque
		 * 	阻塞队列内部使用双缓冲实现，在保证并发安全的
		 * 	前提下解决了存取互斥问题，所以并发效率更好
		 */
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		
		queue.offer("one");
		
		/*
		 * 	BlockingQueue提供了重载的offer方法
		 * 	offer("",等待时间 , 等待时间单位);
		 */
		try {
			//如果操作不能马上进行，操作会被阻塞指定的时间
			queue.offer("two", 500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
