package event.model;


public class Entertainments{
	public int id;
	public String resourcename;
	public String typeofentertainment;
	public String workingdays;
	public String location;
	public String filename;
	public String path;
	public Entertainments(int id, String resourcename, String typeofentertainment, String workingdays, String location, String filename, String path) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofentertainment = typeofentertainment;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	public Entertainments(String resourcename, String typeofentertainment, String workingdays, String location, String filename, String path) {
		super();
		this.resourcename = resourcename;
		this.typeofentertainment = typeofentertainment;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Entertainments(int id, String resourcename, String typeofentertainment, String workingdays, String location) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofentertainment = typeofentertainment;
		this.workingdays = workingdays;
		this.location = location;
	}
	public Entertainments(int id,String resourcename, String typeofentertainment, String workingdays, String location, String filename) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofentertainment = typeofentertainment;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public Entertainments(String resourcename, String typeofentertainment, String workingdays, String location, String filename) {
		super();
		this.resourcename = resourcename;
		this.typeofentertainment = typeofentertainment;
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
	public String getresourcename() {
		return resourcename;
	}
	public void setresourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String gettypeofentertainment() {
		return typeofentertainment;
	}
	public void setCateringmenudetails(String cateringmenudetails) {
		this.typeofentertainment = typeofentertainment;
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