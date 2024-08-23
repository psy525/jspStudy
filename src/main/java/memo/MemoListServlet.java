package memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos")
public class MemoListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemoService service = new MemoService();
		List<MemoVO> memoList = service.selectMemoList();
		req.setAttribute("memoList", memoList);
		req.getRequestDispatcher("/WEB-INF/views/memo/list.jsp").forward(req, resp);	
	}
}
