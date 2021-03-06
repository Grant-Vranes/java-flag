package Y2021M4D6_List;
/**
 * 	使用当前类实例作为集合元素，测试集合相关操作
 * @author Grant·Vranes
 *
 */
public class Point implements Comparable<Point>{
	//				此处继承接口，可以添加泛型，不添加默认Object类型
	/*
	 * 	为什么要继承接口?
	 * 	Collections的sort方法排序的集合要求元素必须实现Comparable接口
	 * 	然后重写compareTo方法，在方法中定义比较的规则
	 */
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
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
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj instanceof Point) {
			Point p = (Point)obj;
			return this.x==p.x&&this.y==p.y;
		}
		return false;
	}
	@Override
	/*
	 * 	当一个类实现了Comparable接口后必须重写方法：compareTo
	 * 	该方法的作用是比较当前对象this与方法的参数对象o之间的大小
	 * 
	 * 	返回值不关心具体取值，只关心取值范围
	 * 	当返回值>0:当前对象大于参数对象(this>0)
	 * 	当返回值<0:当前对象小于参数对象
	 * 	当返回值=0:两个对象相等
	 * 
	 * 	比如：p.compareTo(p2)
	 * 	p就是this; p2就是o
	 */
	public int compareTo(Point o) {
		//只需要比较坐标轴中，这个点到原心的距离谁大谁小
		int len = this.x*this.x + this.y*this.y;
		int olen = o.x*o.x + o.y*o.y;
		return len-olen;
	}
}
