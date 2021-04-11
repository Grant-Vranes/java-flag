package Y2021M4D4_Collection;
/**
 * 	泛型
 * 	泛型是JDK5推出的特性，也称为参数化类型
 * 	它允许将一个类中属性的类型、方法参数的类型
 * 	以及方法返回值类型等的定义权移交给使用者。
 * 	这使得实际应用中使用这个类更加灵活便捷。
 * @author Grant·Vranes
 *
 */
public class Location<E> {
	//也可以定义多类型Location<E,R>,E,R这两个大些字母没有固定要求
	private E x;//private E x;
	private E y;//private R y;
	public Location(E x, E y) {
		super();
		this.x = x;
		this.y = y;
	}
	public E getX() {
		return x;
	}
	public void setX(E x) {
		this.x = x;
	}
	public E getY() {
		return y;
	}
	public void setY(E y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "(x=" + x + ", y=" + y + ")";
	}
}
