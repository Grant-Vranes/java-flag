package Shoot;
//С�л�
public class AirPlane extends FlyingObject{
	int speed;//�ƶ��ٶ�
	AirPlane(){
		/*
		width = 49;
		height = 36;
		x = (int)(Math.random()*(400-this.width));//x��0�������ڿ�-С�л�����֮�������� 
		/*Ҳ������ôд
		 * Random rand = new Random();
		 * x = rand.nextInt(400-this.width);
		 *
		y = -this.height;//y:����С�л��ĸ߶�
		*/
		super(49,36);
		speed = 2;//С�л��ٶ�
	}
	//�ƶ�
	void step() {
		
	}
}