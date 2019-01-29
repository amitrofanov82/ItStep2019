package lesson53.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSimpleExample {

	public static void main(String[] args) throws SQLException {
		//1. обратиться к драйверу, и получить соединение с БД (через СУБД)
		//DriverManager.getConnection("");
		//DriverManager.getConnection("jdbc:drivername....", "user", "password");
		//DriverManager.getConnection("", new Properties());
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/Sample2019DB", "postgres", "admin");
		System.out.println("Соединение установлено");
		
		//2. Из соеденения получить заготовку запроса
		Statement st = conn.createStatement();
		System.out.println("Заготовка запроса получена");
		
		//3. Выполнить запрос
		//ResultSet rs = st.executeQuery("SELECT * FROM users");
		st.execute("SELECT * FROM users");
		ResultSet rs = st.getResultSet();
		//st.execute("INSERT INTO users(nickname, email) VALUES('Admin', 'admin@mailspecialforadmins.com')");
		//int updatedRows = st.getUpdateCount();
		System.out.println(rs);
		//System.out.println(updatedRows);
		
		
		//4. Обработать результаты
	   ResultSetMetaData rsmd = rs.getMetaData();
	   int columnsNumber = rsmd.getColumnCount();
	   while (rs.next()) {
	       for (int i = 1; i <= columnsNumber; i++) {
	           if (i > 1) System.out.print(",  ");
	           String columnValue = rs.getString(i);
	           System.out.print(columnValue + " " + rsmd.getColumnName(i));
	       }
	       System.out.println("");
	   }
		
		
	}
	
	
}













