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
		//以下两行转换成包装类不是Java推荐的方法
		Integer i1 = new Integer(d);
		Integer i2 = new Integer(d);
		
		System.out.println(i1==i2);//false
		System.out.println(i1.equals(i2));//true
		
		//java中推荐使用Integer.valueOf()转换包装类
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
		System.out.println(imax);
		int imin = Integer.MIN_VALUE;
		System.out.println(imin);
	}
}

