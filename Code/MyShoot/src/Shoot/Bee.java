package Shoot;
//�۷�
public class Bee extends FlyingObject{
	int xSpeed;//x�����ƶ��ٶ�
	int ySpeed;//y�����ƶ��ٶ�
	int awardType;//�������ͣ�0��1��
	Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		awardType = (int)(Math.random()*2); //0��1
	}
	void step() {
		
	}
}
