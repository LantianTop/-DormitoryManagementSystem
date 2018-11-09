package whb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import whb.dao.StudentDao;
import whb.dao.impl.StudentDaoImpl;
import whb.domain.StudentBean;
import whb.util.JDBCUtil;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
//		testUpdate();
//		testGet();
//		testAdd();
//		testDel();
//		StudentDao dao = new StudentDaoImpl();
//		FileInputStream image = new FileInputStream("E://"+"1.jpeg");
//		dao.updateStudentPhotoById(20114140, image,image.available());
//		StudentDao dao = new StudentDaoImpl();
//		Set<String> set = dao.getStudentsProvince();
//		for(String s : set){
//			System.out.println(s+" = ");
//			System.out.println(dao.getPersonNum(s));
//		}
//		System.out.println();
//		System.out.println();
		testJDBCUtil();
	}

	private static void testUpdate() throws FileNotFoundException {
		StudentDao dao = new StudentDaoImpl();
		StudentBean s = new StudentBean();
		for(int i=0;i<20;i++){
			
		}
		s.setBirthday(new Date(System.currentTimeMillis()));
		s.setCity("汕头");
		s.setDeleted(false);
		s.setGender("男");
		s.setId(20114140);
		s.setLeagueMember(true);
		s.setName("王维");
		s.setProvince("广东省");
//		dao.updateStudentPhotoById(20114140, null,0);
//		dao.updateStudentInfoById(20114140,s);
//		System.out.println(s.isDeleted());
	}

	private static void testDel() {
		StudentDao dao = new StudentDaoImpl();
		StudentBean s = null;
		s = dao.getStudentById(20114140);
		System.out.println(s.isDeleted());
//		System.out.println("删除以后---------");
//		dao.delStudentById(20114140);
//		s = dao.getStudentById(20114140);
//		System.out.println(s.isDeleted());

	}

	private static void testGet() throws FileNotFoundException, IOException {
		StudentDao dao = new StudentDaoImpl();
		StudentBean s = null;
		s = dao.getStudentById(20114140);
		System.out.println(s.getPhoto());
//		FileOutputStream out = new FileOutputStream("E://2.jpeg");
//		byte[] buf = new byte[1024];
//		int temp = 0;
//		while((temp=s.getPhoto().read(buf))!=-1){
//			out.write(buf);
//		}
	}

	private static void testAdd() throws FileNotFoundException {
		StudentBean s = new StudentBean();
		s.setBirthday(new Date(System.currentTimeMillis()));
		for(int i=1; i<10 ; i++){
			s.setCity("汕头市");
			s.setDeleted(false);
			s.setGender("男");
			s.setId(20114180+i);
			s.setLeagueMember(true);
			s.setName("大学生"+i);
			s.setProvince("广东省");
			s.setPhoto(null);
			FileInputStream image = new FileInputStream("E://"+"1.jpeg");
			s.setPhoto(image);
			StudentDao dao = new StudentDaoImpl();
			dao.addStudent(s);
		}
	}
	
	private static void testJDBCUtil(){
		
		Connection cc= (Connection) new JDBCUtil().getConnection();
		
	}

}
