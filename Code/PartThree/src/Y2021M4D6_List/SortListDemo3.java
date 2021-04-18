package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 	�����ַ���
 * @author Grant��Vranes
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("���컭�");
		list.add("��ì");
		list.add("��ʤ��");
		System.out.println(list);
		//�����������ַ���������
		
		/*
		 * 	String�Ѿ�ʵ����Comparable�ӿڣ��ȽϹ���Ϊ����ÿ���ַ���
		 * 	Unicode����Ƚϡ�
		 * 	������������ʱ��û��ʲô���塣
		 * 
		 * 	�Դˣ���sort������ʹ����Ծ���
		 * 	���Ե���
		 * 	�����Զ�������Ԫ�ػ�java�ṩ���Ѿ�ʵ�ֹ�Comparable�ӿڵ�Ԫ��
		 * 	���ǱȽϷ���������������������ʱ������Ӧ��ʹ�������sort����
		 */
		Collections.sort(list);
		System.out.println(list);//[��ʤ��, ���컭�, ��ì]
		
		/*
		 * 	Collections�ṩ��һ�����ص�sort�������÷�������Ҫ����Ҫ�����
		 * 	�����⣬��Ҫ���ٴ���һ���Ƚ�����Comparator�����ñȽ������Զ���һ�� 
		 * 	�ȽϹ��򣬸�sort������������ȽϹ���Լ���Ԫ�رȽϺ��������
		 */
		 Collections.sort(list, new Comparator<String>() {
			 public int compare(String o1, String o2) {
				 //�����ַ����ȱȽϴ�С
				 return o1.length() - o2.length(); 
			 }
		 	}
		 );  
		 System.out.println(list);//[��ì, ��ʤ��, ���컭�]
	}
}