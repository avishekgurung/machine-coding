package org.avishek.schedular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repo {

    private Map<User, List<Slot>> userBooking;
    private Map<Slot, Meet> meetings;

    Repo() {
        userBooking = new HashMap<>();
        meetings = new HashMap<>();
    }

    public boolean addBooking(User user, Slot slot) {
        if(!userBooking.containsKey(user)) {
            userBooking.put(user, new ArrayList<>());
        }
        userBooking.get(user).add(slot);
        return true;
    }

    public List<Slot> getBooking(User user) {
        return userBooking.get(user);
    }

    public void addMeet(Meet meet) {
        meetings.put(meet.getSlot(), meet);
    }

    public Meet getMeet(Slot slot) {
        return meetings.get(slot);
    }

    public void registerUser(User user) {
        userBooking.put(user, new ArrayList<>());
    }

}
