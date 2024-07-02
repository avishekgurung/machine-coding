package org.avishek.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
public class Resource {
    private Long id;
    private ResourceType type;
    private String name;
    private List<Long> tags;
}
