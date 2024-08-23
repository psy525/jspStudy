package todo;

import java.util.List;

public interface TodoMapper {
	List<TodoVO> selectTodoList();
	TodoVO selectTodo(int searchTNo);
	int insertTodo(TodoVO todo);
	int updateTodo(TodoVO todo);
	int deleteTodo(int tNo);
	int updateComplete(TodoVO todo);
	TodoVO selectComplete(int tNo);
}
