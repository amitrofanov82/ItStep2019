

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class DropTables {
	public static void main(String[] args) {
			
		InputStream is = new ByteArrayInputStream(new byte[100]);
		
		try (Connection connect =  DriverManager.getConnection
				("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "453");
				Statement statement =  connect.createStatement();) {
			
			statement.execute("DROP TABLE labels");
			statement.execute("DROP TABLE product_images");
			statement.execute("DROP TABLE subscription_list");
			statement.execute("DROP TABLE user_product_wish_relation");
			statement.execute("DROP TABLE user_profiles");
			statement.execute("DROP TABLE user_shop_assesment_relation");
			statement.execute("DROP TABLE user_user_follow_relation");
			statement.execute("DROP TABLE user_shop_management_relation");
			statement.execute("DROP TABLE products");
			statement.execute("DROP TABLE shops");
			statement.execute("DROP TABLE users");
			statement.execute("DROP TABLE shop_templates");
		} catch (SQLException e) {
			System.out.println("SQL error!!!");
		}

	}
}