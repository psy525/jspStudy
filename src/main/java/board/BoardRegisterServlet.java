package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;

import file.FileDTO;

@WebServlet("/boards/register")
//MultipartConfig 어노테이션 또는 web.xml에 multipart-config를 추가하지 않으면
//Multipart/form-data 형식의 파일을 처리할 수 없음
@MultipartConfig(maxFileSize = 10485760)
public class BoardRegisterServlet extends HttpServlet {
	private static final String FILE_PATH = "c:\\Users\\pc25\\upload\\";
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		//첨부파일 처리
		//첨부파일과 파라미터를 함께 처리할 수 있다.
		//주로 첨부파일만 가져올때 사용하는 경우가 많다.
		//part: 부분. 특정한 하나 req.part("writer"); 이렇게
		Part filesPart = req.getPart("files");
		// 실제 데이터베이스에 저장될 내용
		long fileSize = filesPart.getSize();//첨부파일의 용량(크기) 
		String originalName = filesPart.getSubmittedFileName();//첨부파일이름 
		
		String contentType = filesPart.getContentType();//첨부파일의 컨텐츠 타입
		
		System.out.println("업로드된 파일 크기: " +fileSize);
		System.out.println("업로드된 파일 이름: " +originalName);
		System.out.println("업로드된 파일 컨텐츠 타입: " +contentType);
		
		// 실제 물리적인 서버 위치에 파일을 저장하기 
		// \ 설명 "나는 "사람"이다" 이렇게 강조하고 싶을 때. 자바에서는 ""는 문자열로 판단 나는이랑 이다가 묶이고 사람때문에 에러가 발생함. 
		// 이걸 방지하기 위해 \를 사용 -> "나는 \"사람\"이다" 즉 \뒤에는 지정된 문자(", ', t, s, n,r)만 올수있음
		
		//실제 물리적인 서버 위치에 파일을 저장하기
		String fileName = UUID.randomUUID().toString();
		filesPart.write(FILE_PATH + fileName);
		//리눅스 맥에서는 다음과 같이 작성
		//filesPart.write("/Users/pc25/upload/" + originalName);		

		
		BoardDTO board = new BoardDTO(title, content, writer);
		//파일 정보 넣어주기
		List<FileDTO> fileList=new ArrayList<FileDTO>();
		
		fileList.add(new FileDTO(FILE_PATH, fileName, originalName, fileSize));
		board.setFileList(fileList);
		
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		BoardService service=BoardService.getInstance(session);
		
		int registBoard = service.registerBoard(board);
		if (registBoard > 0) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "게시글 등록 실패!");
			req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
		}
	}

}
