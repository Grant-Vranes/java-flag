package Y2021M3D17_string;

import java.util.Arrays;

/**
 * String[] split(String regex)
 * ʹ�ø�����������ʽ����ֵ�ǰ�ַ���
 * ������ֺ���������ַ���������ʽ����
 * @author Grant��Vranes
 *
 */
public class SplitDemo {
	public static void main(String[] args) {
		String str = "abc123def";
		String regex = "[0-9]+";
		String[] array = str.split(regex);
		System.out.println(array.length);//2
		System.out.println(Arrays.toString(array));//[abc, def]
	
		String regex1 = "[0-9]";
		String[] array1 = str.split(regex1);
		System.out.println(array1.length);//4
		System.out.println(Arrays.toString(array1));//[abc, , , def]
	}
}
