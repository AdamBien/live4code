
package com.oraclecode.services.configuration;

import javax.enterprise.inject.spi.InjectionPoint;

public class Configurator {
    
    @javax.enterprise.inject.Produces
    public String configure(InjectionPoint ip) {
        String name = ip.getMember().getName();
        System.out.println("name = " + name);

        return System.getenv().getOrDefault(name, name + " not configured");

    }

}
