package Y2021M2D28;

public class Doctor extends Person{
	int level;
	public Doctor(String name,int age,String address,int level) {
		super(name,age,address);
		this.level = level;
	}
}
