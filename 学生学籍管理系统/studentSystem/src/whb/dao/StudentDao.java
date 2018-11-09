package whb.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import whb.domain.StudentBean;

public interface StudentDao {
	public boolean addStudent(StudentBean s);
	public boolean delStudentById(int id);
	public boolean updateStudentInfoById(int id,StudentBean s);
	public boolean updateStudentPhotoById(int id,InputStream photo,int len);
	public StudentBean getStudentById(int id);
	public Set getStudentsProvince();
	public List getAllStudents();
	public boolean isStudentExists(int id);
	public List getStudentByName(String name);
	public int getPersonNum(String province);
}
