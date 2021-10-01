package event.model;

public class EntertainmentBooking {

	public int id;
	public String resourcename;
	public String typeOfEntertainment;
	public int days;
	public String location;
	public String bookingdate;
    public String additionalneeds;
     public int advancedpayment;
	public EntertainmentBooking(int id, String resourcename, String typeOfEntertainment, int days, String location, String bookingdate, String additionalneeds,
			 int advancedpayment) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeOfEntertainment = typeOfEntertainment;
		this.days = days;
		this.location = location;
		this.bookingdate = bookingdate;
		this.additionalneeds = additionalneeds;
		this.advancedpayment = advancedpayment;
	}
	public EntertainmentBooking(String resourcename, String typeOfEntertainment, int days, String location, String bookingdate, String additionalneeds,
	int advancedpayment) {
		super();
		this.resourcename = resourcename;
		this.typeOfEntertainment = typeOfEntertainment;
		this.days = days;
		this.location = location;
		this.bookingdate = bookingdate;
		this.additionalneeds = additionalneeds;
		this.advancedpayment = advancedpayment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getresourcename() {
		return resourcename;
	}
	public void setresourcename(String user) {
		this.resourcename = resourcename;
	}
	public String gettypeOfEntertainment() {
		return typeOfEntertainment;
	}
	public void settypeOfEntertainment(String typeOfEntertainment) {
		this.typeOfEntertainment = typeOfEntertainment;
	}
	public int getdays() {
		return days;
	}
	public void setdays(int days) {
		this.days = days;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
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

	public int getAdvancedPayment() {
		return advancedpayment;
	}
	public void setAdvancedPayment(int advancedpayment) {
		this.advancedpayment = advancedpayment;
	}

}
