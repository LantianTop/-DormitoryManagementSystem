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

		String JDriver = "com.mysql.jdbc.Driver";// SQL数据库引擎
		String Url = "jdbc:mysql://localhost:3306/studentSystem?useUnicode=true&characterEncoding=UTF-8";// 数据源
		String user="root";
		String password="YCL15815574612";
		try
		{
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e)
		{
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
		try
		{
			con = DriverManager.getConnection(Url,user,password);// 连接数据库对象
			System.out.println("连接数据库成功");
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
