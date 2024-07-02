package org.avishek.limiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static final Logger log = LogManager.getLogger(Cache.class);
    private ConcurrentHashMap<Tenant, Integer> requestLimit;
    private ConcurrentHashMap<Tenant, Integer> requestCount;
    private static final int REFRESH_LIMIT = 1;

    Cache() {
        this.requestLimit = new ConcurrentHashMap<>();
        this.requestCount = new ConcurrentHashMap<>();
        refresh();
    }

    public boolean add(Tenant tenant) {
        this.requestLimit.put(tenant, tenant.getLimit());
        this.requestCount.put(tenant, 0);
        return true;
    }

    public boolean setCount(Tenant tenant) {
        int currentCount =  requestCount.get(tenant) + 1;
        int limit = this.requestLimit.get(tenant);
        if(currentCount > limit) return false;
        this.requestCount.put(tenant, currentCount);
        return true;
    }

    private void refresh() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    for(Tenant tenant : requestLimit.keySet()) {
                        requestCount.put(tenant, 0);
                    }
                    try { Thread.sleep(REFRESH_LIMIT * 1000);} catch (InterruptedException e) {}
                }
            }
        });
        log.info("Refreshed cache!");
        thread.start();
    }
}
