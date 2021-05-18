添加响应404页面的操作
当客户端请求的资源不存在时，应当响应给客户端404页面。
并且状态代码与描述也要对应。

1、在HttpResponse中定义属性：
	int statusCode	表示状态代码
	String statusReason表示状态描述
	他们的默认值分别为200，‘OK’。这样做的好处在于
	正常响应时可以不设置这两个值。
	
2、修改 sendStatusLine方法，将发送状态行的代码改为
	发送对应属性statusCode，statusReason。
	
3、在http包中新建一个类：HttpContext
	使用这个类来定义相关Http协议中的内容。
	
	定义一个静态属性：status_code_reason_mapping
	它是一个Map类型的，其中key存放状态代码，value存放
	对应的状态描述。这样百年与我们将来根据状态代码直接获取到
	对应的描述信息。
	
4、在HttpResponse的设置状态代码的方法中添加根据状态代码
	去HttpContext获取对应的状态描述并设置到状态描述属性上。
	这样的好处在于，将来外面对response设置状态代码时就无需
	再单独设置状态描述了。

5、再webapps目录下新建一个目录root，在里面创建页面：404.html。
	这个页面是一个公共页面，无论请求我们哪个应用中的资源，只要不
	存在都会响应这个页面。
	
6、在ClientHandler处理请求的分支中，如果资源没有找到，则设置
	response的状态代码为404，并且将webapps/root/404.html
	页面设置好，这样就会将该页面响应给客户端了。