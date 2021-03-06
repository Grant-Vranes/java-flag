package Y2021M3D19_integer;
/**
 *	包装类
 *	包装类是为了解决基本类型不能直接参与面向对象开发的问题
 *	其中6个数字类型的包装类继承自Number类
 *	java.lang.Number是一个抽象类，定义了几个抽象方法
 *	要求数字类型的包装类可以将其表示的数字以任意数字类型返回
 */
public class IntegerDemo1{
	public static void main(String[] args) {
		int d = 1;
		/*
		 * 	以下两行转换成包装类不是Java推荐的方法，
		 * 	因为每次调用都会重新new对象
		 */
		Integer i1 = new Integer(d);
		Integer i2 = new Integer(d);
		
		System.out.println(i1==i2);//false
		System.out.println(i1.equals(i2));//true
		
		/*
		 * 	java中推荐使用Integer.valueOf()转换包装类
		 * 	为什么推荐呢？去看源码就知道：valueOf方法使用的时候
		 * 	是不是要new新的对象，他首先要判断你这个要装箱的数是不是
		 * 	在这个整数缓存中，如果在整数缓存中，就重用对象，所以
		 * 	i3==i4就为true，因为指向同一对象。如果超出[-128，127]
		 * 	这个范围，就会重新new对象，所以此时i3和i4就不再指向同一
		 * 	对象，i3==i4就为false。更多了解可以看代码下方的图
		 */
		Integer i3 = Integer.valueOf(d);
		Integer i4 = Integer.valueOf(d);
		
		System.out.println(i3==i4);//true
		System.out.println(i3.equals(i4));//true
	
		/*
		 *	 包装类转换为基本类型
		 */
		d = i1.intValue();
		System.out.println(d);
		
		/*
		 *	数字类型的包装类都定义了两个常量
		 *  MAX_VALUE
		 *  MIN_VALUE
		 * 	用于表示该包装类对应的基本类型的取值范围
		 */
		int imax = Integer.MAX_VALUE;
		System.out.println(imax);//2147483647
		int imin = Integer.MIN_VALUE;
		System.out.println(imin);//-2147483648
	}
}

