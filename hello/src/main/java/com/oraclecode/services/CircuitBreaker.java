
package com.oraclecode.services;

import java.util.concurrent.atomic.AtomicLong;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class CircuitBreaker {

    AtomicLong errorCount = new AtomicLong();

    @AroundInvoke
    public Object watch(InvocationContext ic) throws Exception {
        System.out.println("method: " + ic.getMethod());
        try {
            if (errorCount.get() > 2) {
                return null;
            }
            return ic.proceed();
        } catch (Exception ex) {
            errorCount.incrementAndGet();
            throw ex;
        }
    }

}
