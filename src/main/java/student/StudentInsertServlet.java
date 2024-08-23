package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/student/new.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String sNo=req.getParameter("sNo");
		String depart=req.getParameter("depart");
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std205","oracle21c");
			String sql="""
					insert into student
						(NO, DEPART, NAME, ADDRESS, PHONE)
					values
						(?, ?, ?, ?, ?) 
					""";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, sNo);
			statement.setString(2, depart);
			statement.setString(3, name);
			statement.setString(4, address);
			statement.setString(5, phone);
			
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate>0) {
				resp.sendRedirect("/Exercise/students");
			} else {
				resp.setContentType("text/html;charset=utf-8");
				resp.getWriter().print("등록실패");
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}
