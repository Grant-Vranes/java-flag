package Y2021M2D22;
//������ʾ
/*
 * 1)ͬһ���ļ��У����԰��������
 * 2)public���ε���ֻ����һ��
 * 3)public���ε���������ļ�����ͬ
 */
public class OverloadBemo {
	public static void main(String[] args) {
		Aoo a = new Aoo();//����һ�����У��ǿ��Ե��õ�
        a.say();
        a.say("nice");
	}
}

class Aoo{
	void say() {}
	void say(String name) {}
	void say(int age) {}
	//int say(){return 1;}//������������뷵��ֵû�й�ϵ
	//void say(String address){}//���������������������޹�
}