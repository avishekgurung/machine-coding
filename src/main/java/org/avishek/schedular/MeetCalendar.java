package org.avishek.schedular;

import java.util.ArrayList;
import java.util.List;

public class MeetCalendar {
    private Repo repo;

    MeetCalendar(Repo repo) {
        this.repo = repo;
    }

    public Meet book(List<User> users, Slot slot) {
        for(User user : users) {
            boolean feasibilityCheck = getFeasibilityCheck(repo.getBooking(user), slot);
            if(!feasibilityCheck) return null;
        }
        Meet meet = new Meet(slot, users, "ABC");
        repo.addMeet(meet);

        for(User user : users) {
            repo.addBooking(user, slot);
        }
        return meet;
    }

    private boolean getFeasibilityCheck(List<Slot> slots, Slot slot) {
        SlotDate meetStart = slot.getStart();
        SlotDate meetEnd = slot.getEnd();

        for(Slot occupied : slots) {
            SlotDate occupiedStart = occupied.getStart();
            SlotDate occupiedEnd = occupied.getEnd();
            if(meetStart.parse() > occupiedStart.parse() && meetStart.parse() < occupiedEnd.parse()) return false;
            if(meetEnd.parse() > occupiedStart.parse() && meetEnd.parse() < occupiedEnd.parse()) return false;
        }
        return true;
    }

    public Meet getMeet(Slot slot) {
        return repo.getMeet(slot);
    }

    public List<Meet> viewCalendar(User user) {
        List<Slot> slots = repo.getBooking(user);
        List<Meet> meets = new ArrayList<>();
        for(Slot slot : slots) {
            meets.add(repo.getMeet(slot));
        }
        return meets;
    }

}
