package Y2021M2D19;

public class Demo_6 {
	public static void main(String[] args) {
		byte b1 = 5;
		byte b2 = 6;
		byte b3 = (byte)(b1+b2);//因为a1,a2参与运算时转换成了int进行运算，最后int->byte大类型转小类型需要用强制类型转换
		
		System.out.println(2+2);//4
		System.out.println('2' + '2');//100，char类型转换为对应的int值后进行运算，'2'的码为50
		System.out.println('我' + '们');//45309，汉字也同理
	}
}
