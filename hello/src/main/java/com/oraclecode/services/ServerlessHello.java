
package com.oraclecode.services;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
@Interceptors(CircuitBreaker.class)
public class ServerlessHello {

    public void exceptional() {
        throw new ServerUnstableException("unstable in london");
    }

    public Hello findHello() {
        return new Hello("duke");
    }

    public void saveHello(Hello hello) {

    }



}
