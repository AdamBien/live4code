
package be.code.chocolates.breaker;

import java.util.concurrent.atomic.AtomicInteger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class CircuitBreaker {

    private AtomicInteger ERRORS = new AtomicInteger();

    @AroundInvoke
    public Object watch(InvocationContext ic) throws Exception {
        try {
            if (ERRORS.get() > 3) {
                return null;
            }
            return ic.proceed();
        } catch (Exception ex) {
            ERRORS.incrementAndGet();
            throw ex;
        }
    }


}
