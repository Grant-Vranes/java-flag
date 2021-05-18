处理空请求
	HTTP协议允许客户端发送空请求。就是客户端与服务端连接后，
	实际没有发送任何内容，但是我们现在的处理是要解析请求，这
	会导致HttpRequest解析异常。对此，当我们解析请求时发现
	一个空请求时，我们将异常最终抛给ClientHandler，并且
	ClientHandler在接收到这个异常后就不再做后续任何处理，
	直接与服务端断开连接即可。
	
	1、在core包中添加一个自定义异常：
		EmptyRequestException 空请求异常
		
	2、在HttpRequest解析请求行若是发现是空请求时则实例化
		空请求异常并将其抛出给构造方法，再经构造方法继续抛出
		给ClientHandler。
	
	3、ClientHandler的run方法中添加一个空请求的捕获操作，
		以达到当实例化HttpRequst出现空请求后跳过其他所有
		处理操作的目的。

		