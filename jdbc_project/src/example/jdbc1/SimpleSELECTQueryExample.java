package example.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {
//This program fires a simple SELECT query and shows the data loaded
	public static void main(String[] args) {

		// step 1] load the driver

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zomato";

		String uid = "root";
		String pwd = "password";

		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");

			// step 2]establish connection

			dbConnection = DriverManager.getConnection(url, uid, pwd);
			System.out.println("Connected to db");

			// step 3]Obtain same statement

			stmt = dbConnection.createStatement();
			System.out.println("Obtained the Stataement");

			// step 4]Execute sql Query

			String sqlQuery = "select rest_name,rest_branch_count,rest_cuisine from restaurant_master";

			// obtained Result

			rs = stmt.executeQuery(sqlQuery);
			System.out.println("Execute SQL SELECT query and obtained ResultSet"+"\n");

			// step 5]In Case SELECT Quer, obtain ResultSet and perform navigation
			while (rs.next()) {
				String restaurantName = rs.getString(1);
				int branchCount = rs.getInt(2);
				String restaurantCuisine = rs.getNString(3);
				System.out.println(restaurantName+" \t "+branchCount+ " \t "+restaurantCuisine);
			}

		} catch (ClassNotFoundException | SQLException e) {

			// e.printStackTrace();
			System.out.println("Unable to proceed");
		} finally {
			// closing all the resources: ResultSet, Statement, Connection
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
