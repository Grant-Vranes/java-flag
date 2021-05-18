重构代码

使用Tomcat安装目录中的conf/web.xml文件，将里面
配置的所有介质类型解析出来并初始化HttpContext中的
mime_mapping这个Map，使我们的WebServer也能支持
所有的介质类型。

1：在项目目录下创建一个目录conf，然后将Tomcat中的
	web.xml文件复制过来
2：修改HttpContext中的initMimeMapping方法，通过
	解析web.xml文件来初始化mime_mapping