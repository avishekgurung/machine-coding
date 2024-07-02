package org.avishek.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class Restaurant {
    private String name;
    private Location location;
}
