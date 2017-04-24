
package com.oraclecode.services;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Stateless
@Path("hello")
public class HelloResource {

    @Inject
    ServerlessHello hello;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void message(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        supplyAsync(this::get, mes).thenAccept(response::resume);
    }

    @GET
    @Path("exceptional")
    public void exceptional() {
        this.hello.exceptional();
    }


    public JsonObject get() {
        return hello.findHello().toJson();
    }


    @POST
    public void save(JsonObject input) {
        this.hello.saveHello(new Hello(input));
    }


}
