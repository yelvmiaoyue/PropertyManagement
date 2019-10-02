package pojo;

public class SearchCondition {
	private RepairRecord record;
	private SearchData data;
	private User user;
	private Bill bill;
	private Car car;
	private Resident resident;

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SearchData getData() {
		return data;
	}

	public void setData(SearchData data) {
		this.data = data;
	}

	public RepairRecord getRecord() {
		return record;
	}

	public void setRecord(RepairRecord record) {
		this.record = record;
	}

}
