package memo;

import java.util.List;

public class MemoService {
	public List<MemoVO> selectMemoList(){
		MemoDAO dao = new MemoDAO();
		return dao.selectMemoList();
	}
	
	public MemoVO selectMemo(int searchMNo) {
		MemoDAO dao=new MemoDAO();
		return dao.selectMemo(searchMNo);
	}
	
	public int insertMemo(MemoVO memo) {
		MemoDAO dao = new MemoDAO();
		return dao.insertMemo(memo);
	}
	
	public int updateMemo(MemoVO memo) {
		MemoDAO dao=new MemoDAO();
		return dao.updateMemo(memo);
	}
	
	public int deleteMemo(int mNo) {
		MemoDAO dao=new MemoDAO();
		return dao.deleteMemo(mNo);
	}
}
