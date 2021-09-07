package event.model;

public class Venue {
	public int id;
	public String resourcename;
	public String typeofvenue;
	public String location;
	public String workingdays;
	public String filename;
	public String path;
	public Venue(int id, String resourcename, String typeofvenue, String location, String workingdays, String filename, String path) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
		this.path = path;
	}
	public Venue(String resourcename, String typeofvenue, String location, String workingdays, String filename, String path) {
		super();
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Venue(int id, String resourcename, String typeofvenue, String location, String workingdays) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.location = location;
		this.workingdays = workingdays;
	}
	public Venue(int id, String resourcename, String typeofvenue, String location, String workingdays, String filename) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
	}
	public Venue(String resourcename, String typeofvenue, String location, String workingdays, String filename) {
		super();
		this.resourcename = resourcename;
		this.typeofvenue = typeofvenue;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourcename;
	}
	public void setResourceName(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getTypeOfVenue() {
		return typeofvenue;
	}
	public void setTypeOfVenue(String typeofvenue) {
		this.typeofvenue = typeofvenue;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWorkingDays() {
		return workingdays;
	}
	public void setWorkingDays(String workingdays) {
		this.workingdays = workingdays;
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
