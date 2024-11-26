package example.jdbc.bean;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String Cuisine;
	private int branchCount;

	private  Restaurant() {

	}

	public Restaurant(int restaurantId, String name, String cuisine, int branchCount) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		Cuisine = cuisine;
		this.branchCount = branchCount;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return Cuisine;
	}

	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}

	public int getBranchCount() {
		return branchCount;
	}

	public void setBranchCount(int branchCount) {
		this.branchCount = branchCount;
	}

	@Override
	public String toString() {
		return "Retaurant [restaurantId=" + restaurantId + ", name=" + name + ", Cuisine=" + Cuisine + ", branchCount="
				+ branchCount + "]";
	}

}
