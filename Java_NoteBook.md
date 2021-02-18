<p align = center><font size = 9>Java</font></p>

<p align = center>writen by Grant·Vranes</p>

---

课程来源https://www.bilibili.com/video/BV1RV41147yJ?from=search&seid=4932318903875319779

---

Code为代码文件夹，也为Eclipse工作目录

其下项目PartOne代表模块一-----------语言基础（7天）学习中的所有代码



---

[toc]

---



# 语言基础（7天）+ 面向对象（10天）+ API（20天）



## 1.1 课程前序(2021.2.18)

语言基础------多练

面向对象------多想

---

java：是一门计算机语言------------做程序/软件的（*淘宝/京东/饿了么/摩拜/银行系统/ATM机系统都是用Java开发*）



## 1.2 Java编译运行过程

![image-20210218210532309](Java_NoteBook.assets/image-20210218210532309.png)

### 1.2.1 Java编译运行过程

![image-20210218210649467](Java_NoteBook.assets/image-20210218210649467.png)

- C语言编译过程

  ![image-20210218211606112](Java_NoteBook.assets/image-20210218211606112.png)

- Java语言编译过程

  ```java
  步骤：-------（面试题）
  1）.java源文件，经过编译，生成.class字节码文件
  2)JVM(虚拟机)加载.class并运行.class（0和1）
      
  假如QQ是用Java语言写的：
      java版的qq，经过编译，生成.class字节码文件
      Windows版的JVM---------运行在Windows上
      Linux版的JVM---------运行在Linux上
      IOS版的JVM---------运行在IOS上
      ？？？版的JVM---------运行在？？？上
      需要什么平台的qq只需要安装对应平台的JVM就行，不需要像C语言编写的QQ一样（要为每个平台都写一套qq系统）
      这个特性：跨平台，一次编程到处运行
  ```

  ![image-20210218212601020](Java_NoteBook.assets/image-20210218212601020.png)

  ![image-20210218212623882](Java_NoteBook.assets/image-20210218212623882.png)



- 涉及名词解释：-------常见面试题

  1) JVM : <u>java虚拟机</u>

  ​				加载.class并运行.class

  2) JRE : <u>java运行环境</u>--------运行Java程序的最小环境

  ​				除了包含JVM以外还包含运行java程序所必需的环境

  ​				JRE = JVM + java系统类库（小零件/小功能）

  3) JDK : <u>java开发工具包</u>----------开发Java程序的最小环境

  ​				除了包含JRE意外还包含开发java程序所必需的的命令工具

  ​				JDK = JRE+编译、运行等命令工具

  ---

  ![image-20210218213202796](Java_NoteBook.assets/image-20210218213202796.png)

  ![image-20210218213224737](Java_NoteBook.assets/image-20210218213224737.png)

  

- 配置环境变量---------了解（现在借助eclipse等工具可以不用配置）

  ![image-20210218213756757](Java_NoteBook.assets/image-20210218213756757.png)

  ![image-20210218213811568](Java_NoteBook.assets/image-20210218213811568.png)

  ```java
  配置三个东西：
      1)JAVA_HOME：指向jdk的安装目录,输入安装路径
      2)CLASSPATH：表示类的搜索路径，一般简写为(.)表示当前路径，写.
      3)PATH：指向jdk下的bin目录，一般写%JAVA_HOME%\bin
  -------------------
  配置方法：
  	1、右键点击【计算机】，选择【属性】，点击【高级系统设置】，打开环境变量设置；
      2、新建【JAVA_HOME】变量，并编辑【Path】变量；
      3、新建【Classpath】变量并编辑即可。
  -------------------
  检验方法：CMD中输入java和javac，有反应就说明成功。
  ```



- Eclipse简介

  ![image-20210218214339864](Java_NoteBook.assets/image-20210218214339864.png)

  ![image-20210218214412532](Java_NoteBook.assets/image-20210218214412532.png)

  

- 开发步骤

  1）新建java项目/工程--------------小区

  2） 新建java包------------------------楼+单元

  3）新建java类-------------------------房子



- 注释：解释性文本

  1）单行注释：//

  2）多行注释：/* */

  3）文档注释：/** */



- 命令行编译运行java程序

  - cd到对应目录，使用javac编译.java文件成字节码文件

    ![image-20210218223219293](Java_NoteBook.assets/image-20210218223219293.png)

  - 然后使用`java HelloWorld_1`

    ![image-20210218223408737](Java_NoteBook.assets/image-20210218223408737.png)

    ---

    :warning:注意：可能会遇到无法加载主类的问题，可以参考https://www.cnblogs.com/wangxiaoha/p/6293340.html

    ![image-20210218223627397](Java_NoteBook.assets/image-20210218223627397.png)

    <img src="Java_NoteBook.assets/image-20210218223724931.png" alt="image-20210218223724931" style="zoom:200%;" />

    

