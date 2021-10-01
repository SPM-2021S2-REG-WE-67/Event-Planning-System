package event.model;

public class EntertainmentBooking {

	public int id;
	public String user;
	public String nic;
	public int mobile;
	public String email;
	public String bookingdate;
    public String additionalneeds;
	public int noofguests;
     public int advancedpayment;
	public EntertainmentBooking(int id, String user, String nic, int mobile, String email, String bookingdate, String additionalneeds,
			int noofguests, int advancedpayment) {
		super();
		this.id = id;
		this.user = user;
		this.nic = nic;
		this.mobile = mobile;
		this.email = email;
		this.bookingdate = bookingdate;
		this.additionalneeds = additionalneeds;
		this.noofguests = noofguests;
		this.advancedpayment = advancedpayment;
	}
	public EntertainmentBooking(String user, String nic, int mobile, String email, String bookingdate, String additionalneeds,
			int noofguests, int advancedpayment) {
		super();
		this.user = user;
		this.nic = nic;
		this.mobile = mobile;
		this.email = email;
		this.bookingdate = bookingdate;
		this.additionalneeds = additionalneeds;
		this.noofguests = noofguests;
		this.advancedpayment = advancedpayment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public int getnoofguests() {
		return noofguests;
	}
	public void setnoofguests(int noofguests) {
		this.noofguests = noofguests;
	}
	public int getAdvancedPayment() {
		return advancedpayment;
	}
	public void setAdvancedPayment(int advancedpayment) {
		this.advancedpayment = advancedpayment;
	}

}
