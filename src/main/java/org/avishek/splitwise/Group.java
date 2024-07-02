package org.avishek.splitwise;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class Group {
    private int id;
    private String name;
    private Map<User, Integer> expense;

    public Group(String name) {
        this.name = name;
        this.id = new Random().nextInt(100, 1000);
        this.expense = new HashMap<>();
    }

    public boolean addUser(User user) {
        expense.put(user, 0);
        return true;
    }

    public boolean addExpense(User user, int sum) {
        expense.put(user, expense.get(user) + sum);
        return true;
    }
}
