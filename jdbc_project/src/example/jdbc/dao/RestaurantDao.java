package example.jdbc.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//package example.jdbc.bean.Restaurant;
import java.util.Collection;

import example.jdbc.bean.Restaurant;
import example_jdbc.utils.Jdbc_Utils;
//if i called main method here then there will no changes for others like Account or employees

public class RestaurantDao implements DaoInterface<Restaurant,Integer> {

	@Override
	public Collection<Restaurant> retrieveAll() {
/*This method connects to DB , fetches all record converts them into java objects of Restaurant class,puts those objects into some 
 * collection and returns the collection
 * 
 */
		Collection <Restaurant> allRestaurants =new ArrayList<Restaurant>();
		String sqlQuery = "Select  * from restaurant_master";
		
		try {
			Connection conn = Jdbc_Utils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int restaurantId =rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				Restaurant rst=new Restaurant(restaurantId,restaurantName,restaurantCuisine,branchCount);

				allRestaurants.add(rst);
			}
			
		}
		catch(Exception ex) {

			ex.printStackTrace();

		}

		return allRestaurants;

	}


		
		
		
		public Restaurant retrieveOne(Integer id) {
			Restaurant foundRestaurant=null;
			String sqlQuery="select * from Restaurant_master where rest_id=?";
			try(
					Connection conn = Jdbc_Utils.getConnection();
					PreparedStatement pstmt =conn.prepareStatement(sqlQuery);
					){
				pstmt.setInt(1,id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					int restaurantId =rs.getInt(1);
					String restaurantName = rs.getString(2);
					int branchCount = rs.getInt(4);
					String restaurantCuisine = rs.getString(3);
					foundRestaurant =new Restaurant(restaurantId,restaurantName,restaurantCuisine,branchCount);

				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return foundRestaurant;
		}
	
}
	
