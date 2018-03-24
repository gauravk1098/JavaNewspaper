package newspaper;

public class TCBill {
	String Cid;
	Double Bill;
	
	public TCBill() {
	
	}
	
	
	public TCBill(String cid, Double bill) {
		super();
		Cid = cid;
		Bill = bill;
	}


	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public Double getBill() {
		return Bill;
	}
	public void setBill(Double bill) {
		Bill = bill;
	}	
}
