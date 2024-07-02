package org.avishek.splitwise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Random;

@Data
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String name;

    User(String name) {
        this.name = name;
        this.id = new Random().nextInt(10, 100);
    }
}
