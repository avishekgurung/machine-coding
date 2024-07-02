package org.avishek.fallback;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
public class Worker implements Runnable {
    private static final Logger log = LogManager.getLogger(Worker.class);
    private int requestNumber;
    private Request request;

    @Override
    public void run() {
        while(true) {
            boolean result = request.call();
            if(result) {
                log.info("{}:{} Request successful", request.getTenant().getName(), request.getId());
                break;
            } else {
                Integer interval = request.getTenant().getNextRetryInterval(requestNumber);
                log.info("{}:{} Request failed. Retrying after {}",
                        request.getTenant().getName(), request.getId(), interval);
                requestNumber++;
                if(interval == null) {
                    log.info("{}:{} Retry exhausted", request.getTenant().getName(), request.getId());
                }
                try {
                    Thread.sleep(interval * 1000);
                } catch (InterruptedException e) {}
            }
        }
    }
}
