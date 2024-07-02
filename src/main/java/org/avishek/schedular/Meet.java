package org.avishek.schedular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
public class Meet {
    private Slot slot;
    private List<User> participants;
    private String room;
}
