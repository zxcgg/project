package cn.cwx521.untils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cn.cwx521.db.DBHelper;

public class JDBCUtils {
	public static int executeUpdate(String sql, Object... object) {
		Connection con = (Connection) DBHelper.getCon();
		PreparedStatement ps = DBHelper.getPst(sql, con);
		try {
			for (int i = 0; i < object.length; i++) {
				ps.setObject(i + 1, object[i]);
			}
			return ps.executeUpdate();// Ö´ÐÐsql
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(con, ps, null);
		}
		return -1;
	}
}
