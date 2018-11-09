package whb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection getConnection() {

		String JDriver = "com.mysql.jdbc.Driver";// SQL���ݿ�����
		String Url = "jdbc:mysql://localhost:3306/studentSystem?useUnicode=true&characterEncoding=UTF-8";// ����Դ
		String user="root";
		String password="YCL15815574612";
		try
		{
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e)
		{
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("���ݿ������ɹ�");
		try
		{
			con = DriverManager.getConnection(Url,user,password);// �������ݿ����
			System.out.println("�������ݿ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
