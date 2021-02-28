package Shoot;
//蜜蜂
public class Bee extends FlyingObject{
	int xSpeed;//x坐标移动速度
	int ySpeed;//y坐标移动速度
	int awardType;//奖励类型（0或1）
	Bee(){
		super(60,50);
		xSpeed = 1;
		ySpeed = 2;
		awardType = (int)(Math.random()*2); //0或1
	}
	void step() {
		
	}
}
