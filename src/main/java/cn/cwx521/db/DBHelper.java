package cn.cwx521.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DBHelper {
	private static Properties ps;
	static {
		ps = new Properties();
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PreparedStatement getPst(String sql, Connection con) {

		try {
			return con.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static Connection getCon() {
		try {
			//properteis¿Ô√Êjiao url ƒ„–¥diver
			Class.forName(ps.getProperty("driverClassName"));
			Connection con = DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("username"),ps.getProperty("password"));
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
