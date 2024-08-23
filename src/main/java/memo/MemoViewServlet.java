package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/view")
public class MemoViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int searchMNo=req.getParameter("mNo") !=null? Integer.parseInt(req.getParameter("mNo")):0;
		MemoService service=new MemoService();
		MemoVO memo = service.selectMemo(searchMNo);
		
		req.setAttribute("memo", memo);
		req.getRequestDispatcher("/WEB-INF/views/memo/view.jsp").forward(req, resp);
	}

}
