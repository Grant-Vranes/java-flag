package Y2021M3D8;
//�ӿڵ���ʾ
public class InterfaceDemo {
	public static void main(String[] args) {
		
	}
}

//��ʾ�ӿ�ʵ��
interface Inter1{
    void show();
}
interface Inter2{
	void test();
}
abstract class Aoo{
    abstract void say();
}
class Boo extends Aoo implements Inter1,Inter2{
    public void show(){}
    public void test(){}
    void say() {}
}

//��ʾ�ӿ��﷨
interface Inter01{
	public static final int NUM = 5;
    public abstract void show();
    int COUNT = 5;//Ĭ��public static final
    void test();//Ĭ��public abstract
    
    //int number;//������󣬳�����������ͬʱ��ʼ������Ͳ����ڳ����Ķ��壬���Իᱨ��
	//void say(){};//������󣬳��󷽷������з����壬��Ͳ����ڳ��󷽷��Ķ��壬���Ա���
}