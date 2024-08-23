package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExercuseServlet extends HttpServlet{
	// 요청 방식(form의 post냐 get이야)에 따라 메소드가 구분됨
	// method(8개): get, post, put, delete, patch, head, options, connect
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();//응답 내용을 작성하는 객체
		out.print("<html>");
		out.print("<head>");
		out.print("<meata charset=\"UFT-8\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<div>");
		out.print("안녕하세요!");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}
}