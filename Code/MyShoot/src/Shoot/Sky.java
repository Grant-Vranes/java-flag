package Shoot;
//���:�̳��ڷ�����
public class Sky extends FlyingObject{
	int speed;//�ƶ��ٶ�
	int y1;//�ڶ������ͼƬ��y����
	//���췽��
	Sky(){//���Զ�д���ˣ�����Ҫ����
		/*
		width = 400;//��յĿ��߹̶�������д��
		height = 700;
		x = 0;
		y = 0;
		*/
		super(400,700,0,0);
		speed = 1;
		y1 = -700;
	}
	//�ƶ�
	void step() {
		
	}
}