package Y2021M2D21;
//������ʾ
public class Demo_1 {
	public static void main(String[] args) {
		say();
		say("Grant");
		System.out.println(getNum());
		System.out.println(getNum(89.2));
	}
	
	//�޲��޷���ֵ
	public static void say() {
		System.out.println("Java_Flag");
	}
	
	//�в��޷���ֵ
	public static void say(String name) {
		System.out.println(name + " is the Learner");
	}
	
	//�޲��з���ֵ
	public static double getNum() {
		return 89757.8;
	}
	
	//�в��з���ֵ
	public static double getNum(double number) {
		return number;
	}
}
