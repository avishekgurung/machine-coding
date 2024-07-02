package org.avishek.delivery;

import org.avishek.delivery.User;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Restaurant r1 = new Restaurant("Taj", new Location(1,1));
        Restaurant r2 = new Restaurant("Punjab Grill", new Location(2,2));
        Restaurant r3 = new Restaurant("Y2J", new Location(0,1));
        Restaurant r4 = new Restaurant("Momo Hut", new Location(3,1));
        Restaurant r5 = new Restaurant("Truffles", new Location(3,3));

        User user = new User("Avisdhek", new Location(3,3));

        Repo repo = new Repo();
        repo.addRestaurants(r1);
        repo.addRestaurants(r2);
        repo.addRestaurants(r3);
        repo.addRestaurants(r4);
        repo.addRestaurants(r5);

        List<Restaurant> restaurants = repo.getRestaurants(user.getLocation(), 1);
        for(Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
        System.out.println(repo.isAccessible(r1, user.getLocation(), 2));
    }
}
