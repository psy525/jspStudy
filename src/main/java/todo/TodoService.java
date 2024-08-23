package todo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;

public class TodoService {
	private static TodoService instance = new TodoService();
	private static TodoMapper mapper;
	
	private TodoService() {
//		SqlSession session = MySqlSession.getSqlSession();
//		mapper = session.getMapper(TodoMapper.class);
	}
	
	public static TodoService getInstance(SqlSession session) {
		mapper=session.getMapper(TodoMapper.class);
		return instance;
	}
		
	public List<TodoVO> selectTodoList() {
		return mapper.selectTodoList();
	}

	public TodoVO selectTodo(int searchTNo) {
		return mapper.selectTodo(searchTNo);
	}

	public int insertTodo(TodoVO todo) {
		// TodoDAO의 insertTodo()를 호출하고 싶어요.
		return mapper.insertTodo(todo);
	}

	public int updateTodo(TodoVO todo) {
		return mapper.updateTodo(todo);
	}

	public int deleteTodo(int tNo) {
		return mapper.deleteTodo(tNo);
	}

	public TodoVO updateComplete(TodoVO todo) {
		mapper.updateComplete(todo);
		return mapper.selectComplete(todo.gettNo());
	}

	// 서비스는 DAO에 있는 두가지 기능을 하나로 묶어줄 수 있음

}
