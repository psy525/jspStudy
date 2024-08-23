package memo;

import java.time.LocalDate;

public class MemoVO {
	private	int mNo;
	private String mTitle;
	private String mContent;
	private String mWriter;
	private LocalDate mRegistDate;
	private LocalDate mModifiDate;
	
	public MemoVO(String mTitle, String mContent, String mWriter) {
		super();
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mWriter = mWriter;
	}
	
	
	public MemoVO(int mNo, String mTitle, String mContent, String mWriter) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mWriter = mWriter;
	}


	public MemoVO(int mNo, String mTitle, String mContent, String mWriter, LocalDate mRegistDate) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mWriter = mWriter;
		this.mRegistDate = mRegistDate;
	}

	public MemoVO(int mNo, String mTitle, String mContent, String mWriter, LocalDate mRegistDate,
			LocalDate mModifiDate) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mWriter = mWriter;
		this.mRegistDate = mRegistDate;
		this.mModifiDate = mModifiDate;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getmWriter() {
		return mWriter;
	}
	public void setmWriter(String mWriter) {
		this.mWriter = mWriter;
	}
	public LocalDate getmRegistDate() {
		return mRegistDate;
	}
	public void setmRegistDate(LocalDate mRegistDate) {
		this.mRegistDate = mRegistDate;
	}
	public LocalDate getmModifiDate() {
		return mModifiDate;
	}
	public void setmModifiDate(LocalDate mModifiDate) {
		this.mModifiDate = mModifiDate;
	}
	@Override
	public String toString() {
		return "MemoVO [mNo=" + mNo + ", mTitle=" + mTitle + ", mContent=" + mContent + ", mWriter=" + mWriter
				+ ", mRegistDate=" + mRegistDate + ", mModifiDate=" + mModifiDate + "]";
	}
	
}
