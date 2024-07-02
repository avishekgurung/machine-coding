package org.avishek.schedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Repo repo = new Repo();
        MeetCalendar calendar = new MeetCalendar(repo);
        UserRegistration registration = new UserRegistration(repo);

        User u1 = new User("Avishek");
        User u2 = new User("Govind");
        User u3 = new User("Vaishali");
        registration.register(u1);
        registration.register(u2);
        registration.register(u3);


        List<User> group1 = new ArrayList<>(Arrays.asList(u1, u2));
        Slot slot1 = new Slot(new SlotDate(10,00), new SlotDate(11, 00));
        Meet meet = calendar.book(group1, slot1);
        if(meet != null) {
            System.out.println(meet);
        } else {
            System.out.println("Meeting cannot be booked");
        }

        Slot slot2 = new Slot(new SlotDate(10, 30), new SlotDate(14, 00));
        meet = calendar.book(group1, slot2);
        if(meet != null) {
            System.out.println(meet);
        } else {
            System.out.println("Meeting cannot be booked");
        }


        System.out.println("\n*****************");
        System.out.println(calendar.viewCalendar(u1));

    }
}
