package memo;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
	public List<MemoVO> selectMemoList() {
		List<MemoVO> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205", "oracle21c");
			String sql = """
					select
						NO,
						TITLE,
						CONTENT,
						WRITER,
						REGISTER_DATE,
						MODIFIED_DATE
					from
						MEMO
					""";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int mNo = resultSet.getInt("NO");
				String mTitle = resultSet.getString("TITLE");
				String mContent = resultSet.getString("CONTENT");
				String mWriter = resultSet.getString("WRITER");
				LocalDate mRegistDate = resultSet.getDate("REGISTER_DATE").toLocalDate();
				LocalDate mModifiDate = resultSet.getDate("MODIFIED_DATE") == null ? null
						: resultSet.getDate("MODIFIED_DATE").toLocalDate();
				list.add(new MemoVO(mNo, mTitle, mContent, mWriter, mRegistDate, mModifiDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemoVO selectMemo(int searchMNo) {
		MemoVO vo= null;
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205", "oracle21c");
			String sql="""
					select
						NO,
						TITLE,
						WRITER,
						REGISTER_DATE,
						CONTENT
					from
						memo
					where
						NO=?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchMNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String mTitle = resultSet.getString("TITLE");
				String mWriter = resultSet.getString("WRITER");
				LocalDate mRegistDate = resultSet.getDate("REGISTER_DATE").toLocalDate();
				String mContent = resultSet.getString("CONTENT");
				int mNo = resultSet.getInt("NO");
				vo = new MemoVO(mNo, mTitle, mContent, mWriter, mRegistDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection!=null) {
					connection.close();
				}
				if(statement!=null) {
					statement.close();
				}	
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vo;
	}

	public int insertMemo(MemoVO memo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205", "oracle21c");
			String sql = """
					insert into memo
						(title, content, writer)
					values
					(?,?,?)
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, memo.getmTitle());
			statement.setString(2, memo.getmContent());
			statement.setString(3, memo.getmWriter());
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return executeUpdate;
	}
	
	public int updateMemo(MemoVO memo) {
		Connection connection=null;
		PreparedStatement statement = null;
		int executeUpdate=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205",
					"oracle21c");
			String sql="""
					update
						memo
					set
						title=?, 
						content=?, 
						writer=?
					where
						no=?
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, memo.getmTitle());
			statement.setString(2, memo.getmContent());
			statement.setString(3, memo.getmWriter());
			statement.setInt(4, memo.getmNo());
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executeUpdate;
	}
	
	public int deleteMemo(int mNo) {
		Connection connection=null;
		PreparedStatement statement = null;
		int executeUpdate =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std205",
					"oracle21c");
			String sql="""
					delete from
						memo
					where
						no=?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, mNo);
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return executeUpdate;
	}
}
