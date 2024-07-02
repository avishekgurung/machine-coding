package org.avishek.system;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        /**
         * DI
         */
        Repository repository = new Repository();
        View topTags = new HotTags(repository);



        Tag java = new Tag(getId(), "Java");
        Tag python = new Tag(getId(), "python");
        Tag go = new Tag(getId(), "go");
        Tag javascript = new Tag(getId(), "javascript");
        repository.addTag(java);
        repository.addTag(python);
        repository.addTag(go);
        repository.addTag(javascript);

        Resource resource1 = new Resource(getId(), ResourceType.CONFLUENCE, "r1",
                new ArrayList<>(Arrays.asList(java.getId())));
        repository.addResource(resource1);

        Resource resource2 = new Resource(getId(), ResourceType.CONFLUENCE, "r2",
                new ArrayList<>(Arrays.asList(java.getId(), python.getId())));
        repository.addResource(resource2);

        Resource resource3 = new Resource(getId(), ResourceType.CONFLUENCE, "r3",
                new ArrayList<>(Arrays.asList(go.getId(), python.getId())));
        repository.addResource(resource3);

        Resource resource4 = new Resource(getId(), ResourceType.CONFLUENCE, "r3",
                new ArrayList<>(Arrays.asList(go.getId(), python.getId(), java.getId())));
        repository.addResource(resource4);

        topTags.display();

        repository.tagResource(resource3, new ArrayList<>(Arrays.asList(java, javascript)));
        topTags.display();

        System.out.println(repository.getResourceForTag(java.getId()));

    }

    private static Long getId() {
        return System.currentTimeMillis() + new Random().nextLong(1000, 100000);
    }
}
