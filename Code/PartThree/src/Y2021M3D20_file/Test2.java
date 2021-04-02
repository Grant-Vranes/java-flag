package Y2021M3D20_file;
/**
 *	关于递归思想的的小题目
 * 	1、完成1+2+3+4+……+100,并输出结果
 * 		输出每次累加结果
 * 		这段代码中不得出现for，while关键字
 * 	2、一块钱买1瓶汽水，2个空瓶可以换1瓶汽水
 * 		3个瓶盖可以换一瓶汽水。问：20块钱最终可以得到多少瓶汽水
 * @author Grant·Vranes
 *
 */
public class Test2 {
	private static int count = 1;
	public static void main(String[] args) {
		System.out.println("1、前100个数的累加和：" + add(0));
		System.out.println("2、20块可以买：" + cal(20,20,20));
	}
	public static int add(int temp) {//传入的temp一定是累积的和
		int ans = temp;//ans是结果
		if(count>=1 && count<=100) {
			ans += count;
			count++;
			ans = add(ans);
		}
		return ans;
	}
	public static int cal(int sum,int cap,int bottle){
		int add=cap/3+bottle/2;//每次循环所增加的汽水
		sum=sum+add;
		System.out.println(sum);
		cap=cap%3+add;//每次循环后的瓶盖子
		System.out.println(cap);
		bottle=bottle%2+add;//每次循环后的瓶子
		System.out.println(bottle);
		System.out.println("-----------------");
		if(cap<3&&bottle<2){//递归结束的条件
			return sum;
		}else{
			return cal(sum,cap,bottle);//递归调用
		}
	}
}
