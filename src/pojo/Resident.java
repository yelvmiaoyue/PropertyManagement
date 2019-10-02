package pojo;

import java.util.List;

public class Resident {
	private int id;
	private int building;
	private int room;
	private String owner;
	private String phone;
	private String email;
	private List<ResidentMember> residentMember = null;

	public List<ResidentMember> getResidentMember() {
		return residentMember;
	}

	public void setResidentMember(List<ResidentMember> residentMember) {
		this.residentMember = residentMember;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Resident [id=" + id + ", building=" + building + ", room=" + room + ", owner=" + owner + ", phone="
				+ phone + ", email=" + email + ", residentMember=" + residentMember + "]";
	}

}
