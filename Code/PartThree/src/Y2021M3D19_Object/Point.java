package Y2021M3D19_Object;
/**
 * 使用当前类测试重写Object相关方法
 * @author Grant·Vranes
 *
 */
public class Point {
	private int x;
	private int y;
	
	//构造方法
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//get,set方法:右击选择Source...
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 *  toString方法会被很多API调用。所以当我们定义
	 *	 一个类时，很常见的操作就是重写这个方法。该方法的
	 *	意义是将当前对象转换为一个字符串形式。该字符串内
	 *	容格式没有严格的要求。
	 *	原则为包含这个对象的相关属性信息。
	 */
	public String toString() {
		
		return "("+x+","+y+")";
	}
	
	/**
	 * equals的作用时比较当前对象与参数对象的内容是否一致
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(obj instanceof Point) {//obj与我同一类型
			Point p = (Point)obj;//先转成一个Point实例出来
			return this.x==p.x&&this.y==p.y;
		}
		return false;
	}
}
