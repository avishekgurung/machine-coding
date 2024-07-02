package org.avishek.gateway;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
public class Service {

    private String name;
    private static Logger log = LogManager.getLogger(Service.class);

    public void execute() {
        log.info("Executing service {}", name);
    }
}
