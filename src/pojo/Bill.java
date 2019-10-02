package pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Bill {
	private int id;
	private int building;
	private int room;
	private int type;
	private BigDecimal cost;
	private Date time;
	private int status;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", building=" + building + ", room=" + room + ", type=" + type + ", cost=" + cost
				+ ", time=" + time + ", status=" + status + "]";
	}

}
