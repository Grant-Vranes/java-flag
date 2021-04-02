package Y2021M3D20_file;

import java.io.File;

/**
 * 创建一个多级目录
 * @author Grant·Vranes
 *
 */
public class MKDirsDemo {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建 a/b/c/d/e/f目录
		 */
		File dir = new File("./a/b/c/d/e/f");
		if(!dir.exists()) {//检测是否存在该文件
			dir.mkdir();//前提条件：要求创建的目录所在的父目录必须存在,a这个目录就不存在，后面的就更别谈了
			dir.mkdirs();//在创建目录时，会将所有不存在的父目录全部创建
			System.out.println("目录创建完毕");
		}else {
			System.out.println("目录已存在");
		}
	}
}
