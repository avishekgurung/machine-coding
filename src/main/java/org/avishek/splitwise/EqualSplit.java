package org.avishek.splitwise;

import java.util.*;

public class EqualSplit implements Split{

    @Override
    public  Map<User, List<Node>> split(Map<User, Integer> expense) {
        int totalExpense = 0;
        int totalUsers = expense.size();
        for(User user : expense.keySet()) {
            totalExpense = totalExpense + expense.get(user);
        }

        int averageExpense = totalExpense / totalUsers;
        Queue<Node> lender = new LinkedList<>();
        Queue<Node> borrower = new LinkedList<>();


        for(User user : expense.keySet()) {
            int balance = expense.get(user) - averageExpense;
            if(balance > 0) {
                lender.add(new Node(user, balance));
            }
            else {
                borrower.add(new Node(user, Math.abs(balance)));
            }
        }

        Map<User, List<Node>> results = new HashMap<>();
        for(User user : expense.keySet()) results.put(user, new ArrayList<>());

        while(!lender.isEmpty()) {
            Node bNode = borrower.remove();
            Node lNode = lender.remove();
            int bCost = bNode.getCost();
            int lCost = lNode.getCost();

            if(lCost > bCost) {
                lNode.setCost(lCost-bCost);
                results.get(lNode.getUser()).add(bNode);
                lender.add(lNode);
            } else if (bCost == lCost) {
                results.get(lNode.getUser()).add(bNode);
            } else {
                bNode.setCost(bCost - lCost);
                borrower.add(bNode);
                results.get(lNode.getUser()).add(new Node(bNode.getUser(), lCost));
            }
        }
        return results;
    }
}
