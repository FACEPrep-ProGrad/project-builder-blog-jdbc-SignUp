package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		//loadproperties file.
		Properties p = loadPropertiesFile();
		Connection con  = null;
		Class.forName(p.getProperty("driver"));
		con = DriverManager.getConnection(p.getProperty("url"));
		return con;
		
	}
	

	private static Properties loadPropertiesFile() throws IOException {
		// TODO Auto-generated method stub
		
		Properties p = new Properties();
		//getting all the jdbc property
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties"); 
		p.load(in);
		in.close();
		return p;
		}
}

