package file;

import java.time.LocalDateTime;

// FileVO는 DB랑 똑같이 매칭이 되지 않아도 됨. DTO에 들어가는 이름은 전달되는 내용이라고 생각하고 작성해야 됨
//여러개의 테이블이 join 됐다면 결합이 완료된 형태로 만들어야 함.
public class FileDTO {
//	아이디랑 등록일은 디폴트 값이 있어서 안해도 됨 하지만 아이디는 조회할 때 필요하니까 사용
	private int id;
	private int boardId;
	private String filePath;
	private String fileName;
	private String originalName;
	private long fileSize;
	private LocalDateTime registerDate;
	
	public FileDTO() {
	}
	
	public FileDTO(String filePath, String fileName, String originalName, long fileSize) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
	}
	public FileDTO(int id, int boardId, String filePath, String fileName, String originalName, long fileSize,
			LocalDateTime registerDate) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
		this.registerDate = registerDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", boardId=" + boardId + ", filePath=" + filePath + ", fileName=" + fileName
				+ ", originalName=" + originalName + ", fileSize=" + fileSize + ", registerDate=" + registerDate + "]";
	}
}
