package Y2021M3D1;
//final演示
public class finalDemo {

}

class EEoo{
	final int a = 5;
	final int b;
	EEoo(){
		b = 6;
	}
	void show(){
	}
}
class FFoo extends EEoo{
	void deo() {
		//a = 6;//error，final不可被修改
	}
}