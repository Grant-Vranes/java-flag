package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		synchronized(this) {
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}

}
