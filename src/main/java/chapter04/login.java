package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<meata charset=\"UFT-8\">");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<form action=\'/login\' method='post'>");
		writer.print("<div>");
		writer.print("<label>");
		writer.print("<input type='text' placeholder='아이디'>");
		writer.print("</label>");
		writer.print("</div>");
		writer.print("<div>");
		writer.print("<lable>");
		writer.print("<input type='password' placeholder='패스워드'>");
		writer.print("</lable>");
		writer.print("</div>");
		writer.print("<div>");
		writer.print("<button>");
		writer.print("로그인");
		writer.print("</button>");
		writer.print("<button>");
		writer.print("확인");
		writer.print("</button>");
		writer.print("</div>");
		writer.print("</form>");
		writer.print("</body>");
		writer.print("</html>");
	}
 
}
