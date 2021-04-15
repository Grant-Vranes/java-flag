package Y2021M4D4_Collection;
/**
 *	面试题
 * @author Grant·Vranes
 *
 */
public class TypeDemo2 {
	public static void main(String[] args) {
		Location<Integer> loc1 = new Location<Integer>(1,2);
		
		/*
		 * 	泛型可以不指定，不指定则按照默认的Object类型看待
		 */
		Location loc2 = loc1;//loc2中的元素就是Object类型的了
		loc2.setX("三");//意味着原来的Integer实例没了，改成了String类型实例
		System.out.println("loc2:"+loc2);//loc2:(x=三, y=2)
		
		//再次以loc1角度获取x
		int x1 = loc1.getX();//类造型异常,字符串不能转换成Integer
		System.out.println("x1:"+x1);//error
	}
}
