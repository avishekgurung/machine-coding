package org.avishek.splitwise;

import java.util.List;
import java.util.Map;

public interface Split {
    public  Map<User, List<Node>> split(Map<User, Integer> expense);
}
