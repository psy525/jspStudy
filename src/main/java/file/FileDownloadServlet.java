package file;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = paramId == null || paramId.isEmpty() ? 0: Integer.parseInt(paramId);
		
		ServletContext context = req.getServletContext();
		SqlSession sqlSession=(SqlSession) context.getAttribute("sqlSession");
		
		FileService service= FileService.getInstance(sqlSession);
		FileDTO file = service.selectFile(id);
		
		
		String filePath = file.getFilePath();
		String fileName = file.getFileName();
		
		//한글 이름의 파일은 인코딩을 해줘야 함
		String encodeFileName = URLEncoder.encode(file.getOriginalName(), "UTF-8").replaceAll("\\+"," ");
		
		//이렇게 하면 다운받는 파일명이 fileName이 됨. 그래서 파일의 origin 네임을 헤더에 넣어줘야 함
		//응답 헤어 정의
		resp.setContentType("application/octet-stream"); //8비트 스트링 파일
		resp.setHeader("Content-Disposition", "attachment;filename=\""+encodeFileName+"\"");
		resp.setHeader("Content-Length", String.valueOf(file.getFileSize()));
		
		// 첨부파일만 응답해야 한다. => 응답 바디
		Path path = Paths.get(filePath, fileName);
		OutputStream outputStream = resp.getOutputStream();
		//원래는 첨부파일 위치에 파일을 읽어와서 outputstream으로 데이터 전송을 해야 됨 
		Files.copy(path, outputStream);
		
	}
}
