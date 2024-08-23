package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;
import file.FileDTO;

public class BoardService {
	private static BoardService instance= new BoardService();
	private static BoardMapper mapper;
	
	public BoardService() {
		//service를 호출하기전에, re
	
//		SqlSession session = MySqlSession.getSqlSession();
//		mapper = session.getMapper(BoardMapper.class);
	}
	
	public static BoardService getInstance(SqlSession session) {
		mapper = session.getMapper(BoardMapper.class);
		return instance;
	}
	
	List<BoardDTO> selectBoards() {
		return mapper.selectBoards();
	}
	
	//이거 중요함
	BoardDTO selectBoard(int id) {
		return  mapper.selectBoard(id);
	}
	
	//첨부파일도 함께 등록하는 것. 첨부파일이 에러나면 게시글 자체가 등록이 안되게 막는 것(첨부파일 서블릿을 따로 만들수도 있기는 함)
	int registerBoard(BoardDTO board) {
		 mapper.registerBoard(board);
		 //첨부파일이 어떤 게시글에 첨부가 되었는지 알기 위해서는 boardId 값이 필요함.
		 //그래서 registerBoard가 먼저오고 그 다음에 insertFile이 오는 것. 이 부분은 유의하기
		 //게시글을 등록한 뒤에 방금 등록된 게시글 번호를 가져와서 첨부파일 내용을 등록할 때 함께 넣어줘야 한다.
		 int boardID = board.getId();
		 List<FileDTO> fileList = board.getFileList();
		 for (FileDTO file : fileList) {
			file.setBoardId(boardID);
		}
		 return mapper.insertFile(fileList);
	}
	
	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
}
