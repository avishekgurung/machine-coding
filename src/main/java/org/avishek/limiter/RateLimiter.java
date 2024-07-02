package org.avishek.limiter;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
public class RateLimiter {
    private static Logger log = LogManager.getLogger(RateLimiter.class);
    private Cache cache;

    public void execute(Request request) {
        boolean result = cache.setCount(request.getTenant());
        if(!result) {
            log.info("Could not fulfill request {}[{}]", request.getId(), request.getTenant().getName());
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        } else {
            request.call();
        }
    }

}
