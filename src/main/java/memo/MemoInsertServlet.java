package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/new")
public class MemoInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/memo/new.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String mTitle = req.getParameter("title");
		String mContent = req.getParameter("content");
		String mWriter = req.getParameter("writer");
		MemoService service=new MemoService();
		int insertMemo = service.insertMemo(new MemoVO(mTitle, mContent, mWriter));
		if(insertMemo>0) {
			resp.sendRedirect("/memos");
		} else {
			req.setAttribute("msg", "작성실패");
			req.getRequestDispatcher("/WEB-INF/views/memo/new.jsp").forward(req, resp);
		}
	}
}
