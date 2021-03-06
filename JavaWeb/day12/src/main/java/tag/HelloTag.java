package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 标签类的要求：
 * 1.继承SimpleTagSupport类
 * 2.override doTag方法，在该方法中写处理逻辑
 * 3.标签有哪些属性，标签类也得有对应的属性，并且属性
 * 名要相同，类型要匹配，带得有对应的set方法。
 * @author Grant·Vranes
 *
 */
public class HelloTag extends SimpleTagSupport{
	private String msg;
	private int qty;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * 通过继承自SimpleTagSupport类提供的方法来获得pageContext。
		 * pageContext提供了获得其他所有隐含对象的方法。
		 */
		PageContext pctx = (PageContext)getJspContext();
		JspWriter out = pctx.getOut();
				
		for(int i = 0; i < qty; i++){
			out.println(msg);
		}
	}
	
}
