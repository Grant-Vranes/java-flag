package Y2021M3D19_integer;
/**
 * JDK1.5版本推出时推出了一个特性：
 * 	自动拆装箱
 * 	该特性是编译器认可的，当我们在基本类型和其对应的引用
 * 	类型之间相互赋值时，编译器会自动补全拆装箱的代码
 * @author Grant·Vranes
 *
 */
public class AutoBoxingDemo {
	public static void main(String[] args) {
		/*
		 * 	触发了编译器的自动拆箱特性：
		 * 	编译器会补全代码，将包装类转换为基本类型
		 * 	下面的代码会被编译器补充代码为
		 * 	int d = new Integer(1).intValue();
		 */
		int d = new Integer(1);
		
		/*
		 * 	触发自动装箱特性，编译器会补充代码
		 * 	Integer i = Integer.valueOf(d);
		 */
		Integer i = d;
		
	}
}
