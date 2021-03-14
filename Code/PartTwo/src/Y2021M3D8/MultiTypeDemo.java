package Y2021M3D8;
//多态的演示
public class MultiTypeDemo {
	public static void main(String[] args) {
		Aooo o = new Booo();//向上造型
		Booo o1 = (Booo)o;//o指向的对象就是Boo类型(可强转)
		Inter o2 = (Inter)o;//o指向的对象实现了Inter接口(可强转)
		//Cooo o3 = (Cooo)o;//指向对象既不是该类型也没有实现该接口，ClassCastException类型转换
		System.out.println(o instanceof Cooo);
	}
}

interface Inter{
	
}
class Aooo{
	
}
class Booo extends  Aooo implements Inter{
	
}
class Cooo extends Aooo{
}