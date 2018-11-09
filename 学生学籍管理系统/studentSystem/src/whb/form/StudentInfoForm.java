package whb.form;

import java.io.InputStream;
import java.sql.Date;

public class StudentInfoForm {

	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private String province;
	private String city;
	private Date birthday;
	private String gender;
	private boolean leagueMember;
	private boolean deleted;
	private String nation;
	
	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public StudentInfoForm() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}
        
	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isLeagueMember() {
		return leagueMember;
	}

	public void setLeagueMember(boolean leagueMember) {
		this.leagueMember = leagueMember;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
