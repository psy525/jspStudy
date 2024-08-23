package todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/todo/complete")
public class CompleteUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramTNo = req.getParameter("tNo");
		String paramComplete = req.getParameter("complete");
		
		
		int tNo=paramTNo==null|| paramTNo.isEmpty()? 0: Integer.parseInt(paramTNo);
		boolean complete = paramComplete == null || paramComplete.isEmpty()
				? false : Boolean.parseBoolean(paramComplete);
		
		TodoVO todo = new TodoVO(tNo, complete);
		
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		TodoService service=TodoService.getInstance(session);
		TodoVO vo = service.updateComplete(todo);
		
		// 데이터베이스에 존재하는 complete 값만 가져오기
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		if(vo!=null) {
			out.print("{\"result\":\"success\", \"complete\":"+vo.isComplete()+"}");
		}else {
			out.print("{\"result\":\"failure\"}");
		}
	}
}
