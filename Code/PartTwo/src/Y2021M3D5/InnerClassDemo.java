package Y2021M3D5;
//�ڲ�����ʾ
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby();//��������ڲ�����ⲻ�ɼ�
		m.createBaby("���о�");
	}
}
class Mama{
	private String name;
	void createBaby(String name) {
		Baby b = new Baby();//�ڲ������ͨ����Ҫ���ⲿ���д���
		b.showMamaName(name);
	}
	class Baby{
		void showMamaName(String name) {
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name);//�������
		}
	}
}