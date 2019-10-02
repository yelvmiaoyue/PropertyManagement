package pojo;

import java.util.List;

public class ResidentAndMember {
	private Resident resident;
	private List<ResidentMember> upd;
	private List<ResidentMember> ins;

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public List<ResidentMember> getUpd() {
		return upd;
	}

	public void setUpd(List<ResidentMember> upd) {
		this.upd = upd;
	}

	public List<ResidentMember> getIns() {
		return ins;
	}

	public void setIns(List<ResidentMember> ins) {
		this.ins = ins;
	}

}
