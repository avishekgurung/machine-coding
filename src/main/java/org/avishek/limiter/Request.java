package org.avishek.limiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Request {
    private static final Logger log = LogManager.getLogger(Request.class);
    private int id;
    private Tenant tenant;

    public void call() {
        log.info("Executing request {}[{}]", id, tenant.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }

}
