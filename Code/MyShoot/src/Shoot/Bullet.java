package Shoot;

import java.awt.image.BufferedImage;

//子弹
public class Bullet extends FlyingObject{
	private static BufferedImage image;
	static {
		image = loadImage("bullet.png");
	}
	private int speed;//移动速度
	
	/*构造方法*/
	public Bullet(int x, int y){
		/*
		width = 8;
		height = 14;
		this.x = x;//子弹的x,y不能写死，他要随着英雄机的位置变
		this.y = y;
		*/
		super(8,14,x,y);
		speed = 3;
		System.out.println("子弹出现了");
	}
	
	/*移动*/
	public void step() {
		y -= speed;//(向上)
	}
	
	/*重写getImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else if(isDead()) {
			state = REMOVE;
		}
		return null;//死了的和删除的，则返回null
		/*
		 * 活着的，返回image
		 * 死了的，状态改为删除并返回null
		 * 删除的，返回null
		 */
	}
	
	/*检查是否越界*/
	public boolean outOfBounds() {
		return this.y<=-this.height;//子弹的y坐标小于等于负子弹的高就越界了
	}
}
