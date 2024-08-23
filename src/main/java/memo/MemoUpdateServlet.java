package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/update")
public class MemoUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateMNo = req.getParameter("mNo");
		int mNo = updateMNo == null|| updateMNo.isEmpty()? 0 : Integer.parseInt(updateMNo);
		
		MemoService service = new MemoService();
		MemoVO memo = service.selectMemo(mNo);
		
		req.setAttribute("memo", memo);
		req.getRequestDispatcher("/WEB-INF/views/memo/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String paramMNo = req.getParameter("mNo");
		int mNo= paramMNo ==null || paramMNo.isEmpty()? 0:Integer.parseInt(paramMNo);
		
		String mTitle = req.getParameter("mTitle");
		String mContent = req.getParameter("mContent");
		String mWriter = req.getParameter("mWriter");
		
		MemoVO memo = new MemoVO(mNo, mTitle, mContent, mWriter);
		
		MemoService service = new MemoService();
		int updateMemo=service.updateMemo(memo);
		
		if(updateMemo>0) {
			resp.sendRedirect("/memos");
		} else {
			req.setAttribute("msg", "수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/memo/update.jsp").forward(req, resp);
		}
		
	}
}
