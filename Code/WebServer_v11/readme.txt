完成注册业务

用户打开注册页面，输入注册信息后点击注册按钮，服务端在接收到
这些数据后写入文件并响应注册成功页面，完成注册流程。

这里主要设计的知识点：
1：理解页面上表单的提交（GET，POST两种提交方式）
	GET：地址栏形式提交，数据会包含在URL中
	POST：打包提交，数据会包含在请求的消息正文中
2：理解URL中提交数据的格式
3：如何解析请求中用户提交的数据

实现过程：
1:在webapps/myweb下新建一个注册页面：reg.html
	页面中表单提交的地址指定为：reg

2:由于请求的URL中可能含有用户提交的数据，对此我们在解析
	请求时要对url进一步解析。将其拆分为两部分：请求路径与
	参数部分。并且再对参数部分进行进一步解析，得到每个具体
	的参数。
	重构HttpRequest解析请求行的代码。
	2.1:首先在HttpRequest中定义三个属性：
		String requestURI:用于保存url中的请求部分
		String queryString:用于保存url中的参数部分
		Map parameters:用于保存具体的每个参数
						key:参数名	value:参数值
	
	2.2：提供一个方法：parseURL，该方法要对url进行进一步解析
		，并将解析出的内容分别设置到2.1步骤定义的对应属性中。
		
	2.3:在原解析请求行的方法：parseRequestLine中党得到url
		后，就调用parseURL方法，对其进一步解析。
		
	2.4：最后为2.1定义的属性提供对外的get方法。
	
3:创建一个包:servlets
	定义一个用于处理注册业务的类:RegServlet,并定义一个用于处理
	注册的方法:service
	
4:在ClientHandler处理请求的地方再添加一个分支，先判断请求是否
	为请求注册业务，如果是请求注册业务则实例化一个RegServlet并调用
	其service方法处理；如果不是再执行原流程，判断是否请求一个资源。
	
5:在webapps/myweb目录中添加注册成功页面：reg_success.html

6:完成RegServlet的service方法，在该方法中首先获取用户提交的注册信息，
	并写入到user.dat文件之后设置response响应注册成功页面