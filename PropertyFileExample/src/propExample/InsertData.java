package propExample;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class InsertData {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\saswa\\Desktop\\OOPS\\PropertyFileExample\\lib\\jdbc.properties");
			Properties p = new Properties();
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			// Connection con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"), p.getProperty("password"));
			Connection con = DriverManager.getConnection(p.getProperty("url"), p);
			PreparedStatement pst = con.prepareStatement("insert into student(id,name,age,mobile) values(?,?,?,?)");
			// PreparedStatement pst=con.prepareStatement(p.getProperty("insert"));
			pst.setInt(1, 4);
			pst.setString(2, "SASWAT");
			pst.setInt(3, 23);
			pst.setLong(4, 7327858936l);
			int n = pst.executeUpdate();
			System.out.println(n + " rows updated");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
