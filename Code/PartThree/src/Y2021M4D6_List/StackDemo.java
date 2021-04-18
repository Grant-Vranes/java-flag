package Y2021M4D6_List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 	ջ�ṹ
 * 	ջҲ���Ա���һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ�Ƚ����ԭ��
 * 	Deque˫�˶��п���ʵ��ջ������Ϊջר���ṩ����������push,pop
 * 	ͨ������ʹ��ջ��Ϊ��ʵ�ֺ��ˣ�ǰ�������Ĺ���
 * @author Grant��Vranes
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