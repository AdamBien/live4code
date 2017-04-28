
package com.oraclecode.services;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
@Interceptors(CircuitBreaker.class)
public class ServerlessHello {

    @Inject
    String message;

    public void exceptional() {
        System.out.println("message = " + message);
        throw new ServerUnstableException("unstable in " + message);
    }

    public Hello findHello() {
        return new Hello("duke");
    }

    public void saveHello(Hello hello) {

    }



}
