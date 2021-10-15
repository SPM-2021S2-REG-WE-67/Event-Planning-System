package event.model;


public class Venues {
	public int id;
	public String resourcename;
	public String typeofvenue;
	public String workingdays;
	public String location;
	public String filename;
	public String path;
	public Venues(int id, String resourcename, String typeofvenue, String workingdays, String location, String filename, String path) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	public Venues(String resourcename, String typeofvenue, String workingdays, String location, String filename, String path) {
		super();
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Venues(int id, String resourcename, String typeofvenue, String workingdays, String location) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.workingdays = workingdays;
		this.location = location;
	}
	public Venues(int id, String resourcename, String typeofvenue, String workingdays, String location, String filename) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public Venues(String resourcename, String typeofvenue, String workingdays, String location, String filename) {
		super();
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
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
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getTypeofvenue() {
		return typeofvenue;
	}
	public void setTypeofvenue(String typeofvenue) {
		this.typeofvenue = typeofvenue;
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