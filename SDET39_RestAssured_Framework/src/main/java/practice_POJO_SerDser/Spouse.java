package practice_POJO_SerDser;

public class Spouse {
	String sname;
	String scompany;
	int sphno;
	
	public Spouse(String sname, String scompany, int sphno) {
	
		this.sname = sname;
		this.scompany = scompany;
		this.sphno = sphno;
	}
	public Spouse() {
		
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScompany() {
		return scompany;
	}

	public void setScompany(String scompany) {
		this.scompany = scompany;
	}

	public int getSphno() {
		return sphno;
	}

	public void setSphno(int sphno) {
		this.sphno = sphno;
	}
	
	
	
}
