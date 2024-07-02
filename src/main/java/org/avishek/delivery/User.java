package org.avishek.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class User {
    private String name;
    private Location location;
}
