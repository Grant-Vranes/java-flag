package Y2021M3D1;
//��д����ʾ
public class overrideDemo {
	public static void main(String[] args) {
		
	}
}
//�����������С
class Coo{
	void show() {}
	double test() {return 0.0;}
	Doo say() {return null;}
	Coo sayHi() {return null;}
}
class Doo extends Coo{
	//int show() {return 1;}//�������voidʱ�������
	//int test() {return 0;}//������󣬻������ͣ��������
	//Coo say() {return null};//���������������ʱ��С�ڻ����
	Doo sayHi() {return null;}
}