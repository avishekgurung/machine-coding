package org.avishek.schedular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Slot {
    private SlotDate start;
    private SlotDate end;
}
