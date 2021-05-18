根据请求将客户端需要的资源响应回去

1、在项目中新建一个存放各个“网站资源”的总目录webapps
	Toncat中也是这样做的，每个网站被称为一个webapps，
	它包含该网站的资源（页面，图片等...）还包含处理业务的
	java程序。而每个webapp都以一个子目录的形式保存在
	webapps中呗Tomcat统一管理。
2、在webapps下建立一个子目录：myweb，作为我们测试使用的
	web应用
3、在myweb目录中新建第一个页面：index.html
4、在ClientHandler中根据request获取客户端请求的资源路
	径，然后对应的去webapps下找到该资源并做好分支判断。