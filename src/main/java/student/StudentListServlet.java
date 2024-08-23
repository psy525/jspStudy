package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StudentDTO> list = new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205", "oracle21c");
			statement = connection.createStatement();
			String sql="select * from student";
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				String sNo=resultSet.getString("no");
				String depart=resultSet.getString("depart");
				String name=resultSet.getString("name");
				String address=resultSet.getString("address");
				String phone=resultSet.getString("phone");
				list.add(new StudentDTO(sNo, depart, name, address, phone));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection !=null) {
					connection.close();
					}
				if (statement !=null) {
					statement.close();
					}
				if (resultSet !=null) {
					resultSet.close();
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
			}
		}
		req.setAttribute("students", list);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
}
