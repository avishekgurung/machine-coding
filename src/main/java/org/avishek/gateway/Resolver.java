package org.avishek.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class Resolver {
    private static Logger log = LogManager.getLogger(Resolver.class);

    private Repo repo;
    private Trie trie;

    public void resolve(String gateway) {
        if(gateway.contains("*")) {
            List<String> words = new ArrayList<>(Arrays.asList(gateway.split(Registration.DELIMTTER)));
            List<List<String>> results = new ArrayList<>();
            trie.wildcardManipulation(words, results);
            for(List<String> result : results) {
                String resolvedGateway = String.join(Registration.DELIMTTER, result);
                Service service = repo.getService(resolvedGateway);
                service.execute();
            }
        }
        else if(repo.getService(gateway) != null) {
            Service service = repo.getService(gateway);
            service.execute();
        } else {
            log.info("No valid gateway found!");
        }
        System.out.println("------------------");
    }

}
