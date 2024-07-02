package org.avishek.fallback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Tenant {
    private String name;
    private List<Integer> retryInterval;

    public Integer getNextRetryInterval(int i) {
        return retryInterval.get(i);
    }

}
