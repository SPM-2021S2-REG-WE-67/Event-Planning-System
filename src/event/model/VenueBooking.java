package event.model;

public class VenueBooking {
	public int id;
	public String user;
	public int mobile;
	public String nic;
	public String email;
	public int numberofguests;
    public String additionalservices;
	public String bookingdate;
    public int advancedpayment;

	public VenueBooking(int id, String user, int mobile, String nic, String email, int numberofguests, String additionalservices,
			String bookingdate, int advancedpayment) {
		super();
		this.id = id;
		this.user = user;
		this.mobile = mobile;
		this.nic = nic;
		this.email = email;
		this.numberofguests = numberofguests;
		this.additionalservices = additionalservices;
		this.bookingdate = bookingdate;
		this.advancedpayment = advancedpayment;
	}
	public VenueBooking(String user, int mobile, String nic, String email, int numberofguests, String additionalservices,
			String bookingdate, int advancedpayment) {
		super();
		this.user = user;
		this.mobile = mobile;
		this.nic = nic;
		this.email = email;
		this.numberofguests = numberofguests;
		this.additionalservices = additionalservices;
		this.bookingdate = bookingdate;
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
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumberOfGuests() {
		return numberofguests;
	}
	public void setNumberOfGuests(int numberofguests) {
		this.numberofguests = numberofguests;
	}
	public String getAdditionalServices() {
		return additionalservices;
	}
	public void setAdditionalServices(String additionalservices) {
		this.additionalservices = additionalservices;
	}
	public String getBookingDate() {
		return bookingdate;
	}
	public void setBookingDate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public int getAdvancedPayment() {
		return advancedpayment;
	}
	public void setAdvancedPayment(int advancedpayment) {
		this.advancedpayment = advancedpayment;
	}

     
	

}
