重构项目
将ClientHandler中响应客户端的操作进行重构

设计一个类：HttpResponse，用它的每一个实例表示服务端发送给
客户端的一个具体响应内容。

1、在http包中添加类：HttpResponse

2、在HttpResponse类中定义方法：flush，用来将当前响应
	发送给客户端
	flush方法需要做三件事：
	1：发送状态行
	2：发送响应头
	3：发送响应正文
	
3、将ClientHandler中响应客户端的操作
	移动到HttpResponse对应方法中
	
4、在ClientHandler中实例化HttpResponse，并设置要
	响应的内容后调用flush方法响应客户端