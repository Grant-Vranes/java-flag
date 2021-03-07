package Y2021M3D5;
//内部类演示
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby();//编译错误，内部类对外不可见
		m.createBaby("云中君");
	}
}
class Mama{
	private String name;
	void createBaby(String name) {
		Baby b = new Baby();//内部类对象通常需要在外部类中创建
		b.showMamaName(name);
	}
	class Baby{
		void showMamaName(String name) {
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name);//编译错误
		}
	}
}
