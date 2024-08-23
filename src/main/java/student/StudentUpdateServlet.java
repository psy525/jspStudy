package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

public class StudentUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String dep = req.getParameter("depart");
		Connection connection=null;
		PreparedStatement statement=null;
		List<String> departs = new ArrayList<>();
		ResultSet resultSet=null;
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
//			statement.setString(1, dep);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				departs.add(resultSet.getString("depart"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet!=null) {
					resultSet.close();
				}
				if (statement!=null) {
					statement.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
		req.setAttribute("departs", departs);
		req.getRequestDispatcher("/WEB-INF/views/student/update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String depart=req.getParameter("depart");
		String newDepart=req.getParameter("newDepart");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205",
					"oracle21c");
			String sql="""
					update
						student
					set
						depart=?
					where
						depart=?
					""";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newDepart);
			statement.setString(2, depart);
			int executeUpdate = statement.executeUpdate();
			if(executeUpdate >0) {
				resp.sendRedirect("/Exercise/students");
			} else {
				resp.sendRedirect("/Exercise/students/update?id="+ depart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
