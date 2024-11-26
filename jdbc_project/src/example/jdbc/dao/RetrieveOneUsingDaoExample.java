package example.jdbc.dao;

import example.jdbc.bean.Restaurant;

public class RetrieveOneUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant, Integer> daoRef = new RestaurantDao();
		Restaurant restaurantObj = daoRef.retrieveOne(103);
		if(restaurantObj!=null)
			System.out.println(restaurantObj);
		else
			System.out.println("REstart with given ID does not exist.");
	}

}
