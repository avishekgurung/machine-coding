package org.avishek.fallback;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@AllArgsConstructor
@Data

public class Request {
    private static final Logger log = LogManager.getLogger(Request.class);
    private int id;
    private Tenant tenant;

    public boolean call() {
        int random = new Random().nextInt(1, 10);
        return random % 2 == 0;
    }
}
