package Y2021M4D4_Collection;
/**
 * 	����
 * 	������JDK5�Ƴ������ԣ�Ҳ��Ϊ����������
 * 	������һ���������Ե����͡���������������
 * 	�Լ���������ֵ���͵ȵĶ���Ȩ�ƽ���ʹ���ߡ�
 * 	��ʹ��ʵ��Ӧ����ʹ��������������ݡ�
 * @author Grant��Vranes
 *
 */
public class Location<E> {
	//Ҳ���Զ��������Location<E,R>,E,R��������Щ��ĸû�й̶�Ҫ��
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
