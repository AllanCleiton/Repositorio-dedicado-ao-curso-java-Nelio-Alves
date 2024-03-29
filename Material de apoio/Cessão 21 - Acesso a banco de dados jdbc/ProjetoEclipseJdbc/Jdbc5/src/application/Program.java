package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegretyException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"delete from seller "
					+"where "
					+"Id = ?");
			st.setInt(1, 7);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
		}catch(SQLException e) {
			throw new DbIntegretyException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		

	}

}
