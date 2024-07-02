package org.avishek.gateway;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Repo {

    private Map<String, Service> gatewayToServiceMap;

    Repo() {
        gatewayToServiceMap = new HashMap<>();
    }

    public boolean add(String gateway, Service service) {
        gatewayToServiceMap.put(gateway, service);
        return true;
    }

    public Service getService(String gateway) {
        return gatewayToServiceMap.get(gateway);
    }

}
