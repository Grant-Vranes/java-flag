package Shoot;
/**奖励接口*/
public interface Award {
	public int DOUBLE_FIRE = 0;//火力值
	public int LIFE = 1;//生命值
	
	/*获取奖励类型（0或1，随机获取双倍火力或一条生命）*/
	public int getAwardType();
}
