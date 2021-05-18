完成登录业务

用户打开登陆页面，输入登录信息后点击登录按钮，服务端在接收到这些数据后
对比user.dat文件中所有的注册用户信息，若有与之匹配的记录则响应登录成
功页面，否则响应登录失败页面

实现步驟：
1：在webapps/myweb目录下创建三个页面:
	login.html	登录页面
	其中form表单action="login"
	需要两个输入框：用户名及密码
	
	login_success.html	登录成功提示页面
	login_fail.html	登录失败提示页面
	
2：在servlets包中添加LoginServlet并定义好对应的service方法
	2.1：通过request获取用户名及密码
	2.2：使用RandomAccessFile读取user.dat文件，读取每条记录
		的用户名和密码。若匹配上则设置response响应登录成功页面。
		若最终没有一条记录匹配或对应用户的密码不对时设置response
		响应登录失败页面。
		
3：在ClientHandler判断请求是否为注册业务之下再添加一个分支，判断请求
	是否为登录。而登录的请求路径应当为：/myweb/login
	如果该请求是登陆业务，则实例化LoginServlet并调用其service方法
	处理登录操作。
	
