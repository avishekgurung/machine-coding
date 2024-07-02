package org.avishek.schedular;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SlotDate {
    private int hour;
    private int min;

    public int parse() {
        return this.hour * 60 + this.min;
    }

    public String toString() {
        return hour + ":" + min;
    }

}
