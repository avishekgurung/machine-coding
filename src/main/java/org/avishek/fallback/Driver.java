package org.avishek.fallback;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Tenant t1 = new Tenant("Myntra", new ArrayList<>(Arrays.asList(1,2,3,5,8)));
        Tenant t2 = new Tenant("Flipkart", new ArrayList<>(Arrays.asList(5,5,5,5,5)));

        FallbackManager manager = new FallbackManager();

        for(int i=1; i <=20; i++) {
            Tenant tenant = i % 2 == 0 ? t1 : t2;
            Request request = new Request(i, tenant);
            manager.execute(request);
        }

    }
}
