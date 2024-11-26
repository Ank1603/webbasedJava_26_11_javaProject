package example.jdbc1;


import java.util.Collection;



import example.jdbc.bean.Restaurant;

import example.jdbc.dao.DaoInterface;

import example.jdbc.dao.RestaurantDao;

public class RetrieveAllUsingDaoExample {



	public static void main(String[] args) {

	DaoInterface<Restaurant,Integer> daoRef=new RestaurantDao();

	Collection<Restaurant> allAvailableRestaurants=daoRef.retrieveAll();

	for(Restaurant currentRestaurant:allAvailableRestaurants)

		System.out.println(currentRestaurant);

	System.out.println("_________________________________________________________________________________________");

	System.out.println();

	System.out.println("By Using forEach Strim");

	System.out.println("_________________________________________________________________________________________");

	allAvailableRestaurants.stream().

	forEach(rst ->System.out.println(rst));

	System.out.println("_________________________________________________________________________________________");

	}



}