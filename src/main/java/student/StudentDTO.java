package student;

import java.time.LocalDate;

public class StudentDTO {
	private String sNo;
	private String depart;
	private String name;
	private String address;
	private String phone;
	
	public StudentDTO(String sNo, String depart, String name, String address, String phone) {
		super();
		this.sNo = sNo;
		this.depart = depart;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	
	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "StudentDTO [sNo=" + sNo + ", depart=" + depart + ", name=" + name + ", address=" + address + ", phone="
				+ phone + "]";
	}
}
	
	