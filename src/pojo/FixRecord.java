package pojo;

import java.sql.Date;

public class FixRecord {
	private String deviceId;
	private String type;
	private Date time;
	private String man;
	private int result;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "FixRecord [deviceId=" + deviceId + ", type=" + type + ", time=" + time + ", man=" + man + ", result="
				+ result + "]";
	}

}
