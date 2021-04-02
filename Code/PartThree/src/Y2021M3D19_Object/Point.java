package Y2021M3D19_Object;
/**
 * ʹ�õ�ǰ�������дObject��ط���
 * @author Grant��Vranes
 *
 */
public class Point {
	private int x;
	private int y;
	
	//���췽��
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//get,set����:�һ�ѡ��Source...
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
	 *  toString�����ᱻ�ܶ�API���á����Ե����Ƕ���
	 *	 һ����ʱ���ܳ����Ĳ���������д����������÷�����
	 *	�����ǽ���ǰ����ת��Ϊһ���ַ�����ʽ�����ַ�����
	 *	�ݸ�ʽû���ϸ��Ҫ��
	 *	ԭ��Ϊ���������������������Ϣ��
	 */
	public String toString() {
		
		return "("+x+","+y+")";
	}
	
	/**
	 * equals������ʱ�Ƚϵ�ǰ�������������������Ƿ�һ��
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(obj instanceof Point) {//obj����ͬһ����
			Point p = (Point)obj;//��ת��һ��Pointʵ������
			return this.x==p.x&&this.y==p.y;
		}
		return false;
	}
}
