package pojo;

import java.sql.Timestamp;

public class RepairRecord {
	private int id;
	private int residentId;
	private int building;
	private int room;
	private String type;
	private String content;
	private String phone;
	private Timestamp addTime;
	private String timeString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	private int status;

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RepairRecord [id=" + id + ", residentId=" + residentId + ", building=" + building + ", room=" + room
				+ ", type=" + type + ", content=" + content + ", phone=" + phone + ", addTime=" + addTime
				+ ", timeString=" + timeString + ", status=" + status + "]";
	}

}
