package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Mysql {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet result;

	public Connection MySQLConnect() {

		try {
			// Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/paquetevacacional";
			String usuario = "root";
			String pass = "";
			connection = DriverManager.getConnection(servidor, usuario, pass);

		} catch (Exception ex) {
			connection = null;
		} 
		
		return connection;
	}
}

