package comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession)context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(session);
		
		List<CommentDTO> comments=service.selectComments(0);
		req.setAttribute("commentList", comments);
		req.getRequestDispatcher("/WEB-INF/views/bord/detail.jsp").forward(req, resp);
		
		
	}
}
