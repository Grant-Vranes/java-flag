修改响应头，使得响应中的响应头变为可以进行设置的。
这样才能根据实际情况响应不同的内容。

1、在HttpResponse中定义一个属性：Map headers
	其中key保存响应头的名字，value保存对应的值
	
2、对外提供get、set方法

3、修改sendHeaders方法，将原有的代码改变为根据
	headers中实际保存的响应头来进行发送。
	
4、由于一个响应中包含响应正文时一定会在响应头中包含
	Content-Type与Content-Length。对此我们
	直接在HttpResponse的setEntity方法中添加
	代码：根据给定的文件自动设置这两个头。这样免去了
	外界在设置响应正文后还要额外添加这两个头的麻烦。
	
5、由于不同的文件对应的Content-Type值都是不同的，并且
	W3C中都有规定，对此我们可以在HttpContext中再定义
	一个Map。其中key保存文件的后缀名，而value保存其介
	质类型。这样将来我们可以根据文件的后缀来获取到对应的值
	设置到响应头中。