package Y2021M3D17_string;

import java.util.Arrays;

/**
 * String[] split(String regex)
 * 使用给定的正则表达式来拆分当前字符串
 * 并将拆分后的内容以字符串数组形式返回
 * @author Grant·Vranes
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
