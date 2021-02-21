package Y2021M2D21;
//猜字符游戏
import java.util.Scanner;
public class Demo_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();//获取待猜的随机数组
		while(true) {
			System.out.println("please guess");
			String str = scan.next().toUpperCase();//小写转大写
			if(str.equals("EXIT")) {//退出
				System.out.println("exit");
				break;
			}
			char[] input = str.toCharArray();
			int[] result = check(chs,input);
			int wrongCount = 0;//猜错次数
			if(result[0] == chs.length) {//对
				int score = 100*chs.length-10*wrongCount;//
				System.out.println("恭喜,得分:"+score);
			}else {
				wrongCount++;
				System.out.println("字符对个数:"+result[1]+" 位置对个数:"+result[0]);
			}
		}
	}
	
	//生成随机数组
	public static char[] generate() {
		char[] chs = new char[5];//随机字符数组
		char[] letters = new char[] {'A','B','C','D','E','F'
				,'G','H','I','J','K','L','M','N','O','P','Q'
				,'R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];//开关数组
		for(int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int)(Math.random()*letters.length);//随即下标（0，25）
			}while(flags[index]);//当为true说明这个字符已经生成过，重新生成
			chs[i] = letters[index];//将随机出来的一个字符存入chs
			flags[index] = true;//将选出的数组标记为true，下次不能再选
		}
		return chs;
	}
	
	//对比：随机数组chs与用户输入的字符数组input
	public static int[] check(char[] chs,char[] input){
        int[] result = new int[2];//result[0]为位置对计数，result[1]为字符对计数
        for(int i = 0; i < chs.length; i++) {
        	for(int j = 0; j < input.length; j++) {
        		if(chs[i] == input[j]) {//字符对
        			result[1]++;
        			if(i == j) {//位置对
        				result[0]++;
        			}
        			break;//找到了对应的，剩下input不在参与
        		}
        	}
        }
        return result;
     }
}
