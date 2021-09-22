<h1 align="center">Spring</h1>

## 软件框架

软件框架是半成品软件, 框架提供软件的大部分技术功能, 使用者只需要关注软件功能, 添加功能代码就可以快速实现软件.

Spring 是目前最广泛的框架.



## Spring框架

Spring 两大核心功能

- `IoC/DI`: 控制反转和依赖注入 https://www.jianshu.com/p/1635658dc446 （如何理解IoC和DI）
- `AOP`: 面向切面(儿)编程



### IoC控制反转

将对象的管理控制权交给容器(Spring)处理的一种编程思路， 使用的时候从容器获取对象使用即可。



### Spring HelloWorld

使用原生的Spring框架去获取对象，后面介绍使用SpringBoot去获取对象

步骤：

- 创建Maven项目

- 声明一个Hello World类

  ![image-20210917103136715](Spring.assets/image-20210917103136715.png)

- 导入Spring核心组件，导入后刷新

  http://doc.canglaoshi.org/config/maven_pom.html

  ![image-20210917100906748](Spring.assets/image-20210917100906748.png)

- 编写一个配置类：告诉Spring启动时候创建HelloWorld对象

  这里是在方法上使用@Bean，后面会介绍@Component，用在类上

  ![image-20210917103251866](Spring.assets/image-20210917103251866.png)

- 创建一个Demo用于启动Spring， ApplicationContext（Spring核心容器）

- 从Spring获取对象，测试对象

  ![image-20210917103351832](Spring.assets/image-20210917103351832.png)

  



## SpringBoot

SpringBoot封装了Spring框架, 提供了自动化的配置\启动功能. 简化了Spring框架的应用.

- 提供了自动化配置, 实现了开箱即用

- 自动提供了Spring组件导入（就是pom.xml中的配置依赖导入）

- 自动提供的单元测试功能

  ![image-20210917191007281](Spring.assets/image-20210917191007281.png)

SpringBoot让Spring更加简单.



### JavaBean

JavaBean: Java类的编写规范.

- 必须有包 package
- 需要有无参数构造器
- 需要实现序列化接口
- 属性访问方法(get set 方法)

Spring 建议, 被Spring管理的对象, 符合JavaBean规范, Spring称呼被管理的对象为Bean.





### Spring组件扫描功能

自动扫描package, 找到标注了特定注解的类, 自动创建类的实例.

- SpringBoot启动时候会自动扫描当前包和子包中的组件注解, 找到后会自动创建组件对象.

  ![image-20210917191558332](Spring.assets/image-20210917191558332.png)

  ![image-20210917191651484](Spring.assets/image-20210917191651484.png)

  ![image-20210917191708783](Spring.assets/image-20210917191708783.png)

- SpringBoot会自动扫描子包

  ![image-20210917192126345](Spring.assets/image-20210917192126345.png)

- 可以自定义扫描范围，例如我要扫描包外的组件

  ![image-20210917192317431](Spring.assets/image-20210917192317431.png)

  ![image-20210917192511792](Spring.assets/image-20210917192511792.png)

  

- Spring提供了多个组件注解，用法都是一样的

  - @Component 表示通用组件
  - @Service 业务层组件, 封装软件业务功能
  - @Controller 界面控制器, 处理界面逻辑
  - @Repository 仓库, 标注数据库访问层
  - ... ...





### Bean ID

Spring 默认情况下会为JavaBean指定唯一Bean ID(也称为Bean Name)

- @Component 注解时候
  - 类名首字母小写：`如类名： DemoBean 则BeanID为demoBean`
  - 类名连续两个大写字母, 则就是类名：`如类名MYDemoBean 则BeanID为MYDemoBean`
  - `@Component("myBean") 自定义Bean ID为myBean`
- @Bean 
  - 默认是 方法名称作为Bean ID
  - `@Bean("myBean") 自定义Bean ID 为myBean`
- Bean ID 不能重复！！！

![image-20210917194043875](Spring.assets/image-20210917194043875.png)



关于Bean ID

- 在匹配JavaBean对象时候， 如果一个类型的Bean是唯一的， 会自动按照匹配
- 当匹配JavaBean对象时候， 如果一个类型的Bean有多个实例， 则需要按照ID 匹配



### ApplicationContext

SpringBoot 会自动创建ApplicationContext，如果需要使用可以注入到测试案例中

```java
  @Autowired
  ApplicationContext applicationContext;
```





### 单例Singleton

单例：在软件运行期间某个对象的实例始终唯一。例如在飞机大战中始终如一的天空背景图

注意：单例和单例模式是两个东西

Spring中默认情况下, JavaBean是单例的!  

多次获取同一个Bean的 引用， 是同一个对象的引用。

![image-20210917194413083](Spring.assets/image-20210917194413083.png)



#### 创建多个实例

`@Scope("prototype")`使用此注释后Spring按照多个实例规则创建JavaBean对象，即每次使用对象时候，都会创建一个对象实例

![image-20210917194716507](Spring.assets/image-20210917194716507.png)

![image-20210917194828205](Spring.assets/image-20210917194828205.png)





### DI 依赖注入

依赖： 一个组件在处理业务时候需要使用另外一个组件，则称为依赖关系。（比如光头强要砍树需要电锯）

在处理业务**之前**，将依赖的组件注入到合适位置， 称为依赖注入。

Spring 支持3种注入方式:

- 字段(属性)注入: Spring 5 不推荐使用了, 但是还是很受欢迎的.

  - ```java
    @Autowired 
    private Saw saw;
    ```

- 方法注入: 需要定义一个方法, 将注解标注在方法上

  - ```java
    @Autowired //利用方法（set方法）注入属性
    public void setSaw(Saw saw) {
        this.saw = saw;
    }
    ```

- 构造器参数注入

  - ```java
    @Autowired //利用构造器注入属性
    public Worker(Saw saw){
        this.saw = saw;
    }
    ```

![image-20210917195544755](Spring.assets/image-20210917195544755.png)

![image-20210917195948739](Spring.assets/image-20210917195948739.png)

![image-20210917200450664](Spring.assets/image-20210917200450664.png)





### @Resource 和 @Autowired（面试题）

- @Resource 是Java 提供的注解, Spring支持其功能
- @Autowired 是Spring的注解
- 它们基本功能类似

区别:

- @Resource 支持 <u>属性注入</u>和<u>方法注入</u>, 但不支持构造器注入, @Autowired三种注解方式都支持
- @Autowired 的Bean匹配规则: 先类型匹配, 再名字匹配
  - 在注入属性时候, 首先在Spring查找类型唯一的一个java bean, 如果匹配成功就注入, 如果找到多个同类型的Java Bean, 则再按照name匹配
  
  - 按照名字匹配: 检查Bean ID 是否与当前注入变量名一致, 如果一致, 则注入成功, 否则出现异常!
  
    ![image-20210919100820164](Spring.assets/image-20210919100820164.png)
  
    现在要注入的变量名我故意写成s，但是我一个Bean ID叫Saw，另一个叫saw1
  
    ![image-20210919102211668](Spring.assets/image-20210919102211668.png)
  
    ![image-20210919100956175](Spring.assets/image-20210919100956175.png)
  
    ![image-20210919101111702](Spring.assets/image-20210919101111702.png)
  
    这时候可以更改这个两个Bean ID的其中一个为s就可以成功运行，但是一般不会这么做，我们可以在`@Autowired`的基础上添加`@Qualifier(BeanID)`注解来标定我们要使用那个Bean ID
  
    ![image-20210919101751245](Spring.assets/image-20210919101751245.png)
  
- @Resource 的Bean匹配规则: 先名字匹配, 再类型匹配
  - 先按照名字唯一的原则匹配唯一的Bean对象, 如果一样则注入, 如果没有找到名字一样的JavaBean, 再按照类型匹配
  
  - 按照类型匹配: 查找类型相同唯一的JavaBean, 如果找到一个bean就注入成功, 找到多个就抛出异常.
  
    ![image-20210919102322133](Spring.assets/image-20210919102322133.png)
  
    上图也能解决上节点的问题
- 他们的功能基本一样!





### 利用BeanID解决注入冲突问题

当有多个同类型的Bean, 并且按照类型匹配冲突时候, 可以利用Bean ID解决注入冲突:

![image-20210917201736924](Spring.assets/image-20210917201736924.png)









## 创建聚合项目

聚合项目是Maven提供的一个功能

能够创建一个父项目,一个父项目中能够创建多个子项目

好处是同一个项目,可以有多个不同的模块

每个子项目充当一个模块,在一个Idea界面中切换维护

并且每个模块专心编写自己的代码,和其他模块不干扰,方便开发或维护



### 创建父项目

![image-20210918125724534](Spring.assets/image-20210918125724534.png)

![image-20210919103151862](Spring.assets/image-20210919103151862.png)



### 创建子项目

![image-20210918125834421](Spring.assets/image-20210918125834421.png)

![image-20210919103215348](Spring.assets/image-20210919103215348.png)



### 父子相认

创建了父项目和子项目后，需要去手动的配置两者的关系

在父项目的pom.xml中

因为现在开发中比较常用的是Spring 2.3.x的版本，所以我们需要把原来的2.5.x的版本修改一下

![image-20210918130015579](Spring.assets/image-20210918130015579.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.12.RELEASE</version> <!-- 修改初始的2.5.x版本为2.3.x版本 -->
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.tedu</groupId>
    <artifactId>jd</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>jd</name>
    <description>Demo project for Spring Boot</description>
    <!-- 这个配置表示当前项目没有java代码就是一个pom文件 -->
    <packaging>pom</packaging>
    <!-- 这个标签配置当前父项目的所有子项目-->
    <modules>
        <module>jd-shop</module>
    </modules>
    
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <!--这里有很多配置删掉了，因为父项目只负责管理所有子项目，这些配置子项目配置就可以了-->
</project>
```

在子项目的pom.xml中

![image-20210918130310920](Spring.assets/image-20210918130310920.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <!-- 从父项目的第11行到第13行复制而来  -->
        <groupId>cn.tedu</groupId>
        <artifactId>jd</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.tedu</groupId>
    <artifactId>jd-shop</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>jd-shop</name>
    <description>Demo project for Spring Boot</description>
    <!-- 父项目有的配置, 子项目不用再写 -->
<!--    <properties>-->
<!--        <java.version>1.8</java.version>-->
<!--    </properties>-->
    <dependencies>
        <!--  下面的依赖是SpringBoot加SpringMvc的依赖  -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--
        下面的依赖是测试依赖,因为是创建项目生成的,匹配2.5.4的springBoot
        和当前项目2.3.12.RELEASE不匹配,要更换
          -->
<!--        <dependency>-->
<!--            <groupId>org.springframework.boot</groupId>-->
<!--            <artifactId>spring-boot-starter-test</artifactId>-->
<!--            <scope>test</scope>-->
<!--        </dependency>-->
        <!-- 2.3.x版本支持的测试依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
        <!--  下面的依赖是用于将我们编写的java程序打包成jar的依赖,
                我们并不需要,删除即可   -->
<!--    <build>-->
<!--        <plugins>-->
<!--            <plugin>-->
<!--                <groupId>org.springframework.boot</groupId>-->
<!--                <artifactId>spring-boot-maven-plugin</artifactId>-->
<!--            </plugin>-->
<!--        </plugins>-->
<!--    </build>-->

</project>
```







## 终极问答项目

### 简介

![image-20210919085432701](Spring.assets/image-20210919085432701.png)

项目分为学生和讲师两种角色

学生主要是提问和其他功能,讲师主要是回答学生的提问和其他功能

![image-20210919085509682](Spring.assets/image-20210919085509682.png)

​	项目结构

![image-20210919085533929](Spring.assets/image-20210919085533929.png)





### 创建问答项目的父项目

此次的项目采用聚合项目来做，所以我们先创建父项目并进行配置

![image-20210919085726927](Spring.assets/image-20210919085726927.png)

创建项目后修改pom.xml文件如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.12.RELEASE</version><!-- 修改初始的2.5.x版本为2.3.x -->
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.tedu</groupId>
    <artifactId>knows</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>knows</name>
    <description>Demo project for Spring Boot</description>
    
    <packaging>pom</packaging><!-- 证明自己是父项目 -->
    <modules>
    	<!-- 等待后期添加module -->
    </modules>
    
    <properties>
        <java.version>1.8</java.version>
    </properties>

</project>
```

父项目创建完成,下面创建子项目knows-portal，这是该项目的门户	

![image-20210919090644888](Spring.assets/image-20210919090644888.png)





### 数据库

数据库表主要分为两大模块

- 用户管理模块
- 问答管理模块

![image-20210919091511462](Spring.assets/image-20210919091511462.png)





###  使用lombok简化数据类

我们先项目中创建一个vo包

vo(Value Object)值对象,一般指包含一些属性的Java类

例如我们创建一个类,这个类代码如下

![image-20210919091918874](Spring.assets/image-20210919091918874.png)

```java
public class Message {

    private Integer id;
    private String name;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(name, message.name) &&
                Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content);
    }
}
```

这样的值对象,在我们的java程序中非常常见,例如我们创建的和数据库表对相应的实体类,也属于这种类型

大家看到,这个代码量非常大,虽然大多数由快捷键生成,但是仍然占用的java代码的篇幅

我们可以使用lombok简化这个过程

![image-20210919092206921](Spring.assets/image-20210919092206921.png)

使用lombok前后代码篇幅的变化如图

![image-20210919092222483](Spring.assets/image-20210919092222483.png)



#### 使用

要想使用lombok需要如下步骤

- 步骤1:添加lombok插件

![image-20210919092327408](Spring.assets/image-20210919092327408.png)

注意：如果不安装插件，Idea无法识别由lombok提供的get\set等方法

> 如果安装过程中无法搜索lombok,可以重启idea重试,或者过一段时间再搜索,如果各种办法不能搜索到,就需要使用离线安装的方式安装这个插件了,离线安装插件资料下面链接:
>
> https://blog.csdn.net/shmily_lsl/article/details/80689307
>
> 

- 步骤2:

  在父项目pom.xml文件中添加依赖

  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
  </dependency>
  ---
  注意：为什么SpringBoot框架中不需要写版本号<version></version>?
  因为SpringBoot框架中已经把大部分常用的依赖的版本信息都配置好了
  ```

- 步骤3:

  在Vo类上添加@Data注解

  代码如下

  ```java
  @Data
  public class Message {
      private Integer id;
      private String name;
      private String content;
  }
  ```



#### lombok常用注解

- @Getter/@Setter:注解添加在类上，表示为这个类中的所有属性添加get\set方法
  								如果添加在单个属性上，表示单独为这个属性添加get\set方法

- @ToString:添加这个注解在类上，会自动重写这个类的toString方法,方法中按照固定格式输出这个对象中的所有属性值

- @EqualsAndHashCode:添加在类上,为这个类重写equals方法和hashCode方法

- @Data:这个注解的功能是@Setter+@Getter+@ToString+@EqualsAndHashCode功能的总和

- @AllArgsConstructor:为当前类生成包含全部属性参数的构造方法(全参构造)，添加后无参构造会消失

- @NoArgsConstructor:为当前类生成一个无参构造方法

- @Accessors(chain = true):为当前类的所有set方法添加当前对象作为返回值,以支持链式set赋值，如下图

  ![image-20210919094113921](Spring.assets/image-20210919094113921.png)

  为什么这个`new Messages()`后面能`.setId()`呢，正常的set方法是void修饰的，不能返回值，但支持链式set赋值后，实体类中set方法就变成如下图的了

  ![image-20210919094041499](Spring.assets/image-20210919094041499.png)

  

- @Slf4j:在类上添加这个注解,会自动在当前类中添加一个可以记录日志的log对象,在方法中可以使用它为当前程序记录日志，后面详解

Lombok使用注意事项

有些公司禁止使用lombok,原因是有人认为这种看不到代码的编写方式,会埋下程序异常\错误的隐患,只有看得到的代码才是可靠的





###  MyBatis Plus

####  什么是MyBatis Plus

​	MyBatis Plus框架是在MyBatis框架基础上扩展的框架,又新增了很多实用的功能,方便程序员编写程序

![image-20210919094727224](Spring.assets/image-20210919094727224.png)

MyBatis Plus框架包含了MyBatis的所有功能

使用时只需要添加MyBatis Plus的pom依赖就可以了



#### 添加MyBatis Plus依赖

我们需要知道SpringBoot框架下,有很多依赖是不需要添加版本就可以成功的引入的，原因是我们继承的2.3.12.RELEASE SpringBoot版本包含了很多常用依赖的版本，但没有为MyBatis Plus提供常用版本，因为SpringBoot提供了一套自己的，就没有为其提供。

如果我们也想在我们自己的父项目中定义版本（因为父项目中的pom.xml文件定义，子项目中所有引用这个依赖的版本号都会一致）,可以编写如下代码

父项目的pom.xml文件修改为

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.12.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.tedu</groupId>
    <artifactId>knows</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>knows</name>
    <description>Demo project for Spring Boot</description>
    <packaging>pom</packaging>
    <modules>
        <module>knows-portal</module>
    </modules>
    <properties>
        <java.version>1.8</java.version>
        <!--定义mybatis.plus的版本--><!--------------------------->
        <mybatis.plus.version>3.3.1</mybatis.plus.version>
    </properties>
    <!------------------------------------------------------------
    dependencyManagement 标签中<dependency>标签的不是要添加依赖到当前项目
    而是定义子项目中使用这个依赖时取用的版本
    ${mybatis.plus.version}的意思就是获取<properties>标签中mybatis.plus.version的值
     -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-extension</artifactId>
                <version>${mybatis.plus.version}</version>
            </dependency>
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis.plus.version}</version>
            </dependency>
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-generator</artifactId>
                <version>${mybatis.plus.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>
```

子项目中为其添加依赖即可

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
</dependency>
```





### 配置MyBatisPlus

上面我们配置了父项目的MyBatisPlus版本,在子项目中添加引用

但是只是一个MyBatisPlus依赖还不能连接数据库

我们需要Mysql的依赖

所以在子项目的pom.xml继续添加依赖如下

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

SpringBoot启动类添加一个扫描mapper包中接口的注解

代码如下

![image-20210922124047525](Spring.assets/image-20210922124047525.png)

注意：application.properties中需要添加连接数据库的配置

```properties
#数据库驱动
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/knows?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true
spring.datasource.username=root
spring.datasource.password=root
```





### 开始进行MyBatisPlus测试

我们先创建一个和数据库连接的实体类对象Tag

![image-20210922124310927](Spring.assets/image-20210922124310927.png)

MyBatisPlus框架增强的功能之一就是在Mapper接口中,继承一个父接口,会自动生成基本的增删改查方法

![image-20210922124432064](Spring.assets/image-20210922124432064.png)

下面对TagMapper进行常用功能测试：注意其中的修改update操作需要遵循三步

![image-20210922124601628](Spring.assets/image-20210922124601628.png)





### 将MyBatisPlus执行的Sql语句显示

之前我们一直是自己编写sql语句执行，现在MyBatisPlus提供了基本的CURD(增删改查)操作

但是我们看不到它执行的Sql语句,这样有些不利于我们的学习

我们想看到它执行的Sql语句。首先我们需要了解一下SpringBoot框架下的日志系统



#### 什么是日志

日志就类似于程序的日记,记录了程序运行过程中发生了什么，是高级的System.out.println

因为它可以分级记录信息,还可以将信息保存在硬盘的文件上，记录日志的好处主要是当程序发生异常时，技术人员可以根据日志内容追踪到出现错误的原因，方便排除错误

**SpringBoot日志分五级**

从最不重要的级别开始

1. `trace` 级别低(不重要)
2. `debug`
3. `info` SpringBoot默认info及以上级别才显示在控制台
4. `warn`
5. `error` 级别高(重要\严重)

我们可以通过application文件的配置,修改SpringBoot默认输出到控制台的日志信息级别

#### 修改项目的application文件

修改 application.properties文件,添加配置如下

```properties
# 下面的配置设置了debug级别及以上级别的信息会输出到SpringBoot控制台
# 配置含义为cn.tedu.knows.portal包下的所有类的输出日志级别设置为debug,即debug级别以上的都显示
# MyBatisPlus将运行的sql语句设置在了debug,所以控制台会出现sql语句了
logging.level.cn.tedu.knows.portal=debug
```

我们就可以在MyBatis运行时在控制台看到Sql语句了

![image-20210922125210489](Spring.assets/image-20210922125210489.png)







### MyBatisPlus代码生成器

#### 什么是代码生成器

代码生成器就是一个能够按指定要求生成代码的代码片段

MyBatisPlus框架支持我们按照现有的数据库表生成一个表对应的5个类

- Controller
- Mapper
- 实体类
- Service
- ServiceImpl

这样一个中型项目40张表正常200个类,只需要使用代码生成器就可以快速完成,无需我们自己创建,大大提升效率



#### 创建knows-generator项目

因为代码生成器是一次性的运行,所以建议大家单独创建一个项目来实现

![image-20210922160325488](Spring.assets/image-20210922160325488.png)



#### 父子相认

父项目pom.xml

```xml
<modules>
    <module>knows-portal</module>
    <!--  下面新加的 -->
    <module>knows-generator</module>
</modules>
```

子项目knows-generator的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.akio</groupId>
        <artifactId>knows</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>cn.akio</groupId>
    <artifactId>knows-generator</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>knows-generator</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <!--MybatisPlus 核心依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>
        <!--freemarker 核心依赖，用于按指定格式生成代码-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        <!--支持SpringBoot启动的依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <!--MybatisPlus 代码生成器核心依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
        </dependency>
        <!--MybatisPlus 辅助工具包-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-extension</artifactId>
        </dependency>
        <!--MySql驱动类-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--lombok代码生成到实体类中-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--2.3.x版本支持的测试依赖--><!--因为这个项目主要用于一次性生成代码，所以对于test测试文件夹可以删掉，所以这个依赖就不是必须-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```



#### 代码生成器的配置

因为当前generator项目有删除了测试的依赖，所以必须删除test文件夹，否则运行时报错：说缺少依赖

![image-20210922161102094](Spring.assets/image-20210922161102094.png)

然后项目下创建CodeGenerator，下买呢这套代码都是固定的，只需要修改数据信息

注意，下面代码30~50行的成员变量中有一些配置要根据自己的项目进行更改

![image-20210922161351764](Spring.assets/image-20210922161351764.png)

```java
package cn.akio.knows.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @Description: 代码生成类
 * @author Akio
 * @create 2021/9/22 14:41
 */

public class CodeGenerator {
    //数据库连接参数
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/knows?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";//<
    public static String username="root";
    public static String password="root";
    //父级别包名称
    public static String parentPackage = "cn.akio.knows";//<
    //代码生成的目标路径
    public static String generateTo = "/knows-generator/src/main/java";//<
    //mapper.xml的生成路径
    public static String mapperXmlPath = "/knows-generator/src/main/resources/mapper";//<
    //控制器的公共基类，用于抽象控制器的公共方法，null值表示没有父类
    public static String baseControllerClassName ;// = "cn.akio.knows.portal.base.BaseController";
    //业务层的公共基类，用于抽象公共方法
    public static String baseServiceClassName ;   // = "cn.akio.knows.portal.base.BaseServiceImpl";
    //作者名
    public static String author = "akio";//<
    //模块名称，用于组成包名
    public static String modelName = "portal";//<
    //Mapper接口的模板文件，不用写后缀 .ftl
    public static String mapperTempalte = "/ftl/mapper.java";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + generateTo);
        gc.setAuthor(author);
        gc.setOpen(false);
        //设置时间类型为Date
        gc.setDateType(DateType.TIME_PACK);
        //开启swagger
        //gc.setSwagger2(true);
        //设置mapper.xml的resultMap
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setEntity("model");
        //pc.setModuleName(scanner("模块名"));
        pc.setModuleName(modelName);
        pc.setParent(parentPackage);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + mapperXmlPath
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        mpg.setTemplate(new TemplateConfig().setMapper(mapperTempalte));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置实体类的lombok
        strategy.setEntityLombokModel(true);
        //设置controller的父类
        if (baseControllerClassName!=null) strategy.setSuperControllerClass(baseControllerClassName);
        //设置服务类的父类
        if (baseServiceClassName !=null ) strategy.setSuperServiceImplClass(baseServiceClassName);
        // strategy.
        //设置实体类属性对应表字段的注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        //设置表名
        String tableName = scanner("表名, all全部表");
        if(! "all".equalsIgnoreCase(tableName)){
            strategy.setInclude(tableName);
        }
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
```

最后还要指定代码生成器的格式

![image-20210922161759805](Spring.assets/image-20210922161759805.png)

在资源文件夹resources下创建ftl文件夹，其中创建`mapper.java.ftl`文件

```java
import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
```

运行现在CodeGenerator类中的main方法，运行后在控制台输如all表示生成所有表对应的代码

![image-20210922161941756](Spring.assets/image-20210922161941756.png)

**将生成好的controller\mapper\model\service四个包复制到portal项目，之后将generator项目的portal包删除,防止报错**

![image-20210922162054487](Spring.assets/image-20210922162054487.png)



#### 测试生成的代码

测试1：在测试类中

![image-20210922162517767](Spring.assets/image-20210922162517767.png)

![image-20210922162546503](Spring.assets/image-20210922162546503.png)

测试2：在UserController中

![image-20210922162337765](Spring.assets/image-20210922162337765.png)

运行项目

![image-20210922162350594](Spring.assets/image-20210922162350594.png)





### Spring安全框架

#### 什么是Spring安全框架

Spring-Security是Spring提供的安全管理框架

主要功能是企业级的用户管理和权限控制,实现安全的登录和健全的用户角色\权限的判断

菜鸟程序员也能写出企业级安全的登录流程

相对于我们自己写登录,Spring-Security更加注重登录的封装,我们只能编写Spring-Security需要你我们提供的部分配置



#### 开始使用Spring-Security

只需要添加portal项目pom.xml依赖就可以开始使用Spring-Security

```xml
<!-- Spring Security 依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```

只要当前添加了Spring-Security的依赖,当前项目所有资源(页面\文件\图片等)都会被保护起来,既必须登录才能访问网站中的内容

![image-20210922170234608](Spring.assets/image-20210922170234608.png)

我们需要访问任何资源时,都会看见如上图的要求登陆页面

我们要登录默认用户名:**user**

默认密码在启动portal项目的控制台中,这个值是随机的

![image-20210922170415203](Spring.assets/image-20210922170415203.png)

按照上述用户名密码输入,即可登录

如果想自定义用户名和密码

application.properties文件中编写代码如下

```properties
#设置Spring-Security自定义登录用户
spring.security.user.name=Grant
spring.security.user.password=123
```

再重启服务,就不会生成随机的密码了

因为我们需要使用这套信息登录





#### 密码加密

上面的配置中,我们使用了相对不安全的明文密码来设置密码字符

任何可以看到配置文件的人都可以看到明文密码进行登录

我们必须对它进行加密，我们推荐使用bcrypt加密算法，将我们的登录密码进行加密

配置文件中保存加密后的字符串，这样即使被看到了加密的密码，也不知道正确密码是什么

![image-20210922185326708](Spring.assets/image-20210922185326708.png)

在测试类中测试加密算法

```java
@SpringBootTest
public class PasswordTest {
    //加密测试
    //声明并创建一个加密对象
    PasswordEncoder encode = new BCryptPasswordEncoder();

    @Test
    public void encodeWork(){
        String pwd = encode.encode("123");//将123进行加密
        System.out.println(pwd);
        //每次生成的密码都是不同的， 为了安全考虑
        //我们将加密结果每次不同称之为:"随机加盐技术"
        //$2a$10$6/Uu88kKb4glqcXBxzYOJ.CxfnWfNHIYVhVFCm/7xIIyDP2Ip5nvq
    }

    //验证密码是否匹配
    @Test
    public void match(){
        //bcrypt提供了一个matches方法，验证一个字符串是否匹配一个加密结果，返回boolean
        //是否匹配=matches([明文字符串],[加密结果])
        boolean matches = encode.matches("123", "$2a$10$6/Uu88kKb4glqcXBxzYOJ.CxfnWfNHIYVhVFCm/7xIIyDP2Ip5nvq");
        System.out.println(matches);
    }
}
```

然后将这个加密后的字符串配置到application.properties中,这样就可以使用用户名和密码访问网站的资源页面了

```properties
#设置Spring-Security自定义登录用户
spring.security.user.name=Grant
#告知Spring，这是使用bcrypt加密的结果，要加上{bcrypt}标示说明这是加密代码
spring.security.user.password={bcrypt}$2a$10$6/Uu88kKb4glqcXBxzYOJ.CxfnWfNHIYVhVFCm/7xIIyDP2Ip5nvq
```

做到这个地步，不是我们的最终目的，我们需要的是将数据库中中存放的用户密码进行加密，如下

![image-20210922190059776](Spring.assets/image-20210922190059776.png)







#### 权限管理

上面的配置实际上主要为了让大家理解加密的原理和流程

实际开发中我们登录的用户都是来自数据库的,至少应该把用户配置在java代码中,才有可能连接数据库,

我们需要编写的配置如下

创建一个security包

![image-20210922190435301](Spring.assets/image-20210922190435301.png)

包中创建SecurityConfig类代码如下

```java
/**
 * 通过java设置用户名密码
 * @author Akio
 * @create 2021/9/22 17:51
 */
//表示当前类是SpringBoot的配置类
@Configuration
//启动Spring-Security提供的权限管理功能
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Akio")
                .password("{bcrypt}$2a$10$6/Uu88kKb4glqcXBxzYOJ.CxfnWfNHIYVhVFCm/7xIIyDP2Ip5nvq")
                .authorities("/user");
    }
}
```

然后就可以通过用户名Akio和密码123进行登陆访问资源页面，但原来application.properites中设置的用户名和密码就会失效

![image-20210922190834385](Spring.assets/image-20210922190834385.png)
