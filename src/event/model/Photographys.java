package event.model;


public class Photographys {
	public int id;
	public String studioname;
	public String availableservices;
	public String workingdays;
	public String location;
	public String filename;
	public String path;
	public Photographys(int id, String studioname, String availableservices, String workingdays, String location, String filename, String path) {
		super();
		this.id = id;
		this.studioname = studioname;
		this.availableservices = availableservices;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	public Photographys(String studioname, String availableservices, String workingdays, String location, String filename, String path) {
		super();
		this.studioname = studioname;
		this.availableservices = availableservices;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Photographys(int id, String studioname, String availableservices, String workingdays, String location) {
		super();
		this.id = id;
		this.studioname = studioname;
		this.availableservices = availableservices;
		this.workingdays = workingdays;
		this.location = location;
	}
	public Photographys(int id, String studioname, String availableservices, String workingdays, String location, String filename) {
		super();
		this.id = id;
		this.studioname = studioname;
		this.availableservices = availableservices;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public Photographys(String studioname, String availableservices, String workingdays, String location, String filename) {
		super();
		this.studioname = studioname;
		this.availableservices = availableservices;
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
	public String getStudioname() {
		return studioname;
	}
	public void setStudioname(String studioname) {
		this.studioname = studioname;
	}
	public String getAvailableservices() {
		return availableservices;
	}
	public void setAvailableservices(String availableservices) {
		this.availableservices = availableservices;
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