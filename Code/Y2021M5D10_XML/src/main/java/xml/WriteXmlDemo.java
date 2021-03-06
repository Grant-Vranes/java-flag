package xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 	使用DOM4J生成一个xml文档
 * @author Grant·Vranes
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"张三",20,"男",5000));
		list.add(new Emp(2,"李四",22,"男",9000));
		list.add(new Emp(3,"王五",21,"男",6000));
		list.add(new Emp(4,"赵六",22,"男",8000));
		list.add(new Emp(5,"钱七",22,"男",7000));
		
		/*
		 * 	生成XML的大致步骤：
		 * 	1：创建一个Document对象，表示一个空白文档
		 * 	2：向Document中添加根元素
		 * 	3：按照XML文档结构从根标签开始逐级添加子标签及对应数据
		 * 	4：创建XmlWriter
		 * 	5：使用XmlWriter写出Document以生成文档
		 */
		try {
			//1
			Document doc = DocumentHelper.createDocument();
			/*
			 * 2
			 * 	Document提供了添加根元素的方法:
			 * 	Element addElement(String name)
			 * 	添加后会将根标签以一个Element实例形式返回，以便于
			 * 	我们对其继续操作。注意：这个方法只能被调用一次。
			 */
			Element root = doc.addElement("list");
			
			/*
			 * 3
			 * 	Element也提供了添加相关信息的方法：
			 * 	Element addElement(String name)
			 * 	像当前标签中添加给定名字的子标签，它同样也会
			 * 	将子标签标签以一个Element实例形式返回
			 * 
			 * 	Element addText(String text)
			 * 	向当前标签中间添加指定文本。返回值还是标签（这样
			 * 	返回的好处是可以连续操作当前标签）
			 * 
			 * 	Element addAttribute(arg0, arg1)
			 * 	向当前标签中添加属性，arg0属性，arg1属性值
			 */
			for (Emp emp : list) {
				//向根标签中添加员工<emp>子标签
				Element empEle = root.addElement("emp");
				//给<emp>标签添加属性id
				empEle.addAttribute("id", emp.getId()+"");
				
				//添加姓名
				//往子标签中添加姓名<name>子标签（套娃）
				Element nameEle = empEle.addElement("name");
				//向标签中添加文本<name>Text</name>
				nameEle.addText(emp.getName());
				
				//添加年龄
				empEle.addElement("age").addText(emp.getAge()+"");
				
				//添加性别
				empEle.addElement("gender").addText(emp.getGender());
				
				//添加薪资
				empEle.addElement("salary").addText(emp.getSalary()+"");
			}
			/*
			 * 	XMLWriter符合java高级流用法。她负责将Document对象以XML文档格式进行写出，
			 * 	并通过其连接的文件流写入到文件中。
			 */
			XMLWriter writer = new XMLWriter(
				new FileOutputStream("myEmp.xml")
				,OutputFormat.createPrettyPrint()
			);
			writer.write(doc);
			System.out.println("写出完毕");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
