package event.model;

public class entertainment {
	public int id;
	public String resourcename;
	public String typeOfEntertainment;
	public String days;
	public String location;

	public String filename;
	public String path;
	
	

	public entertainment(int id, String resourcename, String typeOfEntertainment, String days, String location) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeOfEntertainment = typeOfEntertainment;
		this.days = days;
		this.location = location;
	}

	public entertainment(String resourcename, String typeOfEntertainment, String days, String location, String filename, String path) {
		super();
		this.resourcename = resourcename;
		this.typeOfEntertainment = typeOfEntertainment;
		this.days = days;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}

	public entertainment(int id, String resourcename, String typeOfEntertainment, String days, String location, String filename, String path) {
		super();
		this.id = id;
		this.resourcename = resourcename;
		this.typeOfEntertainment = typeOfEntertainment;
		this.days = days;
		this.location = location;
		this.filename = filename;
		this.path = path;
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

	public String gettypeOfEntertainment() {
		return typeOfEntertainment;
	}

	public void settypeOfEntertainment(String typeOfEntertainment) {
		this.typeOfEntertainment = typeOfEntertainment;
	}

	public String getdays() {
		return days;
	}

	public void setdays(String days) {
		this.days = days;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

}
