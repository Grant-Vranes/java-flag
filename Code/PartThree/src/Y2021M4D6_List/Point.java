package Y2021M4D6_List;
/**
 * 	ʹ�õ�ǰ��ʵ����Ϊ����Ԫ�أ����Լ�����ز���
 * @author Grant��Vranes
 *
 */
public class Point implements Comparable<Point>{
	//				�˴��̳нӿڣ��������ӷ��ͣ�������Ĭ��Object����
	/*
	 * 	ΪʲôҪ�̳нӿ�?
	 * 	Collections��sort��������ļ���Ҫ��Ԫ�ر���ʵ��Comparable�ӿ�
	 * 	Ȼ����дcompareTo�������ڷ����ж���ȽϵĹ���
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
	 * 	��һ����ʵ����Comparable�ӿں������д������compareTo
	 * 	�÷����������ǱȽϵ�ǰ����this�뷽���Ĳ�������o֮��Ĵ�С
	 * 
	 * 	����ֵ�����ľ���ȡֵ��ֻ����ȡֵ��Χ
	 * 	������ֵ>0:��ǰ������ڲ�������(this>0)
	 * 	������ֵ<0:��ǰ����С�ڲ�������
	 * 	������ֵ=0:�����������
	 * 
	 * 	���磺p.compareTo(p2)
	 * 	p����this; p2����o
	 */
	public int compareTo(Point o) {
		//ֻ��Ҫ�Ƚ��������У�����㵽ԭ�ĵľ���˭��˭С
		int len = this.x*this.x + this.y*this.y;
		int olen = o.x*o.x + o.y*o.y;
		return len-olen;
	}
}