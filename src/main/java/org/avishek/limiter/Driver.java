package org.avishek.limiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        Tenant t1 = new Tenant("Myntra", 2);
        Tenant t2 = new Tenant("Flipkart", 3);

        Cache cache = new Cache();
        cache.add(t1);
        cache.add(t2);

        RateLimiter rateLimiter = new RateLimiter(cache);
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        for(int i=1; i <= 200; i++) {
            Tenant tenant = i%2 == 0 ? t1 : t2;
            Request request = new Request(i, tenant);
            //Request request = new Request(i, t1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rateLimiter.execute(request);
                }
            });
        }
        executorService.shutdown();
    }
}
