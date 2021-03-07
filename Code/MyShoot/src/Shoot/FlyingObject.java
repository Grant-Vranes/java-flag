package Shoot;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javax.imageio.ImageIO;
/*飞行物*/
public abstract class FlyingObject {
	public static final int LIFE = 0;//活着的状态
	public static final int DEAD = 1;//死亡的状态
	public static final int REMOVE = 2;//消失/删除的状态
	protected int state = LIFE;//当前状态
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	//关于speed不是所有成员共有的，英雄机没有。
	
	/*专门给小敌机、大敌机、小蜜蜂提供的*/
	public FlyingObject(int width, int height){
		this.width = width;
		this.height = height;
		x = (int)(Math.random()*(World.WIDTH-this.width));//x：0到（窗口宽-小敌机宽）之间的随机数 
		/*也可以这么写
		 * Random rand = new Random();
		 * x = rand.nextInt(420-this.width);
		 */
		y = -this.height;//y:负的小敌机、大敌机、小蜜蜂的高度
	}
	
	/*专门给英雄机、天空、子弹提供*/
	public FlyingObject(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	/*读取图片*/
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
			/*
			 * 请注意：fileName一定要是可以检索出来的，如果检索不出来就会出来java.lang.IllegalArgumentException: input == null!
			 *at javax.imageio.ImageIO.read(Unknown Source)的报错，而这个报错也仅仅是因为我把AirPlane类中的images数组写大了一个，然后对应的图片又找不到airplane2.png
			*/
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/*飞行物移动，但每个飞行物的移动方式不同，所以在各自的类中重写step()方法*/
	public abstract void step();//抽象方法
	
	/*获取对象的图片*/
	public abstract BufferedImage getImage();
	
	/*判断是否活着的*/
	public boolean isLife() {
		return state==LIFE;
	}
	
	/*判断是否死了的*/
	public boolean isDead() {
		return state==DEAD;
	}
	
	/*判断是否删除的*/
	public boolean isRemove() {
		return state==REMOVE;
	}
	
	/*画对象 g:画笔*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
	}
	
	/*检测是否越界:因为小大敌机和小蜜蜂出界方式一样就一起写到超类中；子弹越界就另外写*/
	public boolean outOfBounds() {
		return this.y>=World.HEIGHT;
	}
}
