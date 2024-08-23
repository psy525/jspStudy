package comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CommentService {
	private static CommentService instance = new CommentService();
	private static CommentMapper mapper;

	public CommentService() {
	}
	public static CommentService getInstance(SqlSession session) {
		mapper=session.getMapper(CommentMapper.class);
		return instance;
	}
	public List<CommentDTO> selectComments(int boardId) {
		return mapper.selectComments(boardId);
	}
	
	public CommentDTO selectComment(int id) {
		return mapper.selectComment(id);
	}
	//댓글 등록하기
	public CommentDTO registerComment(CommentDTO commnet) {
		mapper.registerComment(commnet);
		return mapper.selectComment(commnet.getId());
	}
	public int modifyComment(CommentDTO comment) {
		return mapper.modifyComment(comment);
	}
	
	public int removeComment(int id) {
		return mapper.removeComment(id);
	}
}
