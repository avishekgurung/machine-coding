package org.avishek.delivery;

import java.util.*;

public class Repo {
    private Map<Location, List<Restaurant>> locationRestaurantMap;
    private Map<Restaurant, Location> restaurantLocationMap;
    private int locations[][];

    Repo() {
        this.locationRestaurantMap = new HashMap<>();
        this.restaurantLocationMap = new HashMap<>();
        locations = new int[1000][1000];
    }

    public boolean addRestaurants(Restaurant restaurant) {
        Location location = restaurant.getLocation();
        if(locationRestaurantMap.containsKey(location)) {
            locationRestaurantMap.get(location).add(restaurant);
        } else {
            locationRestaurantMap.put(location, new ArrayList<>(Arrays.asList(restaurant)));
        }
        restaurantLocationMap.put(restaurant, location);
        int lat = location.getLat();
        int lng = location.getLng();
        locations[lat][lng] = 1;
        return true;
    }

    public List<Restaurant> getRestaurants(Location location, int R) {
        int lat = location.getLat();
        int lng = location.getLng();
        int startI = lat - R;
        int startJ = lng - R;
        int endI = lat + R;
        int endJ = lng + R;
        List<Restaurant> selectedRestaurants = new ArrayList<>();

        for(int i=startI; i <= endI; i++) {
            for(int j=startJ; j <= endJ; j++) {
                Location loc = new Location(i, j);
                if(locationRestaurantMap.containsKey(loc)) {
                    selectedRestaurants.addAll(locationRestaurantMap.get(loc));
                }
            }
        }
        return selectedRestaurants;
    }

    public boolean isAccessible(Restaurant restaurant, Location userLocation, int R) {
        Location restaurantLocation = restaurant.getLocation();
        int x = (userLocation.getLat() - restaurantLocation.getLat());
        int y = (userLocation.getLng() - restaurantLocation.getLng());
        int z = x + y;
        int distance = (int) Math.sqrt(z);
        return distance <= R;
    }



}
