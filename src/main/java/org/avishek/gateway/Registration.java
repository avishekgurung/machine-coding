package org.avishek.gateway;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Registration {
    private static Logger log = LogManager.getLogger(Registration.class);
    private Repo repo;
    private Trie trie;
    public static final String DELIMTTER = "/";

    public void register(String gateway) {
        Service service = new Service(gateway);
        log.info("Registerd gateway {}", gateway);
        repo.add(gateway, service);
        String[] words = gateway.split(DELIMTTER);
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        trie.add(wordList);
    }

}
