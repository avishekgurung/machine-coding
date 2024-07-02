package org.avishek.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;

@AllArgsConstructor
@Getter
public class HotTags implements View {
    private Repository repository;
    private static final int K = 3;
    @Override
    public void display() {
        LinkedHashMap<Tag, Long> result = repository.getTopTags(K);
        System.out.println("\nThe top K tags are ...");
        for(Tag tag: result.keySet()) {
            System.out.println(tag.getName() + " : " + result.get(tag));
        }
    }
}
