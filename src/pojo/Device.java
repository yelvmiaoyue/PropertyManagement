package pojo;

import java.sql.Date;

public class Device {
	private String id;
	private String type;
	private String manufacturer;
	private String position;
	private Date addTime;
	private Date fixTime;

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getFixTime() {
		return fixTime;
	}

	public void setFixTime(Date fixTime) {
		this.fixTime = fixTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", type=" + type + ", manufacturer=" + manufacturer + ", position=" + position
				+ ", addTime=" + addTime + ", fixTime=" + fixTime + "]";
	}

}
