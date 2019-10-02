package pojo;

import java.math.BigDecimal;

public class Account {
	private int id;
	private int building;
	private int room;
	private String username;
	private String password;
	private int rid;
	private BigDecimal money = new BigDecimal(10000);

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", building=" + building + ", room=" + room + ", username=" + username
				+ ", password=" + password + ", rid=" + rid + ", money=" + money + "]";
	}

}
