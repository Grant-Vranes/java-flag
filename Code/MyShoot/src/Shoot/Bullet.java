package Shoot;
//�ӵ�
public class Bullet extends FlyingObject{
	int speed;//�ƶ��ٶ�
	Bullet(int x, int y){
		/*
		width = 8;
		height = 14;
		this.x = x;//�ӵ���x,y����д������Ҫ����Ӣ�ۻ���λ�ñ�
		this.y = y;
		*/
		super(8,14,x,y);
		speed = 3;		
	}
	//�ƶ�
	void step() {
		
	}
}