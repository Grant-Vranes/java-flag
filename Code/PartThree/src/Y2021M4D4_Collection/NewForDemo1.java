package Y2021M4D4_Collection;
/**
 * JDK5推出时，推出了一个新的特性：
 * 	增强型for循环，也称为新循环，for each
 * 
 * 	新循环不取代传统for循环的工作，他专门设计是用来遍历集合或数组的
 * @author Grant·Vranes
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
