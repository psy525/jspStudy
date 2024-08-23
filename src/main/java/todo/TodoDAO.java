package todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import chapter05.MemberDTO;
import common.MySqlSession;

public class TodoDAO {
	//스프링은 기본적으로 객체가 다 싱글톤임. 자바복습을 위해 싱글톤을 사용해보자
	//자바는 필드는 private하게 접근을 막고 메소드는 public으로 함
	private static TodoDAO instance = new TodoDAO();
	private SqlSession session = MySqlSession.getSqlSession();

	private TodoDAO() {
		//생성자: 외부에서 개체를 생성할 때 호출하는 메소드
	}
	
	public static TodoDAO getInstance() {
		return instance;
	}
	
	public List<TodoVO> selectTodoList() {
		return session.selectList("todo.TodoMapper.selectTodoList");
	}

	public TodoVO selectTodo(int searchTNo) {
		return session.selectOne("todo.TodoMapper.selectTodo", searchTNo);
	}

	public int insertTodo(TodoVO todo) {
//			todoVo 미리 만들어두면 title, wirter 대신 todo.getTitle 이렇게 쓸 수 있음
		return session.insert("todo.TodoMapper.insertTodo", todo);
	}

	public int updateTodo(TodoVO todo) {
		return session.update("todo.TodoMapper.updateTodo", todo);
	}

	public int deleteTodo(int tNo) {
		return session.delete("todo.TodoMapper.deleteTodo", tNo);
	}

	public int updateComplete(TodoVO todo) {
		return session.update("todo.TodoMapper.updateComplete", todo);
	}

	
	public TodoVO selectComplete(int tNo) {
		return session.selectOne("todo.TodoMapper.selectCompleteTodo", tNo);
	}
	
}
