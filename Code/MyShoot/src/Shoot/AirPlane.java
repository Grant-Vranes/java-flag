package Shoot;
//小敌机
public class AirPlane extends FlyingObject{
	int speed;//移动速度
	AirPlane(){
		/*
		width = 49;
		height = 36;
		x = (int)(Math.random()*(400-this.width));//x：0到（窗口宽-小敌机宽）之间的随机数 
		/*也可以这么写
		 * Random rand = new Random();
		 * x = rand.nextInt(400-this.width);
		 *
		y = -this.height;//y:负的小敌机的高度
		*/
		super(49,36);
		speed = 2;//小敌机速度
	}
	//移动
	void step() {
		
	}
}
