package Y2021M3D19_Object;
/**
 *	 测试Point重写Object相关方法
 * @author Grant·Vranes
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(12,13);
		
		/*
		 * 	通常我们定义的类如果需要使用到toString方法时，
		 * 	就应当重写这个方法。Object提供的输出的是该对象
		 * 	的句柄(相当于该对象的类名+地址)，没什么实际意义。
		 */
		String str = p.toString();
		System.out.println(str);//(12,13)
	
		/*
		 *  System.out.println(Object obj);
		 * 	该方法会将给定对象的toString方法返回的字符串
		 * 	输出到控制台
		 */
		System.out.println(p);//(12,13)，看似没有调用toString方法，但实际上java的API默认调用了
	
		Point p2 = new Point(12, 13);
		System.out.println(p==p2);//false
		System.out.println(p.equals(p2));//没重写equals方法就是false，写了之后就true
		/*
		 * Object中的equals方法默认是执行==，如下
		 * public boolean equals(Object obj) {
         *		return (this == obj);
    	 * }
    	 * 	自己定义的类中，需要去重写她，不然没有任何意义(与==一样的效果)。但在java已经定义好的类中是可以直接用的(因为它已经重写好了)
		 *	我们定义的类如果使用equals,就应当重写这个方法。Object
		 *	提供的equals方法本身内部就是用“==”进行比较的，没有实际意义
		 *	Java API提供的类，toString，equals方法都妥善进行了重写。
		 */
		
	}
}
