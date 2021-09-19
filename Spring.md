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

我们需要知道SpringBoot框架下,有很多依赖是不需要添加版本就可以成功的引入的，原因是我们继承的2.3.12.RELEASE SpringBoot版本包含了很多常用依赖的版本

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
        <!--定义mybatis.plus的版本-->
        <mybatis.plus.version>3.3.1</mybatis.plus.version>
    </properties>
    <!--
    dependencyManagement 标签中<dependency>标签的不是要添加依赖到当前项目
    而是定义子项目中使用这个依赖是取用的版本
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

