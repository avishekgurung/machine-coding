package org.avishek.gateway;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Data
public class Node {
    private String data;
    private Map<String, Node> nodes;
    private boolean isEnd;

    Node(String data) {
        this.data = data;
        this.nodes = new HashMap<>();
        isEnd = false;
    }

}
