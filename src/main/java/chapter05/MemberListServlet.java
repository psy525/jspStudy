package chapter05;

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

public class MemberListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberDTO> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//여기에서 데이터베이스에 접속해서 정보를 가져오는 코드 작성

			// 1. 드라이버 로딩(Reflection 기법을 활용) dbeaver? 실행하는 거
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터 베이스 연결
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std205","oracle21c");

			// 3. 쿼리 준비
			statement = connection.createStatement();
			String sql = "select mem_id, mem_name, mem_hp, mem_mail from member where mem_del_yn != 'Y'";

			// 4. 쿼리 전송
			resultSet = statement.executeQuery(sql);

			// 5. 결과 처리
			while (resultSet.next()){
				String memId = resultSet.getString("mem_id");
				String memName = resultSet.getString("mem_name");
				String memHp = resultSet.getString("mem_hp");
				String memMail = resultSet.getString("mem_mail");
				list.add(new MemberDTO(memId, memName,memHp, memMail));
				// 이 부분에서 데이터를 화면에 출력
			}

		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 사용된 자원 반납
			try {
				if(resultSet != null) {
					resultSet.close(); 
				}
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {					
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// list객체를 다음 서블릿(또는 JSP)에게 보내는 방법 
		req.setAttribute("members", list); //HashMap과 비슷한 형태로 객체 저장
		// 화면으로요청을 위임(dispatcher)
		req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
	}
}
