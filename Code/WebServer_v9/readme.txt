重构代码

1、HttpResponse中发送状态行与响应头都使用了相同的代码，
	应当复用。对此 我们在HttpResponse中定义一个方法：
	println来复用这个功能。
	
2、在HttpContext中将CR，LF定义为常量，这样在HttpRequest
	和HttpResponse中都去引用。