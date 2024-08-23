package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/todo/insert")
public class TodoInsertServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/todo/insert.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String paramDueDate = req.getParameter("dueDate");
		LocalDate dueDate=paramDueDate ==null || paramDueDate.isEmpty()
				? LocalDate.now() : LocalDate.parse(paramDueDate);
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		TodoService service=TodoService.getInstance(session);
		int insertTodo = service.insertTodo(new TodoVO(title,writer, dueDate));
		if(insertTodo>0) {
			resp.sendRedirect("/todo/list");
		} else {
			req.setAttribute("msg", "등록에실패했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/todo/insert.jsp").forward(req, resp);
		}
		
	}
}
