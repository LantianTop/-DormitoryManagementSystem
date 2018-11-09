package whb.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import whb.dao.StudentDao;
import whb.dao.impl.StudentDaoImpl;
import whb.domain.StudentBean;
import whb.service.StudentDaoService;

public class StudentDaoSerciceImpl implements StudentDaoService {
	private StudentDao dao = new StudentDaoImpl();
	@Override
	public boolean addStudent(StudentBean s) {
		return dao.addStudent(s);
	}

	@Override
	public boolean delStudentById(int id) {
		return dao.delStudentById(id);
	}

	@Override
	public boolean updateStudentInfoById(int id, StudentBean s) {
		return dao.updateStudentInfoById(id, s);
	}

	@Override
	public boolean updateStudentPhotoById(int id, InputStream photo) {
		try {
			return dao.updateStudentPhotoById(id, photo, photo.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StudentBean getStudentById(int id) {
		return dao.getStudentById(id);
	}

	@Override
	public List getAllStudents() {
		return dao.getAllStudents();
	}

	@Override
	public boolean isStudentExists(int id) {
		return dao.isStudentExists(id);
	}

	@Override
	public List getStudentByName(String name) {
		return dao.getStudentByName(name);
	}

	@Override
	public Map<String, Integer> getPersonNumByProvince() {
		Set<String> set = dao.getStudentsProvince();
		Map<String,Integer> map = new HashMap<String, Integer>();
		for(String province : set){
			map.put(province, dao.getPersonNum(province ));
		}
		return map;
	}

}
