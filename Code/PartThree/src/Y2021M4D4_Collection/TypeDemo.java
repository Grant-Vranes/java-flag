package Y2021M4D4_Collection;
/**
 * 	测试泛型
 *	泛型是编译器认可的，并非虚拟机JVM
 * 	编译器会将泛型改为Object。所以泛型的实际类型就是Object
 * 	在使用泛型时，编译器会辅助做两个操作
 * 	1：对泛型设置值时，编译器会检查该值的类型是否与泛型一致，
 * 		不一致则编译不通过
 * 	2：在获取泛型值时，编译器会添加向下造型的代码。
 * @author Grant·Vranes
 *
 */
public class TypeDemo {
	public static void main(String[] args) {
		//自己在<>中定义需要使用的类型
		Location<Integer> loc1 = new Location<Integer>(1,2);
		loc1.setX(2);
		int x1 = loc1.getX();
		System.out.println("loc1:"+loc1);//loc1:(x=2, y=2)
		System.out.println("x1:"+x1);//x1:2
		
		Location<Double> loc2 = new Location(3.0, 5.0);
		loc2.setX(7.0);
		double x2 = loc2.getX();
		System.out.println("loc2:"+loc2);//loc2:(x=7.0, y=5.0)
		System.out.println("x2:"+x2);//x2:7.0
	}
}
