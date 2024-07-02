package org.avishek.fallback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FallbackManager {
    private ExecutorService executorService;

    FallbackManager() {
        executorService = Executors.newFixedThreadPool(2);
    }

    public void execute(Request request) {
        executorService.execute(new Worker(0, request));
    }

    public void shutdown() {
        this.executorService.shutdown();
    }


}
