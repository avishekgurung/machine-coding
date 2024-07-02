package org.avishek.splitwise;

import java.util.List;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        User u1 = new User("aman");
        User u2 = new User("sam");
        User u3 = new User("raju");
        User u4 = new User("sanju");

        Group group = new Group("PG expense");
        group.addUser(u1);
        group.addUser(u2);
        group.addUser(u3);
        group.addUser(u4);

        group.addExpense(u1, 100);
        group.addExpense(u2, 100);
        group.addExpense(u3, 100);
        //group.addExpense(u4, 100);

        Split split = new EqualSplit();
        Map<User, Integer> expense = group.getExpense();
        Map<User, List<Node>> results = split.split(expense);
        for(User user : results.keySet()) {
            List<Node> nodes = results.get(user);
            System.out.println(user.getName() + " will be paid from: ");
            for(Node node :  nodes) {
                System.out.println(node.getUser().getName() + " Rs." + node.getCost());
            }
            System.out.println();
        }
        System.out.println(results);
    }
}
