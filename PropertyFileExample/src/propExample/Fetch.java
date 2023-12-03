package propExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fetch {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_props", "root", "root");
			pst = con.prepareStatement("select * from student");
			boolean b = pst.execute();
			rst = pst.getResultSet();
			if (b) {

				while (rst.next()) {
					System.out.println(rst.getInt("id"));
					System.out.println(rst.getString("name"));
					System.out.println(rst.getInt("age"));
					System.out.println(rst.getLong("mobile"));
					System.out.println("------------------------");
				}

			} else {
				System.out.println("plese write a select query");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
					System.out.println("ResultSet Closed");
				}
				if (pst != null) {
					pst.close();
					System.out.println("Prepared Statement closed");
				}
				if (con != null) {
					con.close();
					System.out.println("Connection closed");
				}
				System.out.println("Costly Resource closed");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
