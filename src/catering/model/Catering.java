package event.model;

public class Catering {
	public int id;
	public String cateringname;
	public String caterinmenudetails;
	public String workingdays;
	public String location;
	public String filename;
	public String path;
	public Catering(int id, String cateringname, String caterinmenudetails, String workingdays, String location, String filename, String path) {
		super();
		this.id = id;
		this.cateringname = cateringname;
		this.caterinmenudetails = caterinmenudetails;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	public Catering(String cateringname, String caterinmenudetails, String workingdays, String location, String filename, String path) {
		super();
		this.cateringname = cateringname;
		this.caterinmenudetails = caterinmenudetails;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Catering(int id, String cateringname, String caterinmenudetails, String workingdays, String location) {
		super();
		this.id = id;
		this.cateringname = cateringname;
		this.caterinmenudetails = caterinmenudetails;
		this.workingdays = workingdays;
		this.location = location;
	}
	public Catering(int id, String cateringname, String caterinmenudetails, String workingdays, String location, String filename) {
		super();
		this.id = id;
		this.cateringname = cateringname;
		this.caterinmenudetails = caterinmenudetails;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public Catering(String cateringname, String caterinmenudetails, String workingdays, String location, String filename) {
		super();
		this.cateringname = cateringname;
		this.caterinmenudetails = caterinmenudetails;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCateringname() {
		return cateringname;
	}
	public void setCateringname(String cateringname) {
		this.cateringname = cateringname;
	}
	public String getCaterinmenudetails() {
		return caterinmenudetails;
	}
	public void setCaterinmenudetails(String caterinmenudetails) {
		this.caterinmenudetails = caterinmenudetails;
	}
	public String getWorkingdays() {
		return workingdays;
	}
	public void setWorkingdays(String workingdays) {
		this.workingdays = workingdays;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}