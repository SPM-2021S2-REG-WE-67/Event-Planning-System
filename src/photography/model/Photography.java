package photography.model;

public class Photography{
	public int id;
	public String studioName;
	public String availableServices;
	public String location;
	public String workingdays;
	public String filename;
	public String path;

	public Photography(int id, String studioName, String availableServices, String location, String workingdays, String filename, String path) {

		super();

		this.id = id;
		this.studioName = studioName;
		this.availableServices = availableServices;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
		this.path = path;
	}

	public Photography(String studioName, String availableServices, String location, String workingdays, String filename, String path) {

		super();
		
		this.studioName = studioName;
		this.availableServices = availableServices;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
		this.path = path;
	}
	
	
	public Photography(int id, String studioName, String availableServices, String location, String workingdays) {

		super();

		this.id = id;
		this.studioName = studioName;
		this.availableServices = availableServices;
		this.location = location;
		this.workingdays = workingdays;
		
	}

	public Photography(int id, String studioName, String availableServices, String location, String workingdays, String filename) {

		super();

		this.id = id;
		this.studioName = studioName;
		this.availableServices = availableServices;
		this.location = location;
		this.workingdays = workingdays;
		this.filename = filename;
		
	}

	public Photography(String studioName, String availableServices, String location, String workingdays) {

		super();

		this.studioName = studioName;
		this.availableServices = availableServices;
		this.location = location;
		this.workingdays = workingdays;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public String getAvailableServices() {
		return availableServices;
	}
	public void setAvailableServices(String availableServices) {
		this.availableServices = availableServices;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWorkingdays() {
		return workingdays;
	}
	public void setWorkingdays(String workingdays) {
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
