
package be.code.chocolates.boundary;

import be.code.chocolates.breaker.CircuitBreaker;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;

@ApplicationScoped
@Interceptors(CircuitBreaker.class)
public class ChocolateStore {

    public String get() {
        return "delicious";
    }

}
