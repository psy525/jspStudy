package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/delete")
public class MemoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mNo=req.getParameter("mNo")==null|| req.getParameter("mNo").isEmpty() ? 0: Integer.parseInt(req.getParameter("mNo"));
		MemoService service = new MemoService();
		int deleteMemo = service.deleteMemo(mNo);
		if(deleteMemo>0) {
			resp.sendRedirect("/memos");
		} else {
			req.setAttribute("msg", "삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/memo/view.jsp").forward(req, resp);
		}
	}
}
