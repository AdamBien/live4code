
package be.code.chocolates.boundary;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

//@Stateless
@Path("chocolates")
public class ChocolatesResource {

    @Inject
    ChocolateStore store;

    @Resource
    ManagedExecutorService storePool;


    @GET
    public void chocolates(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(store::get).thenAccept(response::resume);
    }


}
