package Y2021M4D4_Collection;
/**
 * JDK5�Ƴ�ʱ���Ƴ���һ���µ����ԣ�
 * 	��ǿ��forѭ����Ҳ��Ϊ��ѭ����for each
 * 
 * 	��ѭ����ȡ����ͳforѭ���Ĺ�������ר������������������ϻ������
 * @author Grant��Vranes
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array = {"one","two","three"};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for(String str : array) {
			System.out.println(str);
		}
	}
}
