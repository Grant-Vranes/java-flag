package Shoot;

import java.awt.image.BufferedImage;

/*蜜蜂*/
public class Bee extends FlyingObject implements Award{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[4];
		for(int i=0; i<images.length; i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	private int xSpeed;//x坐标移动速度
	private int ySpeed;//y坐标移动速度
	private int awardType;//奖励类型（0或1）
	
	/*构造方法*/
	public Bee(){
		super(60,50);
		xSpeed = 1;//需要控制一下，撞墙就反向移动
		ySpeed = 2;
		awardType = (int)(Math.random()*2); //0或1
	}
	
	/*移动*/
	public void step() {
		x += xSpeed;//向左和向右
		y += ySpeed;
		if(x<0 || x>World.WIDTH-this.width) {//到最左和最右
			xSpeed *= -1;//撞墙则负方向移动
		}
	}
	
	int index = 1;//下标
	/*重写getImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()){
			BufferedImage img = images[index++];
			if(index == images.length) {//当爆炸完就该消失了
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/*重写getAwardType()*/
	public int getAwardType() {
		return awardType;
	}
}
