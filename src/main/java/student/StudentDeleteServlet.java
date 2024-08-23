package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resulSet=null;
		List<String> departs=new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205",
					"oracle21c");
			String sql = """
					SELECT
						DISTINCT DEPART
					FROM
						STUDENT
					""";
			statement = connection.prepareStatement(sql);
			resulSet = statement.executeQuery();
			while (resulSet.next()) {
				departs.add(resulSet.getString("depart"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resulSet!=null) {
					resulSet.close();
				}
				if (statement!=null) {
					statement.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		req.setAttribute("departs", departs);
		req.getRequestDispatcher("/WEB-INF/views/student/delete.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String depart=req.getParameter("depart");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205",
					"oracle21c");
			String sql="""
					delete
					from student
					where depart=?
					""";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, depart);
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate>0) {
				resp.sendRedirect("/Exercise/students");
			} else {
				resp.sendRedirect("/Exercise/students/delete?id="+ depart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
