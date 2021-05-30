import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException
    {
        boolean isRestaurantFound = false;
        Restaurant restaurantFoundName = null;
        for(Restaurant restaurant: restaurants){
            if(restaurant.getName().equals(restaurantName)){
                isRestaurantFound = true;
                restaurantFoundName =  restaurant;
                break;
            }
        }
        if(isRestaurantFound){
            return  restaurantFoundName;
        }else {
            throw new restaurantNotFoundException(restaurantName);
        }
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
