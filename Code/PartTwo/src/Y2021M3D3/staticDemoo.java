package Y2021M3D3;
//��ʾ��̬����
public class staticDemoo {

}

class Moo{
	int a;
	static int b;
	void show() {//��this
		System.out.println(this.a);
		System.out.println(Moo.b);
	}
	static void test() {//û��this
		/*
		��̬����û��this����
		û��this��ζ��û�ж���
		��ʵ������a����ͨ������+.������
		���ۣ���̬�����в���ֱ�ӷ���ʵ����Ա
		*/
		//System.out.println(a);//error
		System.out.println(b);
	}
}