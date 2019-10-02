package pojo;

import java.util.List;

public class SearchData {
	private int pageNum;
	private int pageSize = 5;
	private int pageStart;
	private int total;
	private List<Statement> statement = null;
	private List<FixRecord> fixRecord = null;
	private List<Device> device = null;
	private List<RepairRecord> repairRecord = null;
	private List<Bill> bill = null;
	private List<User> user = null;
	private List<Car> car = null;
	private List<Account> account = null;
	private List<Resident> resident = null;

	public List<Resident> getResident() {
		return resident;
	}

	public void setResident(List<Resident> resident) {
		this.resident = resident;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public List<RepairRecord> getRepairRecord() {
		return repairRecord;
	}

	public void setRepairRecord(List<RepairRecord> repairRecord) {
		this.repairRecord = repairRecord;
	}

	@Override
	public String toString() {
		return "SearchData [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageStart=" + pageStart + ", total="
				+ total + ", statement=" + statement + ", fixRecord=" + fixRecord + ", device=" + device
				+ ", repairRecord=" + repairRecord + "]";
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}

	public List<FixRecord> getFixRecord() {
		return fixRecord;
	}

	public void setFixRecord(List<FixRecord> fixRecord) {
		this.fixRecord = fixRecord;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Statement> getStatement() {
		return statement;
	}

	public void setStatement(List<Statement> statement) {
		this.statement = statement;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
