1package whb.dao.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import whb.dao.StudentDao;
import whb.domain.StudentBean;
import whb.util.BeanUtil;
import whb.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean addStudent(StudentBean s) {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("insert into studentTable values(null,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, s.getName());
			pst.setString(2, s.getGender());
			pst.setString(3, s.getProvince());
			pst.setString(4, s.getCity());
			pst.setDate(5, s.getBirthday());
			pst.setBoolean(6, s.isLeagueMember());
			/*������*/
			if(s.getPhoto()!=null){
				pst.setBinaryStream(7, s.getPhoto(), s.getPhoto().available());
			}else{
				FileInputStream image = new FileInputStream("E://"+"1.jpeg");
				pst.setBinaryStream(7, image,image.available());
			}
			pst.setString(8, s.getNation());
			pst.setBoolean(9, s.isDeleted());
			pst.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delStudentById(int id) {
		try{
			//UPDATE `201141402403userTable` SET  username=
			boolean del = true;
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("UPDATE studentTable SET deleted ="+ del +" where id=? ");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStudentInfoById(int id,StudentBean s) {
		try{
			//UPDATE `201141402403userTable` SET  username=
			boolean del = true;
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement(
					"UPDATE studentTable SET name = ?,gender = ? , province = ?" +
					", city = ? , birthday = ? , leagueMember = ?,nation = ?" +
					" where id=? ");
			pst.setString(1, s.getName());
			pst.setString(2, s.getGender());
			pst.setString(3, s.getProvince());
			pst.setString(4, s.getCity());
			pst.setDate(5, s.getBirthday());
			pst.setBoolean(6, s.isLeagueMember());
			pst.setString(7, s.getNation());
			pst.setInt(8, id);
			pst.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StudentBean getStudentById(int id) {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select * from studentTable where id=?");
			pst.setInt(1, id);
			StudentBean s = null;
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()){
				s = new StudentBean();
				setStudentBean(s, rs);
			}
			return s;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set getStudentsProvince() {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select province from studentTable where deleted=false");
			StudentBean s = null;
			Set set = new HashSet();
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()){
				set.add(rs.getString("province"));
			}
			return set;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List getAllStudents() {
		
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select * from studentTable where deleted=false");
			StudentBean s = null;
			List list = new ArrayList();
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()){
				s =  new StudentBean();
				setStudentBean(s, rs);
				list.add(s);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}

	private void setStudentBean(StudentBean s, ResultSet rs)
			throws SQLException {
		s.setBirthday(rs.getDate("birthday"));
		s.setCity(rs.getString("city"));
		s.setDeleted(rs.getBoolean("deleted"));
		s.setGender(rs.getString("gender"));
		s.setId(rs.getInt("id"));
		s.setLeagueMember(rs.getBoolean("leagueMember"));
		s.setName(rs.getString("name"));
		s.setProvince(rs.getString("province"));
		s.setPhoto(rs.getBlob("photo").getBinaryStream());
		s.setNation(rs.getString("nation"));
	}

	@Override
	public boolean isStudentExists(int id) {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select * from studentTable where id=?");
			pst.setInt(1, id);
			int flag = -1;
			ResultSet rs = pst.executeQuery();
			return rs.next();
		}catch(SQLException e){
			e.printStackTrace();
		}	
			return false;
	}

	@Override
	public boolean updateStudentPhotoById(int id,InputStream photo,int len) {

		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement(
					"UPDATE studentTable SET photo = ? where id=? ");
			pst.setBinaryStream(1, photo, len);
			pst.setInt(2, id);
			pst.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List getStudentByName(String name) {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select * from studentTable where deleted=false and name=?");
			pst.setString(1,name);
			StudentBean s = null;
			List list = new ArrayList();
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()){
				s =  new StudentBean();
				setStudentBean(s, rs);
				list.add(s);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public int getPersonNum(String province) {
		try{
			PreparedStatement pst = new JDBCUtil().getConnection().prepareStatement("select id from studentTable where deleted=false and province = ?");
			pst.setString(1,province);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			int num = 0;
			while(rs.next()){
				num++;
			}
			return num;
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}		
	}

}
