package whb.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import whb.domain.StudentBean;

public interface StudentDaoService {
	public boolean addStudent(StudentBean s);
	public boolean delStudentById(int id);
	public boolean updateStudentInfoById(int id,StudentBean s);
	public boolean updateStudentPhotoById(int id,InputStream photo);
	public StudentBean getStudentById(int id);
	public List getAllStudents();
	public boolean isStudentExists(int id);
	public List getStudentByName(String name);
	public Map<String,Integer> getPersonNumByProvince();
}
