package Y2021M4D6_List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 	栈结构
 * 	栈也可以保存一组元素，但是存取元素必须遵循先进后出原则
 * 	Deque双端队列可以实现栈，并且为栈专门提供了两个方法push,pop
 * 	通常我们使用栈是为了实现后退，前进这样的功能
 * @author Grant·Vranes
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println(stack);//[three, two, one]
		
		String str = stack.pop();
		System.out.println(str);//three
		System.out.println(stack);//[two, one]
	}
}
