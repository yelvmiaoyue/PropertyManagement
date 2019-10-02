package pojo;

public class ResidentMember {
	private int id;
	private int pid;
	private String name;
	private int sex;
	private String idCard;
	private String phone;
	private String workPlace;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	@Override
	public String toString() {
		return "ResidentMember [id=" + id + ", pid=" + pid + ", name=" + name + ", sex=" + sex + ", idCard=" + idCard
				+ ", phone=" + phone + ", workPlace=" + workPlace + "]";
	}

}
