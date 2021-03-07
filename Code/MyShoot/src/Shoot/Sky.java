package Shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;//引入装图片的数据类型 
/*天空类:继承于飞行物*/
public class Sky extends FlyingObject{
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	private int speed;//移动速度
	private int y1;//第二张天空图片的y坐标
	
	/*构造方法*/
	public Sky(){//属性都写死了，不需要参数
		/*
		width = 400;//天空的宽高固定，可以写死
		height = 700;
		x = 0;
		y = 0;
		*/
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/*移动*/
	public void step() {
		y += speed;
		y1 += speed;
		if(y>=World.HEIGHT) {//若y>=窗口的高，表示已经移出去
			y = -World.HEIGHT;//则将y修改为负的窗口的的高
		}
		if(y1>=World.HEIGHT) {
			y1 = -World.HEIGHT;
		}
		
	}
	
	/*重写getImage()*/
	public BufferedImage getImage() {
		return image;
	}
	
	/*画对象 g:画笔;天空需要两张图轮换才能出现天空移动的效果*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
}
