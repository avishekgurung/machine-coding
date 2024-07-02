package org.avishek.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Node {
    private Long id;
    private Long count;

    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof  Node)) return false;
        Node that = (Node) o;
        return this.id == that.id;
    }

}
