package model;

public class Bean {
	private int resarve;
	private String name;
	private String tel;
	private int dating;
	private String drive;
	private String route;
	private String seanum;

	public Bean() {
	}
	
	public Bean (int resarve) {
		this.resarve=resarve;
	}

	public Bean(int resarve, String name, String tel, int dating, String drive, String route, String seanum) {
		this.resarve = resarve;
		this.name = name;
		this.tel = tel;
		this.dating = dating;
		this.drive = drive;
		this.route = route;
		this.seanum = seanum;
	}

	public int getResarve() {
		return resarve;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public int getDating() {
		return dating;
	}

	public String getDrive() {
		return drive;
	}

	public String getRoute() {
		return route;
	}

	public String getSeanum() {
		return seanum;
	}
}
